package ru.easm.ui.constants.elements;

import static ru.easm.ui.constants.FakerObject.faker;

public class InputElements {

    public static final String VALID_PASSWORD = faker.internet().password(
            8, 30, true, true);
    public static final String INVALID_PASSWORD = faker.internet().password(6, 7);
    public static final String USER_NAME = "Liza";
    public static final String PHONE = "79091086630";

}