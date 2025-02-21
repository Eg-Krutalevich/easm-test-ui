package ru.easm.ui.tests.register;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import org.testng.annotations.Test;
import ru.easm.ui.tests.BaseTest;

import static ru.easm.ui.constants.changeless.TestSuiteTags.POSITIVE;

@Epic("EASM тестовое задание (UI)")
@Feature("Функциональность регистрации")
@Story("Регистрация пользователя")
@Tags({@Tag(POSITIVE)})
public class RegisterTest extends BaseTest {

    @Test(description = "Проверка отображения сообщений в окне ввода кода из смс")
    public void verifyTextCodeAlertTest() {
        precondition();
        registerFormPage.inputFinalUser()
                .inputEmail()
                .inputPhone()
                .inputPassword()
                .inputPasswordValidation()
                .clickCheckboxFirst()
                .clickCheckboxLast()
                .clickGetButton();
        assertAlertCode();
        alertCodePage.clickExitButton();
    }
}