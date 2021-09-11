package com.rhy.datastructuresandalgorithms.tree;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: Herion Lemon
 * @date: 2021/9/11 15:33
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 二叉树实现
 * 树结构图形地址
 * https://www.processon.com/view/link/613c5e160e3e747075a5eb8c
 */
public class BinaryTree {
    public static void main(String[] args) {
        TreeNode a = new TreeNode().setData("A");
        TreeNode b = new TreeNode().setData("B");
        TreeNode c = new TreeNode().setData("C");
        TreeNode d = new TreeNode().setData("D");
        TreeNode e = new TreeNode().setData("E");
        TreeNode f = new TreeNode().setData("F");
        TreeNode g = new TreeNode().setData("G");
        TreeNode h = new TreeNode().setData("H");
        TreeNode i = new TreeNode().setData("I");

        a.setLeft(b);
        a.setRight(e);

        b.setRight(c);

        c.setLeft(d);

        e.setLeft(f);

        f.setRight(g);

        g.setLeft(h);
        g.setRight(i);
        //前序遍历
        pre(a);
        System.out.println();
        //中序遍历
        middle(a);
        System.out.println();
        //后序遍历
        last(a);
        System.out.println();


        aa(2);
    }
    /**
     * 前序遍历：根、左、右
     * @param root 树根节点
     */
    public static void pre(TreeNode root){
        if(root ==null){
            return;
        }
        System.out.print(root.getData());  //ABCD
        pre(root.getLeft());
        pre(root.getRight());
    }

    /**
     * 中序遍历：左、根、右
     * @param root 树根节点
     */
    public static void middle(TreeNode root){
        if(root ==null){
            return;
        }
        middle(root.getLeft());
        System.out.print(root.getData());
        middle(root.getRight());
    }
    /**
     * 后序遍历：左、右、根
     * @param root 树根节点
     */
    public static void last(TreeNode root){
        if(root ==null){
            return;
        }
        last(root.getLeft());
        last(root.getRight());
        System.out.print(root.getData());
    }
    public static void aa(int a){
        if(a == 0){
            return;
        }
        int temp = a;
        aa(--a);
        System.out.println(temp);
    }
}
@Data
@Accessors(chain = true)
class TreeNode{
    private String data;
    private TreeNode left;
    private TreeNode right;
}
