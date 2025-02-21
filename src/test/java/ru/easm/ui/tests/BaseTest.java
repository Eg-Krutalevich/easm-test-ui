package ru.easm.ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import io.qameta.allure.Step;
import org.testng.annotations.AfterClass;
import ru.easm.ui.action.ActionPage;
import ru.easm.ui.constants.BaseUri;
import ru.easm.ui.pages.AlertCodePage;
import ru.easm.ui.pages.RegisterFormPage;
import ru.easm.ui.pages.base.BasePage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static ru.easm.ui.asserts.AssertsClass.assertEquals;
import static ru.easm.ui.constants.elements.locators.RegisterFormLocators.*;

public class BaseTest implements ActionPage {

    static  {
        Configuration.baseUrl = BaseUri.BASE_URI;
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        Configuration.fileDownload = FileDownloadMode.FOLDER;
    }

    protected BasePage basePage = new BasePage();
    protected RegisterFormPage registerFormPage = new RegisterFormPage();
    protected AlertCodePage alertCodePage = new AlertCodePage();

    public void precondition() {
        basePage.openMainPage();
    }

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

    @AfterClass
    public void close() {
        closeWebDriver();
    }
}