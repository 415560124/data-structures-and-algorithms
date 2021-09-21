package com.rhy.datastructuresandalgorithms.graph;

import java.util.*;

/**
 * @author: Herion Lemon
 * @date: 2021/9/21 19:51
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 图结构
 */
public class GraphMap {
    private Map<String, Set<String>> data = new HashMap<>();
    private String root;
    private Queue<String> queue = new ArrayDeque<>();

    public GraphMap(String root) {
        this.root = root;
        addPoint(root);
    }

    /**
     * 添加点
     * @param point
     * @return
     */
    public boolean addPoint(String point){
        data.put(point,new HashSet<>());
        return true;
    }

    /**
     * 添加边线
     * @param point
     * @param linePoint
     * @return
     */
    public boolean addLine(String point,String linePoint){
        Set<String> strings = data.get(point);
        if(strings == null){
            return false;
        }
        return strings.add(linePoint);
    }

    /**
     * 广度优先遍历
     */
    public void bfs(){
        //存储已经走过的点
        Set<String> donePoint = new HashSet<>();
        queue.add(root);
        //每加入一个新点都存入以上集合
        donePoint.add(root);
        while (queue.size() != 0){
            //取出第一个
            String poll = queue.poll();
            //输出
            System.out.print(poll+"\t");
            //找到此节点连接的点，加入队列中
            Set<String> strings = data.get(poll);
            queue.addAll(strings);
            //每加入一个新点都存入以上集合
            donePoint.addAll(strings);
        }
    }

    /**
     * 深度优先遍历
     */
    public void dfs(){
        dfs(root);
    }
    public void dfs(String point){
        System.out.print(point+"\t");
        //如果存在连接的点则开始递归
        Set<String> strings = data.get(point);
        if(strings != null && strings.size() != 0){
            strings.forEach((str)->{
                dfs(str);
            });
        }
    }

    public static void main(String[] args) {
        GraphMap graphMap = new GraphMap("A");
        graphMap.addPoint("B");
        graphMap.addLine("A","B");
        graphMap.addPoint("C");
        graphMap.addLine("B","C");
        graphMap.addPoint("D");
        graphMap.addLine("B","D");
        graphMap.addPoint("E");
        graphMap.addPoint("F");
        graphMap.addLine("D","E");
        graphMap.addLine("D","F");
        graphMap.bfs();
        System.out.println();
        graphMap.dfs();
    }
}
