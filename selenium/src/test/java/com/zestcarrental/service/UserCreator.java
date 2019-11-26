package com.zestcarrental.service;

import com.zestcarrental.model.User;
import com.zestcarrental.util.TitleType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserCreator {

    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";
    public static final TitleType TEST_DATA_TYPE = TitleType.Mr;
    public static final String TESTDATA_FIRSTNAME = "name";
    public static final String TESTDATA_LASTNAME = "last";
    public static final int TESTDATA_AGE = 30;
    public static final String TESTDATA_MOBILE_NUMBER = "111211";
    public static final String TESTDATA_EMAIL = "asdfasdf@gmail.com";
    public static final String TESTDATA_COUNTRY= "German";
    public static final String TESTDATA_CITY = "Berlin";
    public static final int TESTDATA_POSTCODE = 220000;
    public static final String TESTDATA_CARDNUMBER = "2222222222222222";
    public static final String TESTDATA_STRING_DATE = "27/12/2019 17:00:00";
    public static final int TESTDATA_NUMBER_CARD = 220000;
    public static final String TESTDATA_CARDNAME = "2222222222222222";
    public static final int TESTDATA_SECURITYCARD = 222;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD),
                TEST_DATA_TYPE,
                TestDataReader.getTestData(TESTDATA_FIRSTNAME),
                TestDataReader.getTestData(TESTDATA_LASTNAME),
                TESTDATA_AGE,
                TestDataReader.getTestData(TESTDATA_MOBILE_NUMBER),
                TestDataReader.getTestData(TESTDATA_EMAIL),
                TestDataReader.getTestData(TESTDATA_COUNTRY),
                TestDataReader.getTestData(TESTDATA_CITY),
                TESTDATA_POSTCODE,
                TestDataReader.getTestData(TESTDATA_CARDNUMBER),
                TestDataReader.getTestData(TESTDATA_CARDNAME),
                TESTDATA_SECURITYCARD);
    }

    public static User withEmptyUsername(){
        return new User("", TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static User withEmptyPassword(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME), "");
    }
}
