package com.rhy.datastructuresandalgorithms.stack;

/**
 * @author: Herion Lemon
 * @date: 2021年07月06日 15:33:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description:
 */
public class ArrayStack<T> {
    private int index;
    private int size;
    private T[] data;
    public ArrayStack(int size){
        this.data = (T[]) new Object[size];
        this.size = size;
        this.index = 0;
    }
    /**
     * 入栈
     * O(1)
     * @param value 值
     */
    public void push(T value){
        //如果当前计数器长度超过了容量
        if(index >= size){
            //扩容
            resize(this.size*2);
        }
        //给数据最后一个位置放入值
        this.data[index++] = value;
    }

    /**
     * 扩容
     * O(n)
     * @param size 扩容后大小
     */
    public void resize(int size){
        //扩容
        T[] newData = (T[]) new Object[size];
        //循环原数组，复制到新数组
        for (int i = 0,len = index; i < len; i++) {
            newData[i] = this.data[i];
        }
        //赋值扩容后数组
        this.data = newData;
    }
    /**
     * 出栈
     * O(1)
     * @return
     */
    public T pop(){
        //如果栈为空，则返回null
        if(index == 0){
            return null;
        }
        //计数器减1 && 弹出最后进入的元素
        T data = this.data[--index];
        //弹出后制空
        this.data[index] = null;
        return data;
    }

    /**
     * 打印输出
     */
    public void print(){
        for (int i = 0; i < index; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return index == 0;
    }
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        for (int i = 0; i < 20; i++) {
            arrayStack.push(i);
        }
        arrayStack.print();
        for (int i = 0; i < 21; i++) {
            System.out.print(arrayStack.pop()+" ");
        }

    }

}
