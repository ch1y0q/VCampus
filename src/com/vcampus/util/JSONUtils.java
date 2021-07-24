package com.vcampus.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * JSON工具
 *
 * @author Franklin Yang
 * @date 2021/7/12
 */
public class JSONUtils {

    protected final static List<Class> BASIC_CLASSES = new ArrayList<>(
            Arrays.asList(String.class, int.class, Integer.class, boolean.class, Boolean.class, double.class, Double.class,
                    float.class, Float.class, long.class, Long.class, java.math.BigDecimal.class));

    public final static boolean isBasicClass(Class<?> clazz) {
            return JSONUtils.BASIC_CLASSES.contains(clazz);
        }

}
