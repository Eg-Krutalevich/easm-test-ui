package ru.easm.ui.context;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.function.Supplier;

import org.openqa.selenium.WebElement;
import ru.easm.ui.attachmentUtils.AttachmentUtils;
import ru.easm.ui.managers.CustomLogger;

public interface IHighLight {

    default SelenideElement highlightElement(WebElement webElement, boolean javaScript) {
        Supplier<WebElement> supplier = () -> webElement;
        if (javaScript) {
            CustomLogger.debugFormat("Ищем элемент '%s' на странице и выделяем его",
                    supplier.get());
            Selenide.executeJavaScript(
                    "arguments[0].style.border='2px solid red'",
                    $(supplier.get()).scrollIntoView(
                            "{block: \"center\", inline: \"center\", behavior: \"smooth\"}")
            );
            AttachmentUtils.attachScreenshot();
            AttachmentUtils.attachPageSource();
            if (supplier.get().isDisplayed() && supplier.get().isEnabled()) {
                Selenide.executeJavaScript("arguments[0].style.border='0px'", supplier.get());
            }
        }
        return Selenide.element(supplier.get());
    }
}