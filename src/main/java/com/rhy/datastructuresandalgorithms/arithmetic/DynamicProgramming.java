package com.rhy.datastructuresandalgorithms.arithmetic;

/**
 * @author: Rhy
 * @date: 2021/9/7 16:06
 * @description: 动态规划
 * 1.有一座高度是10级台阶的楼梯，从下往上走，每跨一步只能向上1级或者2级台阶。要求用程序来求出一共有多少种走法。
 * 2.小偷去商店盗窃，背有一个背包，容量是50kg，现在以下物品（物品不能拆分），请问怎么能偷到最大价值？
 */
public class DynamicProgramming {
    public static void main(String[] args) {
        System.out.println(stairs1(4));
        System.out.println(backpack());
    }

    /**
     * 求台阶走法
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
     * 背包问题
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
}
