package com.zestcarrental.service;

import com.zestcarrental.model.CarDestinationCriteria;
import com.zestcarrental.model.User;
import com.zestcarrental.util.TitleType;

public class CarDestinationCriteriaCreator {
    public static final String TESTDATA_LOCATION_PICKUP = "Budapest";
    public static final String TESTDATA_DAY_PICKUP = "17";
    public static final String TESTDATA_MONTH_PICKUP = "2";
    public static final String TESTDATA_YEAR_PICKUP = "2020";
    public static final String TESTDATA_HOUR_PICKUP = "00";
    public static final String TESTDATA_MINUTE_PICKUP = "15";
    public static final String TESTDATA_LOCATION_RETURN = "Budapest";
    public static final String TESTDATA_DAY_RETURN = "24";
    public static final String TESTDATA_MONTH_RETURN = "2";
    public static final String TESTDATA_YEAR_RETURN = "2020";
    public static final String TESTDATA_HOUR_RETURN = "00";
    public static final String TESTDATA_MINUTE_RETURN = "15";
    public static final String TESTDATA_NUMBER_OF_DRIVERS = "1";

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static CarDestinationCriteria withCredentialsFromProperty(){
        return new CarDestinationCriteria(
                TESTDATA_LOCATION_PICKUP,
                TESTDATA_DAY_PICKUP,
                TESTDATA_MONTH_PICKUP,
                TESTDATA_YEAR_PICKUP,
                TESTDATA_HOUR_PICKUP,
                TESTDATA_MINUTE_PICKUP,
                TESTDATA_LOCATION_RETURN,
                TESTDATA_DAY_RETURN,
                TESTDATA_MONTH_RETURN,
                TESTDATA_YEAR_RETURN,
                TESTDATA_HOUR_RETURN,
                TESTDATA_MINUTE_RETURN,
                Integer.getInteger(TESTDATA_NUMBER_OF_DRIVERS)
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
                0
                );
    }
}
