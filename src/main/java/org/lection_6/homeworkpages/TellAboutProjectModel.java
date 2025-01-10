package org.lection_6.homeworkpages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class TellAboutProjectModel {

    final String TAP_MODEL = "//*[@class='container']//*[@class='styles_form__Lk52K']";

    @FindBy(xpath = TAP_MODEL)
    private SelenideElement showTAPModel;

    @FindBy(xpath = TAP_MODEL + "//*[@class='styles_wrap__qbb_J']//input[@name='name']")
    private SelenideElement inputField;

    public TellAboutProjectModel checkShowModel(){
        showTAPModel
                .shouldBe(visible);

        return this;
    }

    public TellAboutProjectModel checkInputName(){
        inputField
                .shouldBe(visible)
                .setValue("Salikh");
        return this;
    }
}
