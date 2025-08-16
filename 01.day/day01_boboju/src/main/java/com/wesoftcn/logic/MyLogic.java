package com.wesoftcn.logic;

import com.netease.lowcode.core.annotation.NaslLogic;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.util.StringUtils;

public class MyLogic {

    /**
     * 计算传入日期是当年的第几周
     *
     * @param calendarInput 包含年、月、日信息的日历输入对象
     * @return 当年的第几周
     * @throws InvalidInputException 当输入的日期信息无效时抛出异常
     */
    @NaslLogic
    public static String getWeekOfYear(CalendarInput calendarInput) {
        if (calendarInput == null) {
            throw new InvalidInputException("日历输入对象不能为空");
        }

        if (calendarInput.getYear() == null || calendarInput.getYear().trim().isEmpty() ||
            calendarInput.getMonth() == null || calendarInput.getMonth().trim().isEmpty() ||
            calendarInput.getDay() == null || calendarInput.getDay().trim().isEmpty()) {
            throw new InvalidInputException("年、月、日信息不能为空");
        }

        try {
            // 获取整数值
            Integer year = calendarInput.getYearAsInt();
            Integer month = calendarInput.getMonthAsInt();
            Integer day = calendarInput.getDayAsInt();

            // 使用Joda-Time创建DateTime对象
            DateTime dateTime = new DateTime(year, month, day, 0, 0);

            // 获取当年的第几周（基于ISO 8601标准，一周从周一开始）
            return dateTime.getWeekOfWeekyear();

        } catch (Exception e) {
            throw new InvalidInputException("无效的日期：" + calendarInput.getYear() + "-" + calendarInput.getMonth() + "-" + calendarInput.getDay(), e);
        }
    }
}
