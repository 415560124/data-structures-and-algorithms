package com.rhy.datastructuresandalgorithms.list;

/**
 * @author: Herion Lemon
 * @date: 2021年07月02日 13:14:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: LRU缓存实现
 */
public class LRUCache {
    private CNode head;
    private int size;
    private int index;
    public LRUCache(int size) {
        this.size = size;
    }

    /**
     * 新加入的缓存数据放在头部
     * @param key
     * @param data
     */
    public void put(String key,Object data){
        CNode cNode = new CNode(key,data,null);
        if(index++ >= size){
            CNode cur = head;
            while (cur.next != null){
                if(cur.next.next == null){
                    break;
                }
                cur = cur.next;
            }
            if(cur == head){
                head = cNode;
            }else{
                cur.next = null;
            }
            index--;
        }
        if(head == null){
            head = cNode;
        }else{
            cNode.next = head;
            head = cNode;
        }

    }

    /**
     * 查找数据时，把找到的数据移除，并重新插入头部
     * @param key
     * @return
     */
    public Object get(String key){
        CNode cur = head;
        CNode last = null;
        while (cur != null){
            if(cur.key.equals(key)){
                if(last != null){
                    last.next = cur.next;
                    cur.next = head;
                    head = cur;
                }
                return cur.data;
            }
            last = cur;
            cur = cur.next;
        }
        return null;
    }
    public void print(){
        CNode cur = head;
        while (cur != null){
            System.out.print("key:"+ cur.key+"-value:"+cur.data+"  ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put("key1",1);
        lruCache.put("key2",2);
        lruCache.put("key3",3);
        lruCache.put("key5",5);
        lruCache.put("key4",4);
        lruCache.print();
        lruCache.get("key1");
        lruCache.print();
        lruCache.get("key2");
        lruCache.print();
        lruCache.get("key4");
        lruCache.print();
        lruCache.put("key6",6);
        lruCache.print();
    }
}
class CNode{
    public String key;
    public Object data;
    public CNode next;

    public CNode(String key, Object data, CNode next) {
        this.key = key;
        this.data = data;
        this.next = next;
    }
}


