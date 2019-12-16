package com.zestcarrental.service;

import com.zestcarrental.model.CarDestinationCriteria;

public class CarDestinationCriteriaCreator {

    public static final String TESTDATA_LOCATION_PICKUP = "testdata.criteria.location_pickup";
    public static final String TESTDATA_DAY_PICKUP = "testdata.criteria.day_pickup";
    public static final String TESTDATA_MONTH_PICKUP = "testdata.criteria.month_pickup";
    public static final String TESTDATA_YEAR_PICKUP = "testdata.criteria.year_pickup";
    public static final String TESTDATA_HOUR_PICKUP = "testdata.criteria.hour_pickup";
    public static final String TESTDATA_MINUTE_PICKUP = "testdata.criteria.minute_pickup";
    public static final String TESTDATA_LOCATION_RETURN = "testdata.criteria.location_return";
    public static final String TESTDATA_DAY_RETURN = "testdata.criteria.day_return";
    public static final String TESTDATA_MONTH_RETURN = "testdata.criteria.month_return";
    public static final String TESTDATA_YEAR_RETURN = "testdata.criteria.year_return";
    public static final String TESTDATA_HOUR_RETURN = "testdata.criteria.hour_return";
    public static final String TESTDATA_MINUTE_RETURN = "testdata.criteria.minute_return";
    public static final String TESTDATA_NUMBER_OF_DRIVERS = "testdata.criteria.drivers_number";

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static CarDestinationCriteria withCredentialsFromProperty() {
        return new CarDestinationCriteria(
                TestDataReader.getTestData(TESTDATA_LOCATION_PICKUP),
                TestDataReader.getTestData(TESTDATA_DAY_PICKUP),
                TestDataReader.getTestData(TESTDATA_MONTH_PICKUP),
                TestDataReader.getTestData(TESTDATA_YEAR_PICKUP),
                TestDataReader.getTestData(TESTDATA_HOUR_PICKUP),
                TestDataReader.getTestData(TESTDATA_MINUTE_PICKUP),
                TestDataReader.getTestData(TESTDATA_LOCATION_RETURN),
                TestDataReader.getTestData(TESTDATA_DAY_RETURN),
                TestDataReader.getTestData(TESTDATA_MONTH_RETURN),
                TestDataReader.getTestData(TESTDATA_YEAR_RETURN),
                TestDataReader.getTestData(TESTDATA_HOUR_RETURN),
                TestDataReader.getTestData(TESTDATA_MINUTE_RETURN),
                TestDataReader.getTestData(TESTDATA_NUMBER_OF_DRIVERS)
        );
    }

    public static CarDestinationCriteria withEmptyFields() {
        return new CarDestinationCriteria(
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
                ""
                );
    }
}
