package com.rhy.datastructuresandalgorithms.recursion;

/**
 * @author: Herion Lemon
 * @date: 2021年07月21日 19:29:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 斐波那契数列
 */
public class Fibonacci {
    static int[] cache;
    public static void main(String[] args) {
        // 1 1 2 3 5
        long startTime = System.currentTimeMillis();
        System.out.println(join(45));
        System.out.println("耗费时间："+(System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        System.out.println(tailRec(45,1,1));
        System.out.println("耗费时间："+(System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        System.out.println(nonRec(45));
        System.out.println("耗费时间："+(System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        cache = new int[45+1];
        System.out.println(cacheRec(45));
        System.out.println("耗费时间："+(System.currentTimeMillis() - startTime));
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

    /**
     * 缓存优化写法
     * O(n)
     * @param index 第几个数
     * @return
     */
    public static int cacheRec(int index){
        if(index <= 2){
            return 1;
        }
        //缓存中存在值则直接返回
        if(cache[index] > 0){
            return cache[index];
        }
        int res = cacheRec(index - 1) + cacheRec(index - 2);
        cache[index] = res;
        return res;
    }
    /**
     * 非递归优化写法
     * O(n)
     * @param index
     * @return
     */
    public static int nonRec(int index){
        if(index <= 2){
            return 1;
        }
        int last = 1;
        int next = 1;
        for(int i=3;i<=index;i++){
            //两数相加
            int temp = last + next;
            //设置为上一个数
            last = next;
            //设置两数相加为当前数
            next = temp;
        }
        return next;
    }

    /**
     * 尾递归优化
     * O(n)
     * @param n 第几个数
     * @param last 上一次的数
     * @param next 当前位的数
     * @return
     */
    public static int tailRec(int n,int last,int next){
        if(n <= 2){
            return next;
        }
        return tailRec(n-1,next,last + next);
    }
}
