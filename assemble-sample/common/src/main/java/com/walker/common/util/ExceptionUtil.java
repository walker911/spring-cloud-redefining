package com.walker.common.util;

import org.springframework.util.StringUtils;

/**
 * @author walker
 * @date 2019/1/2
 */
public class ExceptionUtil {

    public static String errorToCodeEn(Enum<?> error) {
        String errorName = error.name().toLowerCase();
        String[] strings = errorName.split("_");
        StringBuffer buffer = new StringBuffer();
        for (String str : strings) {
            buffer.append(StringUtils.capitalize(str));
        }
        return buffer.toString();
    }
}
