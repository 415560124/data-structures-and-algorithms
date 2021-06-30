package com.rhy.datastructuresandalgorithms.time;

/**
 * @author: Herion Lemon
 * @date: 2021年06月29日 16:06:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 时间复杂度例子
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     * 常数
     */
    void constant(){
        int a = 1; //运行一次，O(1)
        for(int i=0;i<3;i++){ //运行四次（i=0<3、i=1<3、i=2<3、i=3<3）
            a = a+1; //运行3次 O(3)=>O(1)
        }
    }

    /**
     * 对数
     */
    void logarithm(){
        int n = Integer.MAX_VALUE;
        int a = 1;
        /**
         * O(logn)
         * a的值：2、4、8、16 ...  2^n
         * 2^x=n => 求出x就是运行的次数 => x=log2n(对数函数) =>计算机忽略常数 O(logn)
         */
        while (a < n){
            a = a * 2;
        }
        /**
         * O(nlogn)
         */
        for (int i = 0; i < n; i++) {
            while (a < n){
                a = a * 2;
            }
        }
    }

    /**
     * 线性
     */
    void linear(){
        int n = Integer.MAX_VALUE;
        int a = 1;
        //O(n)
        for (int i = 0; i < n; i++) {
            a = a+1;
        }
    }

    /**
     * 平方
     */
    void square(){
        int n = Integer.MAX_VALUE;
        int a = 1;
        //O(n)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a = a+1;
            }
        }
    }
}
