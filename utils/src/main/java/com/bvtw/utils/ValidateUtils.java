package com.bvtw.utils;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class ValidateUtils {
    public static final String NUMBER_REGEX = "\\d+";

    public boolean isNumberValid(String number) {
        return Pattern.compile(NUMBER_REGEX).matcher(number).matches();
    }

    public boolean isLongParsable(String number) {
        try {
            Long.parseLong(number);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }
}
