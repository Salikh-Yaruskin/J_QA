package org.lection_6.homeworkpages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class VacanciesPage {

    @FindBy(xpath = "//*[@class='section-mb']//*[@class='styles_vacancies__XpGsG']//*[@class='styles_vacancies__item__DxIBE']")
    private SelenideElement fieldOpenRecruiterPage;

    @FindBy(xpath = "//div[@class='container']//*[@class='styles_link__B8Hcb']")
    private SelenideElement buttonMoreAboutBonus;

    public VacanciesPage openVacanciesPage(){
        webdriver().shouldHave(url("https://promo-z.ru/vacancies"));

        return this;
    }

    public RecruiterPage checkOpenRecruiterPage(){
        fieldOpenRecruiterPage
                .shouldBe(visible)
                .click();

        return page(RecruiterPage.class);
    }

    public ItBonusPage checkOpenItBonusPage(){
        buttonMoreAboutBonus
                .shouldBe(visible)
                .shouldHave(text("Подробнее"))
                .click();

        return page(ItBonusPage.class);
    }
}
