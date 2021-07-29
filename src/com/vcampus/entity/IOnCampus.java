package com.vcampus.entity;

/**
 * 含有姓名、卡号、学院的接口。
 *
 * @author Huang Qiyue
 * @date 2021-07-29
 */
public interface IOnCampus {
    String getName();
    String getCardNumber();
    String getSchool();

    void setName(String name);
    void setCardNumber(String cardNumber);
    void setSchool(String school);
}
