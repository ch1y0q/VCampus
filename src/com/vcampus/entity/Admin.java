package com.vcampus.entity;

import java.math.BigDecimal;

import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * @author Huang Qiyue
 * @date 2021-07-12
 */
public class Admin {

    /* required */
    private String name;
    public String password;
    private String cardNumber;
    private BigDecimal balance;

    /* optional */
    private String email;
    private String phoneNumber;
    private String gender;

    /* constructor */
    public Admin(String _name, String _password, String _cardNumber, BigDecimal _balance) {
        name = _name;
        password = _password;
        cardNumber = _cardNumber;
        balance = _balance;
    }
    public Admin(){}
    public Admin(String _cardNumber,String _password)
    {
        name="";
        cardNumber=_cardNumber;
        password=_password;
        balance = new BigDecimal(0);
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
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
