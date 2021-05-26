package com.DataScienceUATest.validation;

import java.util.Date;

public interface Validation {

    boolean isDateOutOfRange(Date date);

    boolean isNegativeNumber(int id);
}
