package com.vcampus.entity;

/**
 * @author Huang Qiyue
 * @date 2021-07-12
 */
public class Admin {

    /* required */
    private String name;
    private String password;
    private String cardNumber;
    private float balance;

    /* optional */
    private String email;
    private String phoneNumber;
    private String gender;

    /* constructor */
    public Admin(String _name, String _password, String _cardNumber, float _balance) {
        name = _name;
        password = _password;
        cardNumber = _cardNumber;
        balance = _balance;
    }

    /* util */


    /* getters and setters */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = password;
    }

    public String setCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public float setBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String setPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
