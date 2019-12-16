package com.zestcarrental.service;

import com.zestcarrental.model.User;
import com.zestcarrental.util.TitleType;

public class UserCreator {

    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";
    public static final TitleType TEST_DATA_TYPE = TitleType.Mr;
    public static final String TESTDATA_FIRSTNAME = "testdata.user.firstname";
    public static final String TESTDATA_LASTNAME = "testdata.user.lastname";
    public static final String TESTDATA_AGE = "testdata.user.age";
    public static final String TESTDATA_MOBILE_NUMBER = "testdata.user.mobilenumber";
    public static final String TESTDATA_EMAIL = "testdata.user.email";
    public static final String TESTDATA_COUNTRY= "testdata.user.country";
    public static final String TESTDATA_CITY = "testdata.user.city";
    public static final String TESTDATA_POSTCODE = "testdata.user.postcode";
    public static final String TESTDATA_CARDNUMBER = "testdata.user.cardnumber";
    public static final String TESTDATA_CARDNAME = "testdata.user.cardname";
    public static final String TESTDATA_SECURITYCARD_NUMBER = "testdata.user.security_card";
    public static final String TESTDATA_ADDERSS_LINE_FIRST = "testdata.user.address_line_first";
    public static final String TESTDATA_ADDERSS_LINE_SECOND = "testdata.user.address_line_second";
    public static final String TESTDATA_TELEPHONE_NUMBER = "testdata.user.telephonenumber";
    public static final String TESTDATA_EXPIRE_MONTH_DATE = "testdata.user.expire_month_date";
    public static final String TESTDATA_EXPIRE_YEAR_DATE = "testdata.user.expire_year_date";

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static User withCredentialsFromProperty(){
        return new User(
                TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD),
                TEST_DATA_TYPE,
                TestDataReader.getTestData(TESTDATA_FIRSTNAME),
                TestDataReader.getTestData(TESTDATA_LASTNAME),
                TestDataReader.getTestData(TESTDATA_AGE),
                TestDataReader.getTestData(TESTDATA_MOBILE_NUMBER),
                TestDataReader.getTestData(TESTDATA_EMAIL),
                TestDataReader.getTestData(TESTDATA_COUNTRY),
                TestDataReader.getTestData(TESTDATA_CITY),
                TestDataReader.getTestData(TESTDATA_POSTCODE),
                TestDataReader.getTestData(TESTDATA_CARDNUMBER),
                TestDataReader.getTestData(TESTDATA_CARDNAME),
                TestDataReader.getTestData(TESTDATA_SECURITYCARD_NUMBER),
                TestDataReader.getTestData(TESTDATA_ADDERSS_LINE_FIRST),
                TestDataReader.getTestData(TESTDATA_ADDERSS_LINE_SECOND),
                TestDataReader.getTestData(TESTDATA_TELEPHONE_NUMBER),
                TestDataReader.getTestData(TESTDATA_EXPIRE_MONTH_DATE),
                TestDataReader.getTestData(TESTDATA_EXPIRE_YEAR_DATE)
                );
    }

    public static User withEmptyFields() {
        return new User(
                "",
                "",
                TitleType.Mr,
                "",
                "",
                "",
        "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "");
    }
}
