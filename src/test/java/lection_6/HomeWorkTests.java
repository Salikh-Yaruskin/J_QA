package lection_6;

import com.codeborne.selenide.Configuration;
import org.lection_6.homeworkpages.MainHomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class HomeWorkTests {

    @BeforeClass
    void init() {
        Configuration.baseUrl = "https://promo-z.ru/";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 50000;
    }

    @Test(description = "Проверка открытия модального окна на главной странице")
    public void checkShowTAPModel() {
        open(Configuration.baseUrl);
        page(MainHomePage.class)
                .showTLPModel()
                .checkShowModel()
                .checkInputName();
        sleep(5000);
    }

    @Test(description = "Проврека страницы для Тестироващиков QA")
    public void openTestingPage() {
        open(Configuration.baseUrl);
        page(MainHomePage.class)
                .checkOpenTestingPage()
                .openTestingPage()
                .clickToButton()
                .checkPropertyFormSectionMb();
        sleep(5000);
    }

    @Test(description = "Проверка сайта с вакансиями")
    public void checkPageWithVacancies() {
        open(Configuration.baseUrl);
        page(MainHomePage.class)
                .checkOpenPageWithVacancies()
                .openVacanciesPage()
                .checkOpenRecruiterPage()
                .openRecruiterPage()
                .returnToVacanciesPage()
                .checkOpenItBonusPage()
                .openItBonusPage()
                .returnToVacanciesPage();

        sleep(5000);
    }

}
