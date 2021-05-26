package com.DataScienceUATest;

import com.DataScienceUATest.validation.Validation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@ContextConfiguration(classes = Main.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ValidationTest {

    @Autowired
    private Validation validation;

    @Test
    public void isDateOutOfRangeTrue() throws ParseException {
        Date date  = new SimpleDateFormat("dd/MM/yyyy").parse("07/10/1800");

        assertTrue(validation.isDateOutOfRange(date));
    }

    @Test
    public void isDateOutOfRangeFalse() throws ParseException {
        Date date  = new SimpleDateFormat("dd/MM/yyyy").parse("07/10/2000");

        assertFalse(validation.isDateOutOfRange(date));
    }

    @Test
    public void isNegativeNumberTrue() {
        assertTrue(validation.isNegativeNumber(-1));
    }

    @Test
    public void isNegativeNumberFalse() {
        assertFalse(validation.isNegativeNumber(1));
    }
}

