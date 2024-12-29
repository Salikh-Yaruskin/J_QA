package org.lection_6.homeworkpages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;


public class TestingPage {

    @FindBy(xpath = "//*[@class='styles_wrapper__LHaOu']//*[@class='styles_header__ZI2Bg' and .//h4[text()='Используем все виды тестирования']]")
    private SelenideElement buttonClickToFirstButton;

    @FindBy(xpath = "//*[@class='section-mb']//*[@class='styles_button__w5lk4 styles_btn__YFI8I']")
    private SelenideElement sendButton;

    @FindBy(xpath = "//*[@class='section-mb']//*[@class='styles_formRow__1egH4']//*[@class='styles_checkbox__4kEZH']//input[@name='policy']")
    private SelenideElement checkButton;

    public TestingPage openTestingPage(){
        webdriver().shouldHave(url("https://promo-z.ru/testing"));

        return this;
    }

    public TestingPage clickToButton(){
        buttonClickToFirstButton
                .shouldBe(visible)
                .highlight()
                .click();

        return this;
    }

    public TestingPage checkPropertyFormSectionMb(){
        checkButton
                .shouldBe(visible);

        if(!checkButton.isSelected())
            checkButton.click();

        sendButton
                .shouldBe(visible, enabled)
                .shouldHave(text("Отправить"), cssClass("styles_button__w5lk4"))
                .click();

        return this;
    }
}
