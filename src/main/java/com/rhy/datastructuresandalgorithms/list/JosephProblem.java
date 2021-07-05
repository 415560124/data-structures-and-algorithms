package com.rhy.datastructuresandalgorithms.list;

/**
 * @author: Herion Lemon
 * @date: 2021年07月02日 14:11:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description:
 */
public class JosephProblem {
    private JNode head;
    private int index;
    public void insertHead(Object data){
        JNode newNode = new JNode(null,data,null);
        if(head != null){
            newNode.prev = head.prev;
            newNode.next = head;
            head.prev.next = newNode;
            head.prev = newNode;
            if(head.next == head){
                head.next = newNode;
            }
        }else {
            newNode.next = newNode;
            newNode.prev = newNode;
        }
        head = newNode;
        index++;
    }

    public JNode deleteHead(Object data){
        JNode cur = head;
        for (int i = 1; i < index; i++) {
            if(cur.data.equals(data)){
                break;
            }
            cur = cur.next;
        }
        JNode prev = cur.prev;
        prev.next = cur.next;
        JNode next = cur.next;
        next.prev = cur.prev;
        if(cur == head){
            head = cur.next;
        }
        index--;
        return cur;
    }

    /**
     *
     * @param pos 每{pos}个人死
     * @param end 直到剩下{end}个人
     * @return
     */
    public void die(JNode begin,int pos,int end){
        if(index <= end){
            print();
            return;
        }
        JNode cur = begin == null ? head : begin;
        for (int i = 1; i < pos; i++) {
            cur = cur.next;
        }
        deleteHead(cur.data);
        print();
        die(cur.next,pos,end);
    }

    public void print(){
        JNode cur = head;
        for (int i = 0; i < index; i++) {
            System.out.print(cur.data+"  ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void print(JNode cur){
        for (int i = 0; i < index; i++) {
            System.out.print(cur.data+"  ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        JosephProblem josephProblem = new JosephProblem();
//        for (int i = 41; i >= 1; i--) {
//            josephProblem.insertHead(i);
//        }
//        josephProblem.print();
//        josephProblem.die(null,3,2);
        for (int i = 6; i >= 1; i--) {
            josephProblem.insertHead(i);
        }
        josephProblem.print();
        josephProblem.die(null,5,0);
    }
}

class JNode{
    public JNode prev;
    public Object data;
    public JNode next;

    public JNode(JNode prev,Object data, JNode next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
