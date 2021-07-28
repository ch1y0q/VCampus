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
    public String cardNumber;
    public String dealTime;
    public BigDecimal dealAmount;
    public String dealType;

    public DealHistory(){}

    public DealHistory(String _cardNumber,BigDecimal _dealAmount,String _dealType)
    {

        cardNumber=_cardNumber;
        dealAmount=_dealAmount;
        dealType=_dealType;
    }

    //public Boolean insertDealHistory(Map map){return true;}

}
