package ru.easm.ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import org.testng.annotations.AfterClass;
import ru.easm.ui.action.ActionPage;
import ru.easm.ui.constants.BaseUri;
import ru.easm.ui.pages.AlertCodePage;
import ru.easm.ui.pages.RegisterFormPage;
import ru.easm.ui.pages.base.BasePage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase implements ActionPage {

    static {
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

    @AfterClass
    public void close() {
        closeWebDriver();
    }
}