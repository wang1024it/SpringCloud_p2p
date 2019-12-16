package com.wyy.common_p2p.utils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 这是项目要用到的算钱工具类
 * @Author: cpc
 * @Date: 2019-10-24 13:39
 * @Version: V1.0
 */
public class BigDecimalUtil {
    /*小数点后保留几位 (计算出结果后保留的数)*/
    private static final int SCALE = 3;
    /*小数点后保留几位 (计算过程保留的数据)*/
    private static final int SCALE_PROCESS = 1000;
    /*这是高位采取的策略*/
    private static final int ROUNDINGMODE  = BigDecimal.ROUND_HALF_UP;

    ////////////////////////////////////////////// 到期本息 ///////////////////////////////////////////////////////
    /**
     *到期本息计算，返回 本金 + 利息
     * 计算公式： 到期一次还本付息额=贷款本金×[1+月利率（‰）×贷款期（月）] （贷款期不到一年）
     * @param principal 本金
     * @param annualInterestRate 年利率
     * @param loanPeriod 贷款期（月）
     * @return 到期本息和 （本金 + 利息）
     */
    public static BigDecimal maturityPrincipalAndInterestSum(BigDecimal principal, BigDecimal annualInterestRate, int loanPeriod){
              //本金 + 利息
       return principal.add(BigDecimalUtil.maturityPrincipalAndInterestInterest(principal, annualInterestRate, loanPeriod));
    }


    /**
     * 到期本息计算 总利息
     * @param principal 本金
     * @param annualInterestRate 年利率
     * @param loanPeriod 贷款期（月）
     * @return 利息
     */
    public static BigDecimal maturityPrincipalAndInterestInterest(BigDecimal principal, BigDecimal annualInterestRate, int loanPeriod){
        //计算月利率
        return annualInterestRate.divide(new BigDecimal("12"), SCALE_PROCESS, ROUNDINGMODE)
                //乘以 贷款期
                .multiply(new BigDecimal(loanPeriod + ""))
                //乘以  贷款本金
                .multiply(principal)
                //对精度的四舍五入
                .setScale(SCALE, ROUNDINGMODE);

    }


    ////////////////////////////////////////////// 等额本金 ///////////////////////////////////////////////////////


    /**
     * 计算每期应还本金额度
     * @param principal 本金
     * @param loanPeriod 期数
     * @return
     */
    public static BigDecimal periodPrincipal(BigDecimal principal, int loanPeriod){
        return principal.divide(new BigDecimal("" + loanPeriod ), SCALE, ROUNDINGMODE);
    }


    /**
     * 这是计算每期应还多少利息,返回List集合 get(0) 代表的是第期
     * @param principal 本金
     * @param annualInterestRate 年利率
     * @param loanPeriod 贷款期数（月）
     * @return
     */
    public static List<BigDecimal> equalPrincipalMonthlyInterests(BigDecimal principal, BigDecimal annualInterestRate, int loanPeriod){
        //这是当前还欠的钱
        ArrayList<BigDecimal> interests = new ArrayList<>(loanPeriod);
        //计算月利率
        BigDecimal monthlyInterestRate = annualInterestRate.divide(new BigDecimal("12"), SCALE_PROCESS, ROUNDINGMODE);
        //这是每个月应还的本金
        BigDecimal monthPrincipal =  BigDecimalUtil.periodPrincipal(principal, loanPeriod);

        BigDecimal n = null;
        //循环计算每月利息 钱
        for (int i =0; i < loanPeriod; i ++){
            n  = principal.multiply(monthlyInterestRate).setScale(SCALE, ROUNDINGMODE);
            interests.add(n);
            //减去已经还了的本金
            principal = principal.subtract(monthPrincipal);
        }
        return interests;
    }


    ////////////////////////////////////////////// 等额本息 ///////////////////////////////////////////////////////


    /**
     * 这是计算等额本息：每个月应还的利息
     *             =贷款本金×[月利率×(1+月利率)^还款月数]÷{[(1+月利率)^还款月数]-1}
     * 计算公式： 贷款本金×月利率×(1+月利率)^还款月数〕÷〔(1+月利率)^还款月数-1〕
     *
     *bug修补说明：这里剪去了  每个月还款本金
     * @param principal 本金
     * @param annualInterestRate 年利率
     * @param loanPeriod 贷款期数（月）
     * @return
     */
    public static  BigDecimal equalAmountPrincipal(BigDecimal principal, BigDecimal annualInterestRate, int loanPeriod){
        //计算月利率
        BigDecimal monthlyInterestRate = annualInterestRate.divide(new BigDecimal("12"), SCALE_PROCESS, ROUNDINGMODE);

        //(1+月利率)^还款月数
        BigDecimal s = monthlyInterestRate
                       // 月利率 + 1
                      .add(new BigDecimal("1"))
                      //这是 算出的结构再求与还款月数的次幂
                      .pow(loanPeriod);

//        〔贷款本金×月利率×(1+月利率)^还款月数〕
        BigDecimal a =
                //贷款本金×月利率
                principal.multiply(monthlyInterestRate)
                //×(1+月利率)^还款月数
                .multiply(s);

//        〔(1+月利率)^还款月数-1〕
        BigDecimal b =  s.subtract(new BigDecimal("1"));

//        计算结果：〔贷款本金×月利率×(1+月利率)^还款月数〕÷〔(1+月利率)^还款月数-1〕 并返回
        return  a.divide(b, SCALE_PROCESS, ROUNDINGMODE)
                //这是减掉本金计算出利息
                .subtract(periodPrincipal(principal, loanPeriod))
                //处理小数点（四舍五入）
                .setScale(SCALE, ROUNDINGMODE);
    }

    public static void main(String[] args) {
        BigDecimal lx = new BigDecimal("0.1");
        BigDecimal bj  = new BigDecimal("1000");
        System.out.println(BigDecimalUtil.equalAmountPrincipal(bj, lx, 12));
    }


}

