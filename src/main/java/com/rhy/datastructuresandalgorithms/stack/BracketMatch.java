package com.rhy.datastructuresandalgorithms.stack;

import org.yaml.snakeyaml.util.ArrayStack;

/**
 * @author: Herion Lemon
 * @date: 2021年07月06日 16:54:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 括号匹配
 */
public class BracketMatch {
    public static void main(String[] args) {

        System.out.println(match("[{}{[())]}]"));
    }

    public static String match(String str){
        ArrayStack<Character> stack = new ArrayStack<>(20);
        char[] chars = str.toCharArray();
        boolean isError = false;
        for (int i = 0,len = chars.length; i < len; i++) {
            char aChar = chars[i];
            switch (aChar){
                case '[':
                case '{':
                case '(':
                    stack.push(aChar);
                    break;
                default:
                    Character pop = stack.pop();
                    switch (pop){
                        case '[':
                            if(aChar != ']'){
                                isError = true;
                            }
                            break;
                        case '{':
                            if(aChar != '}'){
                                isError = true;
                            }
                            break;
                        case '(':
                            if (aChar != ')'){
                                isError = true;
                            }
                            break;
                        default:
                            isError = true;
                    }
                    break;
            }
            if(isError){
                break;
            }
        }
        return isError ? "异常" : "正确";
    }
}
