package com.rhy.datastructuresandalgorithms.arithmetic;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: Rhy
 * @date: 2021/9/7 16:06
 * @description: 动态规划
 * 1.有一座高度是10级台阶的楼梯，从下往上走，每跨一步只能向上1级或者2级台阶。要求用程序来求出一共有多少种走法。
 * 2.小偷去商店盗窃，背有一个背包，容量是50kg，现在以下物品（物品不能拆分），请问怎么能偷到最大价值？
 * 3.有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。参与挖矿工人的总数是10人。每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
 */
public class DynamicProgramming {
    public static void main(String[] args) {
        System.out.println(stairs1(4));
        System.out.println(backpack());
        System.out.println(gold());
    }

    /**
     * 1.求台阶走法
     * @param n 多少级台阶
     * @return n级台阶走法数
     */
    public static Integer stairs1(int n){
        //一级台阶走法，只有一个
        if(n == 1){
            return 1;
        }
        //二级台阶走法，只有两个
        if(n == 2){
            return 2;
        }
        //（n-2）级台阶走法数
        int a = 1;
        //（n-1）级台阶走法数
        int b = 2;
        // n级台阶走法数
        int res = 0;
        for (int i = 3; i <= n; i++) {
            //n级台阶走法数等于前两级台阶个数相加
            res = a + b;
            //（n-2）级台阶走法数
            a = b;
            //（n-1）级台阶走法数
            b = res;
        }
        return res;
    }
    /**
     * 2.背包问题
     * @return 最大价值
     */
    public static Integer backpack(){
        int[] weight = {1,2,4};
        int[] money = {60,100,120};
        //n个物品
        int n = 3;
        //背包重量
        int w = 5;
        //每个物品，每个重量下最大价值数列
        int[][] data = new int[n+1][w+1];
        //依次加入每个物品
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < w+1; j++) {
                int currentMoney = 0;
                //当前物品重量小于背包当前格重量
                if(weight[i-1] <= j){
                    //检查【当前商品格价值】和【前一个商品相同重量下格价值】，取最大
                    currentMoney = Math.max(
                            //当前商品价值+剩余背包空间所装的价值
                            money[i-1] + data[i - 1][j - weight[i-1]],
                            data[i - 1][j]
                    );
                }else {
                    currentMoney = data[i - 1][j];
                }
                data[i][j] = currentMoney;
            }
        }

        //输出一下
        for (int i = 1; i < data.length; i++) {
            for (int j = 1; j < data[i].length; j++) {
                System.out.print(data[i][j]+"\t");
            }
            System.out.println();
        }
        return data[n][w];
    }
    /**
     * 3.国王与金矿
     * @return 最大价值
     */
    public static Integer gold(){
        //总人力
        int personNumTotal = 10;
        //金矿数据
        List<GoldDetail> goldDetails = new ArrayList<GoldDetail>(){
            {
                add(new GoldDetail(0,0));
                add(new GoldDetail(5,500));
                add(new GoldDetail(5,400));
                add(new GoldDetail(3,350));
                add(new GoldDetail(4,300));
                add(new GoldDetail(3,200));
            }
        };
        int[][] data = new int[goldDetails.size()][personNumTotal+1];
        List<Integer> goldIndexs = new ArrayList<>();
        Map<Integer,List<GoldDetail>> moneyAndGold = new HashMap<>();
        //循环所有金矿
        for (int i = 1,len = goldDetails.size(); i < len; i++) {
            for (int j = 1; j <= personNumTotal; j++) {
                int currentMoney = 0;
                if (goldDetails.get(i).getPersonNum() > j){
                    currentMoney = data[i-1][j];
                }else {
                    //当前格价值
                    int m1 = goldDetails.get(i).getMoney() + data[i-1][j - goldDetails.get(i).getPersonNum()];
                    //上一个格价值
                    int m2 = data[i-1][j];
                    currentMoney = Math.max(
                            m1,
                            m2
                    );
                    if(m1 > m2){
                        //整理出来当前价值的金矿
                        List<GoldDetail> goldDetailCur = new ArrayList<>();
                        //加入当前金矿
                        goldDetailCur.add(goldDetails.get(i));
                        //加入剩余人力所匹配的最大价值金矿
                        List<GoldDetail> goldDetailsLast = moneyAndGold.get(data[i-1][j - goldDetails.get(i).getPersonNum()]);
                        if(goldDetailsLast != null && goldDetailsLast.size() != 0){
                            goldDetailsLast.stream().forEach(goldDetail -> {
                                goldDetailCur.add(goldDetail);
                            });
                        }
                        moneyAndGold.put(currentMoney,goldDetailCur);
                    }
                }
                data[i][j] = currentMoney;
            }
        }
        //输出一下
        for (int i = 1; i < data.length; i++) {
            for (int j = 1; j < data[i].length; j++) {
                System.out.print(data[i][j]+"\t");
            }
            System.out.println();
        }
        moneyAndGold.forEach((integer, goldDetails1) -> {
            System.out.print("价值【"+integer.toString()+"】\t");
            goldDetails1.forEach(goldDetail -> {
                System.out.print("金矿【"+goldDetail.toString()+"】\t");
            });
            System.out.println();
        });
        return data[goldDetails.size()-1][personNumTotal];
    }
    @Data
    @AllArgsConstructor
    static class GoldDetail{
        //需要的人力
        int personNum;
        //可挖掘的总价值
        int money;
    }
}
