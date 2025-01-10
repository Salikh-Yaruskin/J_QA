package org.lection_6.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    @FindBy(xpath = "//*[@class='gh-tools-feedback write-to-us']")
    private SelenideElement feedbackButton;

    @FindBy(xpath = "//*[contains(@class, 'gh-nav-item--about')]")
    private SelenideElement navItemMenu;

    @Step("Открытие модального окна")
    public FeedbackModel showFeedbackModel(){
        feedbackButton
                .shouldBe(exist)
                .shouldBe(visible)
                .shouldHave(text("Написать нам"))
                .click();
        return page(FeedbackModel.class);
    }

    @Step("Открытие старницы Контакты")
    public ContactsPage getContactPage(){
        navItemMenu
                .shouldBe(visible)
                .shouldHave(text("О нас"))
                .hover();
        $(By.linkText("Контакты"))
                .shouldHave(text("Контакты"))
                .click();

        return page(ContactsPage.class);
    }
}
