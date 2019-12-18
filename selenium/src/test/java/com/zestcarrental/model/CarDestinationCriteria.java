package com.zestcarrental.model;

import java.util.Objects;

public class CarDestinationCriteria {

    private String locationPickup;

    private String dayPickup;

    private String monthPickup;

    private String yearPickup;

    private String hourPickup;

    private String minutePickup;

    private String locationReturn;

    private String dayReturn;

    private String monthReturn;

    private String yearReturn;

    private String hourReturn;

    private String minuteReturn;

    private String numberOfDrivers;

    public String getLocationPickup() {
        return locationPickup;
    }

    public void setLocationPickup(String locationPickup) {
        this.locationPickup = locationPickup;
    }

    public String getDayPickup() {
        return dayPickup;
    }

    public void setDayPickup(String dayPickup) {
        this.dayPickup = dayPickup;
    }

    public String getMonthPickup() {
        return monthPickup;
    }

    public void setMonthPickup(String monthPickup) {
        this.monthPickup = monthPickup;
    }

    public String getYearPickup() {
        return yearPickup;
    }

    public void setYearPickup(String yearPickup) {
        this.yearPickup = yearPickup;
    }

    public String getHourPickup() {
        return hourPickup;
    }

    public void setHourPickup(String hourPickup) {
        this.hourPickup = hourPickup;
    }

    public String getMinutePickup() {
        return minutePickup;
    }

    public void setMinutePickup(String minutePickup) {
        this.minutePickup = minutePickup;
    }

    public String getLocationReturn() {
        return locationReturn;
    }

    public void setLocationReturn(String locationReturn) {
        this.locationReturn = locationReturn;
    }

    public String getDayReturn() {
        return dayReturn;
    }

    public void setDayReturn(String dayReturn) {
        this.dayReturn = dayReturn;
    }

    public String getMonthReturn() {
        return monthReturn;
    }

    public void setMonthReturn(String monthReturn) {
        this.monthReturn = monthReturn;
    }

    public String getYearReturn() {
        return yearReturn;
    }

    public void setYearReturn(String yearReturn) {
        this.yearReturn = yearReturn;
    }

    public String getHourReturn() {
        return hourReturn;
    }

    public void setHourReturn(String hourReturn) {
        this.hourReturn = hourReturn;
    }

    public String getMinuteReturn() {
        return minuteReturn;
    }

    public void setMinuteReturn(String minuteReturn) {
        this.minuteReturn = minuteReturn;
    }

    public String getNumberOfDrivers() {
        return numberOfDrivers;
    }

    public void setNumberOfDrivers(String numberOfDrivers) {
        this.numberOfDrivers = numberOfDrivers;
    }

    public CarDestinationCriteria(String locationPickup, String dayPickup, String monthPickup, String yearPickup, String hourPickup, String minutePickup, String locationReturn, String dayReturn, String monthReturn, String yearReturn, String hourReturn, String minuteReturn, String numberOfDrivers) {
        this.locationPickup = locationPickup;
        this.dayPickup = dayPickup;
        this.monthPickup = monthPickup;
        this.yearPickup = yearPickup;
        this.hourPickup = hourPickup;
        this.minutePickup = minutePickup;
        this.locationReturn = locationReturn;
        this.dayReturn = dayReturn;
        this.monthReturn = monthReturn;
        this.yearReturn = yearReturn;
        this.hourReturn = hourReturn;
        this.minuteReturn = minuteReturn;
        this.numberOfDrivers = numberOfDrivers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDestinationCriteria that = (CarDestinationCriteria) o;
        return numberOfDrivers == that.numberOfDrivers &&
                Objects.equals(locationPickup, that.locationPickup) &&
                Objects.equals(dayPickup, that.dayPickup) &&
                Objects.equals(monthPickup, that.monthPickup) &&
                Objects.equals(yearPickup, that.yearPickup) &&
                Objects.equals(hourPickup, that.hourPickup) &&
                Objects.equals(minutePickup, that.minutePickup) &&
                Objects.equals(locationReturn, that.locationReturn) &&
                Objects.equals(dayReturn, that.dayReturn) &&
                Objects.equals(monthReturn, that.monthReturn) &&
                Objects.equals(yearReturn, that.yearReturn) &&
                Objects.equals(hourReturn, that.hourReturn) &&
                Objects.equals(minuteReturn, that.minuteReturn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationPickup, dayPickup, monthPickup, yearPickup, hourPickup, minutePickup, locationReturn, dayReturn, monthReturn, yearReturn, hourReturn, minuteReturn, numberOfDrivers);
    }

    @Override
    public String toString() {
        return "CarDestinationCriteria{" +
                "locationPickup='" + locationPickup + '\'' +
                ", dayPickup='" + dayPickup + '\'' +
                ", monthPickup='" + monthPickup + '\'' +
                ", yearPickup='" + yearPickup + '\'' +
                ", hourPickup='" + hourPickup + '\'' +
                ", minutePickup='" + minutePickup + '\'' +
                ", locationReturn='" + locationReturn + '\'' +
                ", dayReturn='" + dayReturn + '\'' +
                ", monthReturn='" + monthReturn + '\'' +
                ", yearReturn='" + yearReturn + '\'' +
                ", hourReturn='" + hourReturn + '\'' +
                ", minuteReturn='" + minuteReturn + '\'' +
                ", numberOfDrivers=" + numberOfDrivers +
                '}';
    }
}
