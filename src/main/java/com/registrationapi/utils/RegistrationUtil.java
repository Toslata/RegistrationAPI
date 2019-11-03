package com.registrationapi.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationUtil
{
    private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

    public static String generateRefCode(String phoneNumber)
    {
        return format.format(new Date()) + phoneNumber.substring(phoneNumber.length()-4);
    }

}
