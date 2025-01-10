package org.lection_6.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class FeedbackModel {

    final String FEEDBACK_MODEL = "//*[@class='fmo-parent']//*[@class='fb-modal-default']";

    @FindBy(xpath = FEEDBACK_MODEL)
    private SelenideElement feedbackModelWindow;

    @FindBy(xpath = FEEDBACK_MODEL + "//input[@data-clear='text']/../..")
    private SelenideElement textInputName;

    @Step("Проверка отображается ли модальное окно")
    public FeedbackModel checkModelWindowVisible(){
        feedbackModelWindow.shouldBe(visible);
        return this;
    }

    @Step("Проверка на поле ввода")
    public FeedbackModel checkInputTextName(){
        textInputName.shouldHave(text("Имя или организация"));
        return this;
    }
}
