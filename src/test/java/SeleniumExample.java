import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;


public class SeleniumExample {

    private static Logger logger = LoggerFactory.getLogger(SeleniumExample.class);

    @BeforeClass
    public void init() {
        Configuration.baseUrl = "https://www.simbirsoft.com/";
    }

    @Test
    public void test1() {
        open(Configuration.baseUrl);
        $(By.cssSelector("a[data-gclick='showModalFeedback']"))
                .shouldBe(visible)
                .shouldHave(text("Написать нам"))
                .click();
        sleep(3000);
        $x("//*[@class='fmo-parent']//*[@class='fb-modal-default']//*[@class='fmo-cross fmo-close']").shouldHave(visible).click();
        sleep(5000);
        logger.info("Тест завершен");
    }

    @Test
    public void test2() {
        open(Configuration.baseUrl);
        $x("//*[contains(@class,'gh-nav-item--about')]")
                .shouldHave(text("О нас"))
                .hover();
        $(By.linkText("Контакты"))
                .shouldHave(text("Контакты"))
                .click();
        $x("//h1")
                .shouldHave(text("Контакты"))
                .shouldHave(visible);
        webdriver().shouldHave(url("https://www.simbirsoft.com/contacts/"));
        sleep(5000);
    }
}
