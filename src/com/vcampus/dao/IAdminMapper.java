package com.vcampus.dao;

import com.vcampus.entity.Admin;

/**
 * 一系列管理员数据库操作的接口，用于mybatis的映射
 *
 * @author Franklin Yang
 * @date 2021/7/14
 */
public interface IAdminMapper {
    public Boolean verifyAdmin(Admin admin);

    public Admin getAdminDetailByCardNumber(String cardNumber);
}
