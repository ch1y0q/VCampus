package com.vcampus.util;

import com.vcampus.entity.UserType;

import java.util.*;

/**
 * 一些通用的工具方法
 *
 * @author Huang Qiyue
 * @date 2021-07-07
 */


public class  CommonUtils {
    /**
     * @param cardNumber 一卡通号，用String表示
     * @return 用户类型
     */
    public static UserType getUserTypeByCardNumber(String cardNumber) {
        String first = cardNumber.substring(0, 1);
        return switch (first) {
            case "0" -> UserType.ADMIN;
            case "1" -> UserType.TEACHER;
            case "2" -> UserType.STUDENT;
            default -> null;
        };
    }

    /**
     * @param code 学院的代码，用String表示
     * @return 学院的全称
     */
    public static String getSchoolByCode(String code) {
        Map<String, String> map = new HashMap<>();
        map.put("01", "建筑学院");
        map.put("02", "机械工程学院");
        map.put("03", "能源与环境学院");
        map.put("04", "信息科学与工程学院");
        map.put("05", "土木工程学院");
        map.put("06", "电子科学与工程学院");
        map.put("07", "数学学院");
        map.put("08", "自动化学院");
        map.put("09", "计算机科学与工程学院");
        map.put("10", "物理学院");
        map.put("11", "生物科学与医学工程学院");
        map.put("12", "材料科学与工程学院");
        map.put("13", "人文学院");
        map.put("14", "经济管理学院");
        map.put("15", "马克思主义学院");
        map.put("16", "电气工程学院");
        map.put("17", "外国语学院");
        map.put("19", "化学化工学院");
        map.put("21", "交通学院");
        map.put("22", "仪器科学与工程学院");
        map.put("24", "艺术学院");
        map.put("25", "法学院");
        map.put("41", "医学院1");
        map.put("42", "公共卫生学院");
        map.put("43", "医学院2");
        map.put("57", "网络空间安全学院");
        map.put("58", "人工智能学院");
        map.put("61", "吴健雄学院");
        map.put("71", "软件学院");
        return map.getOrDefault(code, "");
    }
}
