package org.lection_6.homeworkpages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class RecruiterPage {

    @FindBy(xpath = "//*[@class='styles_vacancies__link__X4nlU']")
    private SelenideElement fieldReturnToVacanciesPage;

    public RecruiterPage openRecruiterPage(){
        webdriver().shouldHave(url("https://promo-z.ru/vacancies/recruiter"));

        return this;
    }

    public VacanciesPage returnToVacanciesPage(){
        fieldReturnToVacanciesPage
                .shouldBe(visible)
                .shouldHave(text("Все вакансии"))
                .click();

        return page(VacanciesPage.class);
    }
}
