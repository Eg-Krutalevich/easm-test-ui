package ru.easm.ui.constants.elements.locators;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class RegisterFormLocators {

    public static final String TEXT_LOCATOR_PATTERN = "//*[contains(text(), '%s')]";
    public static final SelenideElement USER_NAME_INPUT = $x("//div[@class=\"bankSignUp\"]//input[@name=\"login\"]");
    public static final SelenideElement EMAIL_INPUT = $x("//div[@class=\"bankSignUp\"]//input[@name=\"email\"]");
    public static final SelenideElement PHONE_INPUT = $x("//div[@class=\"bankSignUp\"]//input[@name=\"phone\"]");
    public static final SelenideElement PASSWORD_INPUT = $x("//div[@class=\"bankSignUp\"]//input[@name=\"password\"]");
    public static final SelenideElement PASSWORD_VALIDATION_INPUT = $x("//div[@class=\"bankSignUp\"]//input[@name=\"passwordValidation\"]");
    public static final SelenideElement GET_BUTTON = $x("//div[@class=\"signUpForm__row\"]//button[@type=\"submit\"]");
    public static final ElementsCollection CHECKBOX_ELEMENT = $$x("//label[@class=\"signUpForm__checkoboxItem\"]");
    public static final SelenideElement CODE_CHECK_TEXT = $x(String.format(TEXT_LOCATOR_PATTERN, "Код проверки"));
    public static final SelenideElement INFORMATION_TEXT = $x(String.format(TEXT_LOCATOR_PATTERN, "На номер, к которому привязан аккаунт, поступит звонок или сообщение. Введите последние четыре цифры телефонного номера или код из смс."));
    public static final SelenideElement VALID_PASSWORD_TEXT = $x(String.format(TEXT_LOCATOR_PATTERN, "Ваши пароли не совпадают"));
    public static final SelenideElement INVALID_PASSWORD_TEXT = $x(String.format(TEXT_LOCATOR_PATTERN, "Пароль должен быть не менее 8 символов"));
    public static final SelenideElement PHONE_TEXT = $x(String.format(TEXT_LOCATOR_PATTERN, "Сотовый номер должен содержать только цифры и начинаться с 7 или 8"));
}