package ru.easm.ui.tests.register;

import io.qameta.allure.Step;
import ru.easm.ui.tests.TestBase;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static ru.easm.ui.asserts.AssertsClass.assertEquals;
import static ru.easm.ui.constants.elements.locators.RegisterFormLocators.*;

public class RegisterTestBase extends TestBase {

    @Step("Проверяем наличие текста 'Код проверки' и текста о поступлении кода на номер телефона")
    protected void assertAlertCode() {
        assertSoftly(softAssertions -> {
            assertEquals(getTextWithoutAllure(CODE_CHECK_TEXT), "Код проверки",
                    "Проверяем наличие текста 'Код проверки'");
            assertEquals(getTextWithoutAllure(INFORMATION_TEXT), "На номер," +
                            " к которому привязан аккаунт, поступит звонок или сообщение. " +
                            "Введите последние четыре цифры телефонного номера или код из смс.",
                    "Проверяем наличие текста о поступлении кода на номер телефона");
        });
    }

    @Step("Проверяем наличие текста 'Ваши пароли не совпадают'")
    protected void assertMismatchPassword() {
        assertSoftly(softAssertions -> {
            assertEquals(getTextWithoutAllure(VALID_PASSWORD_TEXT), "Ваши пароли не совпадают",
                    "Проверяем наличие текста 'Ваши пароли не совпадают'");
        });
    }

    @Step("Проверяем наличие текста 'Пароль должен быть не менее 8 символов'")
    protected void assertInvalidLengthPassword() {
        assertSoftly(softAssertions -> {
            assertEquals(getTextWithoutAllure(INVALID_PASSWORD_TEXT), "Пароль должен быть не менее 8 символов",
                    "Проверяем наличие текста 'Пароль должен быть не менее 8 символов'");
        });
    }

    @Step("Проверяем наличие текста 'Сотовый номер должен содержать только цифры и начинаться с 7 или 8'")
    protected void assertInvalidPhone() {
        assertSoftly(softAssertions -> {
            assertEquals(getTextWithoutAllure(PHONE_TEXT), "Сотовый номер должен содержать " +
                            "только цифры и начинаться с 7 или 8",
                    "Проверяем наличие текста 'Сотовый номер должен содержать " +
                            "только цифры и начинаться с 7 или 8'");
        });
    }
}