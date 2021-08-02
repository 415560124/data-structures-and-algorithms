package com.rhy.datastructuresandalgorithms.recursion;

/**
 * @author: Herion Lemon
 * @date: 2021/8/2 22:23
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 阶乘递归及优化
 * 5*4*3*2*1
 */
public class Factorial {
    /**
     * 递归写法
     * @param n 从几开始乘
     * @return
     */
    public static int rec(int n){
        if(n <= 1){
            return 1;
        }
        return n * rec(n-1);
    }

    /**
     * 尾递归写法
     * @param n 从几开始乘
     * @param last 上一次相乘的结果
     * @return
     */
    public static int tailRec(int n,int last){
        if(n <= 1){
            return last;
        }
        return tailRec(n-1,n * last);
    }

    public static void main(String[] args) {
        System.out.println(rec(5));
        System.out.println(tailRec(5,1));
    }
}
