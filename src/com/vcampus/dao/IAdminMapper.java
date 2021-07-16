package com.vcampus.dao;

import com.vcampus.entity.Admin;
import com.vcampus.entity.Student;

/**
 * 一系列管理员数据库操作的接口，用于mybatis的映射
 *
 * @author Franklin Yang
 * @date 2021/7/14
 */
public interface IAdminMapper {
    @Deprecated
    /**
     * 仅在密码明文存储可用。
     */
    public Boolean verifyAdmin(Admin admin);

    public Admin getAdminDetailByCardNumber(String cardNumber);

    public String getSaltByCardNumber(String cardNumber);

    public String getNameByCardNumber(String cardNumber);

    public String getPasswordByCardNumber(String cardNumber);
}
