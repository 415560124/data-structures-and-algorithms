package com.rhy.datastructuresandalgorithms.tree;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: Herion Lemon
 * @date: 2021/9/13 22:21
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 二叉查找树(左节点 < 根节点 < 右节点)
 */
public class BinarySearchTree {
    private BinarySearchTreeNode root;
    public BinarySearchTree(int root) {
        this.root = new BinarySearchTreeNode().setData(root);
    }

    /**
     * 新增
     * @param data
     * @param node
     * @return
     */
    public BinarySearchTreeNode set(int data,BinarySearchTreeNode node){
        //初次进来数据从根节点开始比较放入
        BinarySearchTreeNode curNode = this.root;
        if(node != null){
            //递归后从子树继续比较
            curNode = node;
        }
        //入参数据大于当前节点
        if(data > curNode.getData()){
            //并且右节点为空，则直接放在右节点
            if(curNode.getRight() == null){
                curNode.setRight(
                        new BinarySearchTreeNode().setData(data)
                );
                return curNode;
            }
            //右节点存在数据，继续和下级节点比较
            return set(data,curNode.getRight());
        }else{
            //左节点如果为空，直接放入
            if(curNode.getLeft() == null){
                curNode.setLeft(
                        new BinarySearchTreeNode().setData(data)
                );
                return curNode;
            }
            //左节点存在数据继续和左节点比较
            return set(data,curNode.getLeft());
        }
    }

    /**
     * 查找
     * @param data
     * @param node
     * @return
     */
    public BinarySearchTreeNode get(int data,BinarySearchTreeNode node){
        //初次进来数据从根节点开始比较放入
        BinarySearchTreeNode curNode = this.root;
        if(node != null){
            //递归后从子树继续比较
            curNode = node;
        }
        //如果数据相等则直接返回
        if(curNode.getData() == data){
            return curNode;
        }else if (data > curNode.getData()){
            //如果入参数据大于当前节点，则继续往右节点找
            //如果右节点为空，则直接返回
            if(curNode.getRight() == null){
                return null;
            }
            return get(data,curNode.getRight());
        }else {
            //如果入参数据小于当前节点，则继续往左节点找
            //如果左节点为空，则直接返回
            if (curNode.getLeft() == null){
                return null;
            }
            return get(data,curNode.getLeft());
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree(5);
        System.out.println(binarySearchTree.set(3,null));
        System.out.println(binarySearchTree.set(4,null));
        System.out.println(binarySearchTree.set(2,null));
        System.out.println(binarySearchTree.set(1,null));
    }

}
@Data
@Accessors(chain = true)
class BinarySearchTreeNode{
    private int data;
    private BinarySearchTreeNode left;
    private BinarySearchTreeNode right;
}
