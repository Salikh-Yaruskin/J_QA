package lection_6;

import com.codeborne.selenide.Configuration;
import org.lection_6.pages.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


public class SimbirSoftTests {

    @BeforeClass
    void init() {
        Configuration.baseUrl = "https://www.simbirsoft.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 30000;
    }

    @Test(description = "Проверяем работоспособность кнопки обратной связи")
    public void feedbackModelOpenTest() {
        open(Configuration.baseUrl);
        page(MainPage.class)
                .showFeedbackModel()
                .checkModelWindowVisible()
                .checkInputTextName();
        sleep(1000);
    }

    @Test(description = "Проверка работоспособности открытия страницы Контактов")
    public void openContactPage(){
        open(Configuration.baseUrl);
        page(MainPage.class)
                .getContactPage()
                .contactsPageIsOpen();

        sleep(1000);
    }
}
