package com.rhy.datastructuresandalgorithms.recursion;

/**
 * @author: Herion Lemon
 * @date: 2021年07月21日 19:29:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 斐波那契数列
 */
public class Fibonacci {
    public static void main(String[] args) {
        // 1 1 2 3 5
        System.out.println(join(5));
    }

    /**
     * 斐波那契数列公式
     * O(2^n)
     * @param index 第几个数
     * @return 返回第几个数的值
     */
    public static int join(int index){
        if(index <= 2){
            return 1;
        }
        return join(index-1) + join(index-2);
    }
}
