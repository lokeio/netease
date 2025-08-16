package com.wesoftcn.logic;

import com.netease.lowcode.core.annotation.NaslStructure;

@NaslStructure
public class CalendarInput {
    /**
     * 年
     */
    public String year;

    /**
     * 月
     */
    public String month;

    /**
     * 日
     */
    public String day;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        if (year == null || year.trim().isEmpty()) {
            throw new InvalidInputException("年份不能为空");
        }
        try {
            int yearInt = Integer.parseInt(year.trim());
            if (yearInt < 2000 || yearInt > 9999) {
                throw new InvalidInputException("年份必须是从2000年开始的4位数字，当前值: " + year);
            }
        } catch (NumberFormatException e) {
            throw new InvalidInputException("年份必须是数字，当前值: " + year);
        }
        this.year = year.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        if (month == null || month.trim().isEmpty()) {
            throw new InvalidInputException("月份不能为空");
        }
        try {
            int monthInt = Integer.parseInt(month.trim());
            if (monthInt < 1 || monthInt > 12) {
                throw new InvalidInputException("月份取值范围为1-12，当前值: " + month);
            }
        } catch (NumberFormatException e) {
            throw new InvalidInputException("月份必须是数字，当前值: " + month);
        }
        this.month = month.trim();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        if (day == null || day.trim().isEmpty()) {
            throw new InvalidInputException("日期不能为空");
        }
        int dayInt;
        try {
            dayInt = Integer.parseInt(day.trim());
            if (dayInt < 1 || dayInt > 31) {
                throw new InvalidInputException("日期取值范围为1-31，当前值: " + day);
            }
        } catch (NumberFormatException e) {
            throw new InvalidInputException("日期必须是数字，当前值: " + day);
        }

        // 检查月份是否已设置，如果已设置则进行更精确的日期校验
        if (this.month != null && !this.month.trim().isEmpty()) {
            try {
                int monthInt = Integer.parseInt(this.month.trim());
                Integer yearInt = null;
                if (this.year != null && !this.year.trim().isEmpty()) {
                    yearInt = Integer.parseInt(this.year.trim());
                }
                int maxDayInMonth = getMaxDayInMonth(monthInt, yearInt);
                if (dayInt > maxDayInMonth) {
                    throw new InvalidInputException("该月份最多有" + maxDayInMonth + "天，当前值: " + day);
                }
            } catch (NumberFormatException e) {
                // 如果月份或年份格式有问题，在这里不处理，让设置月份或年份时抛出异常
            }
        }

        this.day = day.trim();
    }

    /**
     * 获取指定月份的最大天数
     */
    private int getMaxDayInMonth(int month, Integer year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if (year != null && isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 31;
        }
    }

    /**
     * 判断是否为闰年
     */
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * 获取年份的整数值
     */
    public Integer getYearAsInt() {
        if (year == null || year.trim().isEmpty()) {
            return null;
        }
        try {
            return Integer.parseInt(year.trim());
        } catch (NumberFormatException e) {
            throw new InvalidInputException("年份格式无效: " + year);
        }
    }

    /**
     * 获取月份的整数值
     */
    public Integer getMonthAsInt() {
        if (month == null || month.trim().isEmpty()) {
            return null;
        }
        try {
            return Integer.parseInt(month.trim());
        } catch (NumberFormatException e) {
            throw new InvalidInputException("月份格式无效: " + month);
        }
    }

    /**
     * 获取日期的整数值
     */
    public Integer getDayAsInt() {
        if (day == null || day.trim().isEmpty()) {
            return null;
        }
        try {
            return Integer.parseInt(day.trim());
        } catch (NumberFormatException e) {
            throw new InvalidInputException("日期格式无效: " + day);
        }
    }
}
