package ru.easm.ui.pages.base;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static ru.easm.ui.constants.BaseUri.BASE_URI;

public class BasePage {

    @Step("Открыть главную страницу")
    public void openMainPage() {
        System.out.println("Открыть главную страницу");
        open(BASE_URI);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
}