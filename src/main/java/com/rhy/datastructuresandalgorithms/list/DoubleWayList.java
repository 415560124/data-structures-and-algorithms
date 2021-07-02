package com.rhy.datastructuresandalgorithms.list;

/**
 * @author: Herion Lemon
 * @date: 2021年07月02日 10:05:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 双向链表
 */
public class DoubleWayList {

    /**
     * 头节点
     */
    public DNode head;
    /**
     * 尾节点
     */
    public DNode tail;

    public int index;

    public void insertHead(Object data){
        DNode newNode = new DNode(null,data,null);
        if(head == null){
            tail = newNode;
        }else{
            head.prev = newNode;
            newNode.next = head;
        }
        head = newNode;
    }

    public void deleteHead(){
        if(head.next == null){
            head = null;
            tail = null;
        }else {
            head = head.next;
            head.prev = null;
        }
    }
}

class DNode{
    public Object data;
    public DNode next;
    public DNode prev;

    public DNode(DNode prev,Object data, DNode next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}