package org.lection_7;

import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.openqa.selenium.devtools.v85.io.IO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class WorkWithJDBC {
    private static final Logger logger = LoggerFactory.getLogger(WorkWithJDBC.class);
    public static void main(String[] args) throws IOException {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/errorsdb", "postgres", "password")
                .load();

        flyway.migrate();

        DataSource dataSource = createDataSource();

        try(Connection connection = dataSource.getConnection()) {
            logger.info("Соединение установлено: {}", connection.isValid(100));
            connection.setAutoCommit(false);

            try {
                //insertRequestFromFile(connection, "src/main/resources/insertExample.sql");
                //insertRequest(connection, "Method Not Allowed", "405");
                //updateRequest(connection, "Error password", 1);
                //deleteRequest(connection, 5);

                selectRequest(connection);

                connection.commit();
                logger.info("Транзакция успешна применина!");

            } catch (SQLException e) {
                logger.error("Транзакция отменена: {}", e.getMessage());
                connection.rollback();
            }

        } catch (SQLException e){
            logger.error("Соединение не установлено: {}", e.getMessage());
        }
    }

    private static void selectRequest(Connection connection) throws SQLException{
        String quire = "SELECT * FROM errors";
        try(PreparedStatement ps = connection.prepareStatement(quire)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("code"));
        }
    }

    private static void insertRequest(Connection connection, String name, String code) throws SQLException{
        String quire = "INSERT INTO errors (name, code) VALUES (?, ?)";
        try(PreparedStatement ps = connection.prepareStatement(quire)){
            ps.setString(1, name);
            ps.setString(2, code);
            ps.executeUpdate();
            logger.info("Ошибка с именем {} добавлена и ей присвоен номер {}", name, code);
        }
    }

    private static void updateRequest(Connection connection, String name, int id) throws SQLException{
        String quire = "UPDATE errors SET name = ? WHERE id = ?";
        try(PreparedStatement ps = connection.prepareStatement(quire)){
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
            logger.info("Изменены данные с именем {}", name);
        }
    }

    private static void deleteRequest(Connection connection, int id) throws SQLException{
        String quire = "DELETE FROM errors WHERE id = ?";
        try(PreparedStatement ps = connection.prepareStatement(quire)){
            ps.setInt(1, id);
            ps.executeUpdate();
            logger.info("Ошибка с номером {} удалена", id);
        }
    }

    private static void insertRequestFromFile(Connection connection, String filePath) throws SQLException, IOException {
        String sql = Files.readString(Paths.get(filePath));

        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.executeUpdate();
            logger.info("Запросы из файла выполены!");
        }
    }

    private static DataSource createDataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/errorsdb");
        ds.setUsername("postgres");
        ds.setPassword("password");
        return ds;
    }
}
