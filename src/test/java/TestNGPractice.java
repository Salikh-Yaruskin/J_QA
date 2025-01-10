import org.lection_1.Tank;
import org.lection_4.Students;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class TestNGPractice {

    private int count;
    private final String LOGIN = "user";
    private final int PASSWORD = 12345;
    private Tank tank;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        count = 5;
    }

    @Test(groups = "firstTest")
    public void calc_two_number(){
        assertEquals(count + 5, 10, "Sum is wrong");
    }

    @Test(description = "Использую сузность из первой дз для тестирования работоспособности функции обновления брони")
    public void upgrade_armor(){
        tank = new Tank("ABV", "Tiget", 123, 44, 90, "RB-100", 10, 10);
        tank.upgradeArmor();
        assertEquals(tank.getArmor(), 200, "Error test!");
    }

    @Test
    @Parameters({"name", "password"})
    public void login_test(String name, int password){
        assertEquals(name, LOGIN, "User with this login not found");
        assertEquals(password, PASSWORD, "Password was wrong");
    }

    @DataProvider(name = "users")
    public Object[][] providerData(){
        return new Object[][]{
                {"user", 12345}
        };
    }

    @Test(dataProvider = "users", enabled = true)
    public void data_provider_test(String name, int password){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(name, LOGIN, "ERROR LOGIN");
        softAssert.assertEquals(password, PASSWORD, "ERROR PASSWORD");
        softAssert.assertAll();
    }
}
