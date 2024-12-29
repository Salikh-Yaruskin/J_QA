package org.lection_6.homeworkpages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class MainHomePage {

    @FindBy(xpath = "//*[@class='styles_button__w5lk4 styles_btn__LurTT']")
    private SelenideElement tellAboutProjectButton;

    @FindBy(xpath = "//a[@class='styles_wrapper__dBG_Z' and @href='/testing']")
    private SelenideElement openTestingPageButton;

    @FindBy(xpath = "//*[@class='styles_menu__LbdS4']//*[@href='/vacancies']")
    private SelenideElement openVacanciesPage;

    public TellAboutProjectModel showTLPModel(){
        tellAboutProjectButton
                .shouldBe(visible)
                .shouldHave(text("Обсудить проект"))
                .click();

        return page(TellAboutProjectModel.class);
    }

    public TestingPage checkOpenTestingPage(){
        openTestingPageButton
                .click();

        return page(TestingPage.class);
    }

    public VacanciesPage checkOpenPageWithVacancies(){
        openVacanciesPage
                .shouldBe(visible)
                .click();

        return page(VacanciesPage.class);
    }
}
