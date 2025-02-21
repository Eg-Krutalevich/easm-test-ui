package ru.easm.ui.attachmentUtils;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import ru.easm.ui.managers.CustomLogger;

/**
 * Класс, с методами для вложения в отчёт allure
 */
public class AttachmentUtils {

    @Attachment(value = "PageScreenshot", type = "image/png")
    public static byte[] attachScreenshot() {
        try {
            return Selenide.screenshot(OutputType.BYTES);
        } catch (Exception exception) {
            CustomLogger.debug("Получение screenshot страницы");
        }
        return new byte[0];
    }

    @Attachment(value = "PdfScreenshot", type = "image/png")
    public static byte[] attachScreenshotPDF(byte[] bytes) {
        return bytes;
    }


    @Attachment(value = "PageSource", type = "text/xml")
    public static byte[] attachPageSource() {
        try {
            return getWebDriver().getPageSource().getBytes();
        } catch (Exception exception) {
            CustomLogger.debug("Получение html страницы");
        }
        return new byte[0];
    }
}