package com.vcampus.dao;

import com.vcampus.entity.Admin;

/**
 * @author Franklin Yang
 * @date 2021/7/14
 */
public interface IAdminMapper {
    public Boolean verifyManager(Admin admin);

    public Admin getAdminDetailByCardNumber(String cardNumber);
}
