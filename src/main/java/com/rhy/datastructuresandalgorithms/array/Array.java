package com.rhy.datastructuresandalgorithms.array;

/**
 * @author: Herion Lemon
 * @date: 2021年06月30日 14:16:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 数组实现
 */
public class Array {
    //数组容量
    private int size;
    //数据长度
    private int index;
    //数据存放数组
    private Object[] data;

    public Array(int size) {
        this.size = size;
        index = 0;
        data = new Object[size];
    }

    /**
     * 插入元素
     * O(n)
     * @param location
     * @param value
     */
    public void add(int location, Object value){
        if(index++ < size){
            //让下标i之后的元素依次往后移动
            for(int i=size-1;i>location;i--){
                data[i] = data[i-1];
            }
            data[location] = value;
        }else{
            //1.容量不足，开始扩容
            //2.扩容后复制数组元素
            //3.移动元素，赋值新元素到下标location
        }
    }

    /**
     * 删除元素
     * O(n)
     * @param location
     */
    public void delete(int location){
        //删除下标之后的元素都要往前挪动
        for(int i=location;i<size-1;i++){
            data[i] = data[i+1];
        }
        data[size - 1] = 0;
        index--;
    }
    public void add(Object value){
        if(index++ < size){
            data[index-1] = value;
        }
    }

    /**
     * 修改元素
     * O(1)
     * @param location
     * @param value
     */
    public void update(int location, Object value){
        data[location] = value;
    }

    /**
     * 查看元素
     * O(1)
     * @param location
     * @return
     */
    public Object get(int location){
        return data[location];
    }

    public void print(){
        for (Object value:data) {
            System.out.print(value+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("123".replace("1","2"));
        Array array = new Array(4);
        array.add(1);
        array.add(1,2);
        array.add(1,3);
        array.add(1,4);
        array.print();
        array.delete(1);
        array.print();
    }
}
