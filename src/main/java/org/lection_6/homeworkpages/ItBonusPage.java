package org.lection_6.homeworkpages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class ItBonusPage {

    @FindBy(xpath = "//div[@class='container']//*[@class='styles_help-block__btn-arrow__MO5Zq']")
    private SelenideElement fieldReturnToVacanciesPage;

    public ItBonusPage openItBonusPage(){
        webdriver().shouldHave(url("https://promo-z.ru/it-bonus"));

        return this;
    }

    public VacanciesPage returnToVacanciesPage(){
        fieldReturnToVacanciesPage
                .shouldBe(visible)
                .click();

        return page(VacanciesPage.class);
    }
}
