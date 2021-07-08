package com.rhy.datastructuresandalgorithms.stack;

/**
 * @author: Herion Lemon
 * @date: 2021年07月07日 10:28:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 浏览器前进后退
 */
public class Browser {
    /**
     * 后退栈
     */
    private ArrayStack<String> backup = new ArrayStack<String>(10);
    /**
     * 前进栈
     */
    private ArrayStack<String> advance = new ArrayStack<String>(10);
    /**
     * 当前页
     */
    private String cur;
    /**
     * 是否可以后退标志
     */
    private boolean isBackup;
    /**
     * 是否可以前进标志
     */
    private boolean isAdvance;

    /**
     * 跳转功能
     */
    public void doSkip(String url){
        if(cur != null){
            //原地址推入到后退栈中
            backup.push(cur);
            //可以后退标志为true
            isBackup = true;
            //前进清空
            advance = new ArrayStack<String>(10);
            isAdvance = false;
        }
        cur = url;
    }

    /**
     * 后退
     * @return
     */
    public String doBackup(){
        if(!isBackup){
            //标志为false代表不能后退，直接返回null
            return null;
        }
        //当前页推入到前进栈中
        advance.push(cur);
        //标记可以前进
        isAdvance = true;
        //从后退栈中弹出上一个网站地址
        cur = backup.pop();
        if(backup.isEmpty()){
            //后退栈为空设置标志false不能后退了
            isBackup = false;
        }
        return cur;
    }

    /**
     * 前进功能
     * @return
     */
    public String doAdvance(){
        if(!isAdvance){
            //标志为false代表不能前进
            return null;
        }
        //当前页推入到后退栈中
        backup.push(cur);
        //后退栈标记可以后退
        isBackup = true;
        //从前进栈中弹出上一个网站地址
        cur = advance.pop();
        if(advance.isEmpty()){
            //前进栈为空，设置标志false不能后退
            isAdvance = false;
        }
        return cur;
    }
    public static void main(String[] args) {
        Browser browser = new Browser();
        browser.doSkip("www.baidu.com");
        browser.doSkip("www.baidu1.com");
        browser.doSkip("www.baidu2.com");
        browser.doSkip("www.baidu3.com");
        browser.doBackup();
        System.out.println(browser.cur);
        browser.doBackup();
        System.out.println(browser.cur);
        browser.doAdvance();
        System.out.println(browser.cur);
        browser.doAdvance();
        System.out.println(browser.cur);
    }

}
