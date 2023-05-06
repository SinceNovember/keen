package com.simple.keen.common.utils;

import cn.hutool.core.date.LocalDateTimeUtil;
import java.time.LocalDateTime;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/4/23
 */
public class LocalDateTimeUtils extends LocalDateTimeUtil {

    /**
     * 格式简单时间 今天的为 (HH:mm) 其他天为 (MM-dd)
     *
     * @param localDateTime 当地日期时间
     * @return 简化后的时间
     */
    public static String formatSimpleTime(LocalDateTime localDateTime) {
        if (isSameDay(localDateTime, LocalDateTime.now())) {
            return format(localDateTime, "HH:mm");
        }
        return format(localDateTime, "MM-dd");
    }

}
