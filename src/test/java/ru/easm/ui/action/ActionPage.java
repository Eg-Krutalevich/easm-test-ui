package ru.easm.ui.action;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.easm.ui.context.IHighLight;
import ru.easm.ui.managers.CustomLogger;

import java.time.Duration;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;

/**
 * Класс, содержащий действия на страницы с элементами
 */
public interface ActionPage extends IHighLight {

    @Step("Нажимаем на элемент {0}")
    default void click(SelenideElement element) {
        CustomLogger.debugFormat("Нажимаем на элемент %s", element);
        highlightElement(element, true)
                .click();
    }

    default void getAttributeByCss(SelenideElement element, String attribute) {
        CustomLogger.debugFormat("Получаем аттрибут [%s] элемента  [%s]", attribute, element);
        highlightElement(element, false).shouldHave(cssClass(attribute));
    }

    @Step("Нажимаем на элемент {0}")
    default void click(SelenideElement element, int seconds) {
        CustomLogger.debugFormat("Нажимаем на элемент %s", element);
        highlightElement(element, true)
                .shouldBe(visible, Duration.ofSeconds(seconds)).click();
    }

    @Step("Устанавливаем значение {1} для элемента {0}")
    default void setValue(SelenideElement element, String text) {
        CustomLogger.debugFormat("В поле %s вводим значение %s", element, text);
        highlightElement(element, true)
                .setValue(text);
    }

    @Step("Вводим значения значение {1} для элемента {0}")
    default void sendKeys(SelenideElement element, String text) {
        CustomLogger.debugFormat("В поле %s вводим значение %s", element, text);
        highlightElement(element, true)
                .sendKeys(text);
    }

    @Step("Получаем текст из элемента {0}")
    default String getText(SelenideElement element) {
        CustomLogger.debugFormat("Получеем текст из элемента %s", element);
        return highlightElement(element, true)
                .getText();
    }

    default String getTextWithoutAllure(SelenideElement element) {
        CustomLogger.debugFormat("Получеем текст из элемента %s", element);
        return highlightElement(element, false)
                .getText();
    }

    @Step("Ожидаем появление элемента {0}")
    default SelenideElement waitElement(SelenideElement element) {
        CustomLogger.debugFormat("Ожидаем элемент %s", element);
        return highlightElement(element, false)
                .shouldBe(visible, Duration.ofSeconds(10));
    }
}