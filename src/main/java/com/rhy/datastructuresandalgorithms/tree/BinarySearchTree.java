package com.rhy.datastructuresandalgorithms.tree;

import jdk.nashorn.internal.ir.BinaryNode;
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



    public void show(BinarySearchTreeNode root) {
        if (root == null) {
            System.out.println("EMPTY!");
            return ;
        }
        // 得到树的深度
        int treeDepth = getTreeDepth(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        writeArray(root, 0, arrayWidth / 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }
    // 用于获得树的层数
    public int getTreeDepth(BinarySearchTreeNode root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.getLeft()), getTreeDepth(root.getRight())));
    }

    private void writeArray(BinarySearchTreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null)
            return;
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.getData());

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth)
            return;
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.getLeft() != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.getLeft(), rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.getRight() != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.getRight(), rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
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
        binarySearchTree.show(binarySearchTree.root);
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
