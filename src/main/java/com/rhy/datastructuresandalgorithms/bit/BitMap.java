package com.rhy.datastructuresandalgorithms.bit;

/**
 * @author: Herion Lemon
 * @date: 2021/9/26 23:43
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: BitMap实现
 */
public class BitMap {
    /**
     * 存储数据的bit数组
     */
    private byte[] bits;
    /**
     * 存储的最大值
     */
    private int max;

    public BitMap(int max) {
        this.max = max;
        bits = new byte[(max >> 3) + 1]; // (max / 8) + 1
    }

    public void add(int num){
        //计算出存储的bit数组下标
        int bitsIndex = num >> 3;
        //计算出存储在byte中哪个位置bit
        int byteIndex = num % 8;
        //先把1挪动到对应下标位置，然后和原数组做 |运算，只要有一个为1，则为1
        bits[bitsIndex] |= 1 << byteIndex;
    }

    public boolean exist(int num){
        //计算出存储的bit数组下标
        int bitsIndex = num >> 3;
        //计算出存储在byte中哪个位置bit
        int byteIndex = num % 8;

        //把1挪动到对应下标位置，然后做 &运算，必须两个都为1，则为1
        int res = bits[bitsIndex] & (1 << byteIndex);
        if(res == 0){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public void remove(int num){
        //计算出存储的bit数组下标
        int bitsIndex = num >> 3;
        //计算出存储在byte中哪个位置bit
        int byteIndex = num % 8;
        //~取反，0变1，1变0
        bits[bitsIndex] &= ~(1 << byteIndex);
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(100);
        bitMap.add(5);
        bitMap.add(6);
        bitMap.add(10);
        System.out.println(bitMap.exist(5));
        System.out.println(bitMap.exist(10));
        System.out.println(bitMap.exist(11));
        bitMap.remove(5);
        System.out.println(bitMap.exist(5));
        System.out.println(bitMap.exist(6));
        System.out.println(bitMap.exist(10));
        System.out.println(Integer.toBinaryString(~(1 << 5)));
    }
}
