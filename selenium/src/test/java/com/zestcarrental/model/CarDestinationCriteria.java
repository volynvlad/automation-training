package com.zestcarrental.model;

import java.util.Objects;

public class CarDestinationCriteria {

    private String locationPickUp;
    private String datePickUp;
    private String locationReturn;
    private String dateReturn;

    private int numberOfDrivers;

    public CarDestinationCriteria(String locationPickUp, String datePickUp, String locationReturn, String dateReturn, int numberOfDrivers) {
        this.locationPickUp = locationPickUp;
        this.datePickUp = datePickUp;
        this.locationReturn = locationReturn;
        this.dateReturn = dateReturn;
        this.numberOfDrivers = numberOfDrivers;
    }

    public String getLocationPickUp() {
        return locationPickUp;
    }

    public void setLocationPickUp(String locationPickUp) {
        this.locationPickUp = locationPickUp;
    }

    public String getDatePickUp() {
        return datePickUp;
    }

    public void setDatePickUp(String datePickUp) {
        this.datePickUp = datePickUp;
    }

    public String getLocationReturn() {
        return locationReturn;
    }

    public void setLocationReturn(String locationReturn) {
        this.locationReturn = locationReturn;
    }

    public String getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(String dateReturn) {
        this.dateReturn = dateReturn;
    }

    public int getNumberOfDrivers() {
        return numberOfDrivers;
    }

    public void setNumberOfDrivers(int numberOfDrivers) {
        this.numberOfDrivers = numberOfDrivers;
    }

    @Override
    public String toString() {
        return "CarDestinationCriteria{" +
                "locationPickUp='" + locationPickUp + '\'' +
                ", datePickUp='" + datePickUp + '\'' +
                ", locationReturn='" + locationReturn + '\'' +
                ", dateReturn='" + dateReturn + '\'' +
                ", numberOfDrivers=" + numberOfDrivers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDestinationCriteria that = (CarDestinationCriteria) o;
        return numberOfDrivers == that.numberOfDrivers &&
                Objects.equals(locationPickUp, that.locationPickUp) &&
                Objects.equals(datePickUp, that.datePickUp) &&
                Objects.equals(locationReturn, that.locationReturn) &&
                Objects.equals(dateReturn, that.dateReturn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationPickUp, datePickUp, locationReturn, dateReturn, numberOfDrivers);
    }
}
