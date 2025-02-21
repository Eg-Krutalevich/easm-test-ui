package ru.easm.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.easm.ui.action.ActionPage;
import ru.easm.ui.utils.RandomUtils;

import static ru.easm.ui.constants.FakerObject.faker;
import static ru.easm.ui.constants.elements.InputElements.*;
import static ru.easm.ui.constants.elements.locators.RegisterFormLocators.*;

public class RegisterFormPage implements ActionPage {

    @Step("Ввести логин (одинаковый для всех тестов)")
    public RegisterFormPage inputFinalUser() {
        System.out.println("Ввести логин (одинаковый для всех тестов)");
        sendKeys(USER_NAME_INPUT, USER_NAME);
        return this;
    }

    @Step("Ввести валидную электронную почту")
    public RegisterFormPage inputEmail() {
        System.out.println("Ввести валидную электронную почту");
        sendKeys(EMAIL_INPUT, faker.internet().emailAddress());
        return this;
    }

    @Step("Ввести валидный номер телефона")
    public RegisterFormPage inputPhone() {
        System.out.println("Ввести валидный номер телефона");
        sendKeys(PHONE_INPUT, PHONE);
        return this;
    }

    @Step("Ввести номера телефона, не начинающийся на 7 или 8")
    public RegisterFormPage inputInvalidPhone() {
        System.out.println("Ввести номера телефона, не начинающийся на 7 или 8");
        sendKeys(PHONE_INPUT, RandomUtils.generateNumeric(11));
        return this;
    }

    @Step("Ввести валидный пароль")
    public RegisterFormPage inputPassword() {
        System.out.println("Ввести валидный пароль");
        sendKeys(PASSWORD_INPUT, VALID_PASSWORD);
        return this;
    }

    @Step("Ввести пароль некорректной длины")
    public RegisterFormPage inputIncorrectLengthPassword() {
        System.out.println("Ввести пароль некорректной длины");
        sendKeys(PASSWORD_INPUT, INVALID_PASSWORD);
        return this;
    }

    @Step("Ввести пароль подтверждения")
    public RegisterFormPage inputPasswordValidation() {
        System.out.println("Ввести пароль подтверждения");
        sendKeys(PASSWORD_VALIDATION_INPUT, VALID_PASSWORD);
        return this;
    }

    @Step("Ввести пароль подтверждения, который не соответствует введенному паролю")
    public RegisterFormPage inputPasswordInvalidValidation() {
        System.out.println("Ввести пароль подтверждения, который не соответствует введенному паролю");
        sendKeys(PASSWORD_VALIDATION_INPUT, VALID_PASSWORD + "?");
        return this;
    }

    @Step("Ввести пароль пароль подтверждения некорректной длины")
    public RegisterFormPage inputIncorrectLengthPasswordValidation() {
        System.out.println("вести пароль пароль подтверждения некорректной длины");
        sendKeys(PASSWORD_VALIDATION_INPUT, INVALID_PASSWORD);
        return this;
    }

    @Step("Нажать на галочку принятия условий обработки данных")
    public RegisterFormPage clickCheckboxFirst() {
        System.out.println("Нажать на галочку принятия условий обработки данных");
        SelenideElement element = CHECKBOX_ELEMENT.first();
        click(element);
        return this;
    }

    @Step("Нажать на галочку принятия согласия получения информации " +
            "о специальных предложениях и услугах")
    public RegisterFormPage clickCheckboxLast() {
        System.out.println("Нажать на галочку принятия согласия получения информации " +
                "о специальных предложениях и услугах");
        SelenideElement element = CHECKBOX_ELEMENT.last();
        click(element);
        return this;
    }

    @Step("Нажать на кнопку 'Получить'")
    public RegisterFormPage clickGetButton() {
        System.out.println("Нажать на кнопку 'Получить'");
        click(GET_BUTTON);
        return this;
    }
}