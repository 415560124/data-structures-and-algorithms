package com.rhy.datastructuresandalgorithms.queue;


/**
 * @author: Herion Lemon
 * @date: 2021年07月08日 14:26:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 数组实现队列
 */
public class ArrayQueue<T> {
    private T[] data;
    private int offset;
    private int length;
    private int size;

    public ArrayQueue(int size) {
        this.size = size;
        data = (T[]) new Object[size];
    }

    /**
     * 入队
     * O(1)
     * 最坏的情况，在扩容时是O(n)。那么计算平均时间复杂度：比如数组容量为N，n=1000，前999都是O(1) n*2/n
     * @param item
     */
    public void push(T item){
        if(isFull()){
            //当队列满了的时候移动队列重新从下标0开始
            for (int i = offset; i < length; i++) {
                data[i-offset] = data[i];
                data[i] = null;
            }
            length = length - offset;
            offset = 0;
            if(isFull()){
                //扩容，或者其他策略
                return;
            }
        }
        data[length++] = item;
    }

    /**
     * 出队
     * O(1)
     * @return
     */
    public T pop(){
        if(isEmpty()){
            return null;
        }
        T res = data[offset];
        data[offset++] = null;
        return res;
    }

    private boolean isEmpty() {
        return offset == length;
    }

    /**
     * 是否已满
     * @return
     */
    private boolean isFull() {
        return length >= size;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(4);
        for (int i = 1; i <= 4; i++) {
            queue.push(i);
        }

        for (int i = 0; i < 2; i++) {
            System.out.println(queue.pop());
        }
        queue.push(4);
        for (int i = 0; i < 4; i++) {
            System.out.println(queue.pop());
        }
    }
}
