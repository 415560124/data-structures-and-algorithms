package com.rhy.datastructuresandalgorithms.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Herion Lemon
 * @date: 2021年07月07日 10:26:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 简易版计算器  3+11*2+8-15/5
 */
public class Calculator {

    /**
     * 数字栈
     */
    private ArrayStack<Integer> nums = new ArrayStack<Integer>(10);
    /**
     * 符号栈
     */
    private ArrayStack<Character> operators = new ArrayStack<Character>(10);

    private Map<Character,Integer> operatorOrder = new HashMap<Character,Integer>(){
        {
            put('+',1);
            put('-',1);
            put('*',2);
            put('/',2);
        }
    };
    /**
     * 运算
     * @return
     */
    public int operation(String expre){
        char[] chars = expre.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char aChar : chars) {
            switch (aChar){
                case '+':
                case '-':
                case '*':
                case '/':
                    if(builder.length() != 0){
                        //组合的数字推入到数字栈中
                        nums.push(Integer.valueOf(builder.toString()));
                        //清空数字builder
                        builder.delete(0,builder.length());
                    }
                    //处理运算符
                    preDoOperation(aChar);
                    break;
                default:
                    //加到数字builder中
                    builder.append(aChar);
                    break;
            }
        }
        if(builder.length() != 0){
            //组合的数字推入到数字栈中
            nums.push(Integer.valueOf(builder.toString()));
            //清空数字builder
            builder.delete(0,builder.length());
        }
        Character operator = null;
        while((operator = operators.pop()) != null){
            nums.push(
                    doOperation(nums.pop(), nums.pop(), operator)
            );
        }
        return nums.pop();
    }

    /**
     * 运算预处理
     * 1.如果当前运算符优先级大于栈顶运算符优先级，则直接入栈
     * 2.如果当前运算符优先级小于等于栈顶运算符优先级，则弹出数字栈顶俩元素开始计算
     */
    public void preDoOperation(char aChar){
        //弹出运算符
        Character character = operators.pop();
        //如果当前算数符优先级大于栈顶算数符，直接入栈
        if(character == null || operatorOrder.get(aChar) > operatorOrder.get(character)){
            if(character != null){
                operators.push(character);
            }
            operators.push(aChar);
            return;
        }else{
            //相等或小于栈顶算数符，弹出数字栈顶俩元素开始计算
            int res = doOperation(nums.pop(), nums.pop(), character);
            nums.push(res);
            //再次递归处理
            preDoOperation(aChar);
        }
    }
    /**
     * 执行运算
     * @return
     */
    public int doOperation(int num1,int num2,char operation){
        switch (operation){
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1;
            case '*':
                return num1 * num2;
            case '/':
                return num2 / num1;
            default:
                throw new RuntimeException("未知运算符");
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
//        int operation = calculator.operation("3+11*2+8-15/5");
        int operation = calculator.operation("40+11*2/2-1");
        System.out.println(operation);
    }
}
