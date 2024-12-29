package org.lection_6.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class ContactsPage {

    @Step("Сверяем верная ли страница открыта")
    public ContactsPage contactsPageIsOpen(){
        webdriver().shouldHave(url("https://www.simbirsoft.com/contacts/"));

        return this;
    }
}
