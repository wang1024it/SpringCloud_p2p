package com.wyy.common_p2p.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @Description: 还款时间技术攻击类
 * @Author: cpc
 * @Date: 2019-11-03 4:36
 * @Version: V1.0
 */
public class RepaymentDateUtil {
    //这是一期的间隔时间
    private static final int period = 30;


    /**
     * 这是计算出制定的期的还款日期
     * @param periodNumber 那一期
     * @return
     */
    public static Date getDate(int periodNumber){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 30 * periodNumber);
        return c.getTime();
    }

    public static void main(String[] args) {
        System.out.println(RepaymentDateUtil.getDate(1).toLocaleString());
    }
}
