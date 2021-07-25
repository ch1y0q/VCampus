package com.vcampus.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 交易记录类
 *
 * @author Y
 * @date 2021-07-25
 */

public class DealHistory {
    private String cardNumber;
    private String dealTime;
    private BigDecimal dealAmount;
    private String dealType;

    public DealHistory(){}

    public DealHistory(String _cardNumber,BigDecimal _dealAmount,String _dealType)
    {

        cardNumber=_cardNumber;
        dealAmount=_dealAmount;
        dealType=_dealType;
        System.out.println(cardNumber);
        System.out.println(dealTime);
        System.out.println(dealAmount);
        System.out.println(dealType);
    }

    public Boolean insertDealHistory(Map map){return true;}

}
