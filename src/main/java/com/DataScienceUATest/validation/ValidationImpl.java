package com.DataScienceUATest.validation;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.YEAR;

@Component
public class ValidationImpl implements Validation {

    @Override
    public boolean isDateOutOfRange(Date date) {
        int years = getDiffYears(date);
        return years > 150;
    }

    @Override
    public boolean isNegativeNumber(int id) {
        return id < 0;
    }

    private int getDiffYears(Date date) {
        Calendar now = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(date);

        return now.get(YEAR) - birthDate.get(YEAR);
    }

}
