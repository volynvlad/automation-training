package com.zestcarrental.service;

import com.zestcarrental.model.User;
import com.zestcarrental.util.TitleType;

public class UserCreator {

    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";
    public static final TitleType TEST_DATA_TYPE = TitleType.Mr;
    public static final String TESTDATA_FIRSTNAME = "John";
    public static final String TESTDATA_LASTNAME = "John";
    public static final int TESTDATA_AGE = 30;
    public static final String TESTDATA_MOBILE_NUMBER = "375292222222";
    public static final String TESTDATA_EMAIL = "hjfbdjhsdf@gmail.com";
    public static final String TESTDATA_COUNTRY= "Hungary";
    public static final String TESTDATA_CITY = "Budapest";
    public static final int TESTDATA_POSTCODE = 222;
    public static final String TESTDATA_CARDNUMBER = "2222222222222222";
    public static final String TESTDATA_CARDNAME = "asdfsdf";
    public static final int TESTDATA_SECURITYCARD = 222;
    public static final String TESTDATA_ADDERSS_LINE_FIRST = "adsfasf";
    public static final String TESTDATA_ADDERSS_LINE_SECOND = "adsfasf";
    public static final String TESTDATA_TELEPHONE_NUMBER = "22222222";
    public static final String TESTDATA_EXPIRE_MONTH_DATE = "2";
    public static final String TESTDATA_EXPIRE_YEAR_DATE = "2020";

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
                TESTDATA_SECURITYCARD,
                TESTDATA_ADDERSS_LINE_FIRST,
                TESTDATA_ADDERSS_LINE_SECOND,
                TESTDATA_TELEPHONE_NUMBER,
                TESTDATA_EXPIRE_MONTH_DATE,
                TESTDATA_EXPIRE_YEAR_DATE
                );
    }

    public static User withEmptyFields() {
        return new User(
                "",
                "",
                TitleType.Mr,
                "",
                "",
                28,
        "",
                "",
                "",
                "",
                222,
                "",
                "",
                1,
                "",
                "",
                "",
                "",
                "");
    }
}
