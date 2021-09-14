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
                BinarySearchTreeNode insNode = createNode(data, curNode);
                curNode.setRight(insNode);
                return insNode;
            }
            //右节点存在数据，继续和下级节点比较
            return set(data,curNode.getRight());
        }else{
            //左节点如果为空，直接放入
            if(curNode.getLeft() == null){
                BinarySearchTreeNode insNode = createNode(data, curNode);
                curNode.setLeft(insNode);
                return insNode;
            }
            //左节点存在数据继续和左节点比较
            return set(data,curNode.getLeft());
        }
    }

    /**
     * 创建节点
     * @param data
     * @param curNode
     * @return
     */
    private BinarySearchTreeNode createNode(int data,BinarySearchTreeNode curNode){
        BinarySearchTreeNode res = new BinarySearchTreeNode().setData(data);
        res.setParent(curNode);
        return res;
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

    /**
     * 删除
     * @param data
     * @param node
     * @return
     */
    public BinarySearchTreeNode delete(int data,BinarySearchTreeNode node){
        //先查到节点
        BinarySearchTreeNode delNode = get(data, node);
        if(delNode == null){
            return null;
        }
        //当前节点父节点
        BinarySearchTreeNode parent = delNode.getParent();
        //当前节点左节点
        BinarySearchTreeNode curLeft = delNode.getLeft();
        //当前节点右节点
        BinarySearchTreeNode curRight = delNode.getRight();
        //1.无子节点
        if (curLeft == null && curRight == null){
            if(parent.getLeft() == delNode){
                parent.setLeft(null);
            }else {
                parent.setRight(null);
            }
            return delNode;
        }
        //2.只有一个子节点
        if(curLeft != null && curRight == null){
            if(parent.getLeft() == delNode){
                parent.setLeft(curLeft);
            }else {
                parent.setRight(curLeft);
            }
            return delNode;
        }
        //2.只有一个子节点
        if(curRight != null && curLeft == null){
            if(parent.getLeft() == delNode){
                parent.setLeft(curRight);
            }else {
                parent.setRight(curRight);
            }
            return delNode;
        }
        //3.左右节点都存在
        //此时有两个选择：
        // （1）找左节点最大的
        // （2）找右节点最小的
        BinarySearchTreeNode newNode = findRight(delNode.getRight());
        //把这个节点移动到删除节点去
        BinarySearchTreeNode newNodeParent = newNode.getParent();
        if(newNodeParent.getLeft() == newNode){
            newNodeParent.setLeft(null);
        }else {
            newNodeParent.setRight(null);
        }
        newNode.setParent(delNode.getParent());
        if(parent != null){
            if(parent.getLeft() == delNode){
                parent.setLeft(newNode);
            }else {
                parent.setRight(newNode);
            }
        }
        //原节点左右指针挪到新节点
        newNode.setLeft(delNode.getLeft());
        newNode.setRight(delNode.getRight());
        if(delNode == root){
            root = newNode;
        }
        return delNode;
    }

    /**
     * 找右节点最小的
     * @param node
     * @return
     */
    public BinarySearchTreeNode findRight(BinarySearchTreeNode node){
        if(node.getLeft() != null){
            return findRight(node.getLeft());
        }
        return node;
    }

    /**
     * 找左节点最大的
     * @param node
     * @return
     */
    public BinarySearchTreeNode findLeft(BinarySearchTreeNode node){
        if(node.getRight() != null){
            findLeft(node.getRight());
        }
        return node;
    }
    /**
     * 前序遍历：根、左、右
     * @param root 树根节点
     */
    public static void pre(BinarySearchTreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.getData());  //ABCD
        pre(root.getLeft());
        pre(root.getRight());
    }
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree(5);
        binarySearchTree.set(3,null);
        binarySearchTree.set(4,null);
        binarySearchTree.set(2,null);
        binarySearchTree.set(1,null);
        binarySearchTree.set(8,null);
        binarySearchTree.set(9,null);
        binarySearchTree.set(7,null);
        binarySearchTree.set(6,null);
        pre(binarySearchTree.root);
        System.out.println();
        binarySearchTree.delete(5,null);
        pre(binarySearchTree.root);
        System.out.println();
    }

}
@Data
@Accessors(chain = true)
class BinarySearchTreeNode{
    private int data;
    private BinarySearchTreeNode left;
    private BinarySearchTreeNode right;
    private BinarySearchTreeNode parent;
}
