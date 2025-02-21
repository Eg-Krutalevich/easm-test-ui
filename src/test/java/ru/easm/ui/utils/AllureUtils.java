package ru.easm.ui.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;

public class AllureUtils {

    public static void addAttachments(
            final byte[] actual,
            final byte[] expected,
            final FileExtension attachmentExtension
    ) {
        final AllureLifecycle lifecycle = Allure.getLifecycle();
        lifecycle.addAttachment(
                "Актуально",
                attachmentExtension.getMimeType(),
                attachmentExtension.getFormat(),
                actual
        );
        lifecycle.addAttachment(
                "Ожидаемо",
                attachmentExtension.getMimeType(),
                attachmentExtension.getFormat(),
                expected
        );
        lifecycle.stopStep();
    }
}