package com.rhy.datastructuresandalgorithms.list;

/**
 * @author: Herion Lemon
 * @date: 2021年07月01日 16:30:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 单向链表实现
 */
public class OneWayList {
    /**
     * 头节点
     */
    public Node head;
    /**
     * 尾节点
     */
    public Node tail;

    public int index;
    /**
     * 头插
     * @param data
     */
    public void addHead(Object data){
        Node node = new Node(data,head);
        this.head = node;
        if(this.tail == null){
            this.tail = node;
        }
        index++;
    }

    /**
     * 尾插
     * @param data
     */
    public void addTail(Object data){
        Node node = new Node(data,null);
        this.tail.next = node;
        this.tail = node;
        if(this.head == null){
            this.head = node;
        }
        index++;
    }

    /**
     * 指定位置插入
     * @param pos
     * @param data
     */
    public void add(int pos,Object data){
        Node temp = this.head;
        for (int i = 1; i < pos; i++) {
            if(temp == null){
                //下标越界
                return;
            }
            temp = temp.next;
        }
        Node node = new Node(data,temp.next);
        temp.next = node;
        if(tail == temp){
            this.tail = node;
        }
        if(head == temp){
            this.head = node;
        }
        index++;
    }

    /**
     * 头部删除
     */
    public void removeHead(){
        if(this.head == this.tail){
            this.tail = null;
        }
        this.head = this.head.next;
        index--;
    }

    /**
     * 尾部删除
     */
    public void removeTail(){
        Node temp = this.head;
        Node last = null;
        while (temp.next != null){
            if(temp.next.next == null){
                last = temp;
            }
            temp = temp.next;
        }
        this.tail = last;
        last.next = null;
    }
}

class Node{
    public Object data;
    public Node next;

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
}
