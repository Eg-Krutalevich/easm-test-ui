package ru.easm.ui.pages;

import io.qameta.allure.Step;
import ru.easm.ui.action.ActionPage;

import static ru.easm.ui.constants.elements.locators.AlertCodeLocators.EXIT_BUTTON;

public class AlertCodePage implements ActionPage {

    @Step("Нажать на крестик")
    public AlertCodePage clickExitButton() {
        System.out.println("Нажать на крестик");
        click(EXIT_BUTTON);
        return this;
    }
}
