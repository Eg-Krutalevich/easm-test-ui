package ru.easm.ui.tests.register;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import org.testng.annotations.Test;
import ru.easm.ui.tests.BaseTest;

import static ru.easm.ui.constants.changeless.TestSuiteTags.NEGATIVE;

@Epic("EASM тестовое задание (UI)")
@Feature("Функциональность регистрации")
@Story("Регистрация пользователя")
@Tags({@Tag(NEGATIVE)})
public class RegisterNegativeTest extends BaseTest {

    @Test(description = "Проверка отображеня сообщения о неверном ввод пароля подтверждения")
    public void verifyMismatchPasswordTest() {
        precondition();
        registerFormPage.inputFinalUser()
                .inputEmail()
                .inputPhone()
                .inputPassword()
                .inputPasswordInvalidValidation()
                .clickCheckboxFirst()
                .clickCheckboxLast()
                .clickGetButton();
        assertMismatchPassword();
    }

    @Test(description = "Проверка отображеня сообщения о вводе номера телефона," +
            "который не начинается на 7 или 8")
    public void verifyInvalidPhoneTest() {
        precondition();
        registerFormPage.inputFinalUser()
                .inputEmail()
                .inputInvalidPhone()
                .inputPassword()
                .inputPasswordValidation()
                .clickCheckboxFirst()
                .clickCheckboxLast()
                .clickGetButton();
        assertInvalidPhone();
    }

    @Test(description = "Проверка отображеня сообщения о неверной длине пароля")
    public void verifyInvalidPasswordLengthTest() {
        precondition();
        registerFormPage.inputFinalUser()
                .inputEmail()
                .inputPhone()
                .inputIncorrectLengthPassword()
                .inputIncorrectLengthPasswordValidation()
                .clickCheckboxFirst()
                .clickCheckboxLast()
                .clickGetButton();
        assertInvalidLengthPassword();
    }
}