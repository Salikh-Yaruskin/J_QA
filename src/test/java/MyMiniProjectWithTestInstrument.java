import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.testng.Assert.assertEquals;

public class MyMiniProjectWithTestInstrument {
    private static Logger logger = LoggerFactory.getLogger(MyMiniProjectWithTestInstrument.class);

    @BeforeClass
    public void init() {
        Configuration.baseUrl = "https://promo-z.ru/";
    }

    @Test
    public void test1() {
        logger.info("Открываем сайт PromoIt", Configuration.baseUrl);
        open(Configuration.baseUrl);

        logger.info("Ищем в хедере 'Вакансии'");
        $x("//*[@class='styles_menu__LbdS4']//li[a[text()='Вакансии']]")
                .shouldBe(visible)
                .shouldHave(text("Вакансии"))
                .click();

        webdriver().shouldHave(url("https://promo-z.ru/vacancies"));

        logger.info("Открыл вкладку вакансий");
        $x("//*[@class='styles_form__LDqFC']//div[@class='styles_item__6Fc5O']//div[@class='styles_formRow__Fcb3G']//input[@name='name']")
                .shouldBe(visible)
                .setValue("Владимир");
        $x("//*[@class='styles_form__LDqFC']//div[@class='styles_item__6Fc5O']//div[@class='styles_formRow__Fcb3G']//textarea[@name='description']")
                .shouldBe(visible)
                .setValue("Хочу работу");
        $x("//*[@class='styles_form__LDqFC']//div[@class='styles_item__6Fc5O']//button[@class='styles_button__w5lk4 styles_btn__7Q6Xs']")
                .shouldBe(visible)
                .shouldHave(text("Отправить"))
                .click();

        logger.info("Заполнил некоторые поля формы");

        sleep(5000);
    }

    @Test
    public void test2() {
        logger.info("Открываем сайт PromoIt", Configuration.baseUrl);
        open(Configuration.baseUrl);

        logger.info("Ищем в хедере 'Проекты'");
        $x("//*[@class='styles_menu__LbdS4']//li[a[text()='Проекты']]")
                .shouldBe(visible)
                .shouldHave(text("Проекты"))
                .click();

        logger.info("Переходим к одному из проектов");
        SelenideElement parent =  $x("//*[@class='container']//a[@class='styles_project__pKuRm' and @href='/projects#']//div[@class='styles_project__text__VTZuA'][.//div[@class='styles_project__title__ixTz6' and text()='CRM-система для сети складов']]")
                .shouldHave(visible)
                .scrollTo();
        SelenideElement childFirst = parent.
                $x(".//div[@class='styles_project__title__ixTz6']")
                        .shouldHave(text("CRM-система для сети складов"));

        String textCRMSystem = childFirst.getText();
        logger.debug("Полученный текст: '{}'", textCRMSystem);

        logger.info("Проверка на соответсвие текста");
        assertEquals(textCRMSystem, "CRM-система для сети складов", "Текст не совпадает!(");
        logger.info("Тест пройдет успешно");

        sleep(5000);
    }
}
