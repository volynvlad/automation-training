package com.zestcarrental.model;

import com.zestcarrental.util.TitleType;

import java.util.Objects;

public class User {

    private String username;
    private String password;
    private TitleType titleType;
    private String firstName;
    private String lastName;
    private int age;
    private String mobileNumber;
    private String email;
    private String country;
    private String city;
    private int postCode;
    private String cardNumber;
    private String nameOnCard;
    private int securityCode;

    public User(String username, String password, TitleType titleType, String firstName, String lastName, int age, String mobileNumber, String email, String country, String city, int postCode, String cardNumber, String nameOnCard, int securityCode) {
        this.username = username;
        this.password = password;
        this.titleType = titleType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.country = country;
        this.city = city;
        this.postCode = postCode;
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.securityCode = securityCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TitleType getTitleType() {
        return titleType;
    }

    public void setTitleType(TitleType titleType) {
        this.titleType = titleType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                postCode == user.postCode &&
                securityCode == user.securityCode &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                titleType == user.titleType &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(mobileNumber, user.mobileNumber) &&
                Objects.equals(email, user.email) &&
                Objects.equals(country, user.country) &&
                Objects.equals(city, user.city) &&
                Objects.equals(cardNumber, user.cardNumber) &&
                Objects.equals(nameOnCard, user.nameOnCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, titleType, firstName, lastName, age, mobileNumber, email, country, city, postCode, cardNumber, nameOnCard, securityCode);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", titleType=" + titleType +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", postCode=" + postCode +
                ", cardNumber='" + cardNumber + '\'' +
                ", nameOnCard='" + nameOnCard + '\'' +
                ", securityCode=" + securityCode +
                '}';
    }


}
