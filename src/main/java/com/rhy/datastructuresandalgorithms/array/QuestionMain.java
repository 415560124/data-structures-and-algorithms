package com.rhy.datastructuresandalgorithms.array;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: Herion Lemon
 * @date: 2021年06月30日 10:14:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description:
 */
public class QuestionMain {
    public static void main(String[] args) throws IOException {
        question1();
    }

    /**
     * 给你一个文件里面包含全国人民（14亿）的年龄数据（0~200），现在要你统计每一个年龄有多少人？
     */
    static void question1() throws IOException {
        //文件名
        String fileName = System.getProperty("user.dir")+"//file//age.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        //存储年龄数量集合
        int[] ages = new int[200];
        //总计数量
        int total = 0;
        //每行数据
        String str;
        //O(n)
        while((str = bufferedReader.readLine()) != null){
            int age = Integer.valueOf(str);
            ages[age]++;
            total++;
        }
        //O(1)
        for (int i = 0,len = ages.length; i < len; i++) {
            System.out.println("年龄-"+i+"，有"+ages[i]+"人");
        }
    }
}
