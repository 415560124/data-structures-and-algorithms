package com.rhy.datastructuresandalgorithms.stack;


/**
 * @author: Herion Lemon
 * @date: 2021年07月06日 16:54:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 括号匹配
 */
public class BracketMatch {
    public static void main(String[] args) {

        System.out.println(match("[{}{[()]}]"));
    }

    public static boolean match(String str){
        ArrayStack<Character> stack = new ArrayStack<Character>(20);
        char[] chars = str.toCharArray();
        for (int i = 0,len = chars.length; i < len; i++) {
            char aChar = chars[i];
            switch (aChar){
                case '[':
                case '{':
                case '(':
                    stack.push(aChar);
                    break;
                case ']':
                    if(stack.pop() != '['){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.pop() != '{'){
                        return false;
                    }
                    break;
                case ')':
                    if(stack.pop() != '('){
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return true;
    }
}
