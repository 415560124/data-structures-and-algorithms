package com.rhy.datastructuresandalgorithms.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: Herion Lemon
 * @date: 2021/9/25 14:14
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 解救妹子
 */
public class SaveTheBeauty {
    /**
     * 图的行
     */
    private int m;
    /**
     * 图的列
     */
    private int n;
    /**
     * 邻接矩阵实现图
     */
    private int[][] graph;
    /**
     * 已走过的路
     */
    private boolean[][] done;
    /**
     * 起始点
     */
    private Point start;
    /**
     * 终点
     */
    private Point end;
    /**
     * 可前进的下个点集合
     */
    Point[] nexts = { new Point(0,-1),new Point(1,0),new Point(0,1),new Point(-1,0) };

    public SaveTheBeauty(int m, int n, Point start,Point end) {
        this.m = m;
        this.n = n;
        this.start = start;
        this.end = end;
        graph = new int[m][n];
        done = new boolean[m][n];
        //加载不能走的地方
        dontGoWay();
    }

    /**
     * 不能走的地方
     */
    public void dontGoWay(){
        graph[0][2] = 1;
        graph[2][2] = 1;
        graph[3][1] = 1;
    }
    /**
     * 广度优先遍历
     * @return
     */
    public boolean bfs(){
        //重置
        done = new boolean[m][n];
        //起始点为已经走过
        done[start.x][start.y] = true;
        //队列容量 = 当前所有点 - 不能走的点
        Queue<Point> queue = new ArrayDeque<>(m*n-3);
        queue.add(new Point(start.x,start.y));
        //队列都弹出完毕则代表没有点可以走了
        while (!queue.isEmpty()){
            Point curPoint = queue.poll();
            //遍历下一个点判断是否到达妹子的位置
            for (Point next: nexts) {
                int nextx = curPoint.x + next.x;
                int nexty = curPoint.y + next.y;
                //判断当前点是否为有效点
                if(nextx < 0 || nextx >= m || nexty < 0 || nexty >= n){
                    continue;
                }
                //检查当前点是否为妹子的位置
                if(end.x == nextx && end.y == nexty){
                    return true;
                }
                //下一个点非能走的点 || 检查当前点是否已经走过
                if (graph[nextx][nextx] == 1 || done[nextx][nexty]){
                    continue;
                }
                done[nextx][nexty] = true;
                queue.add(new Point(nextx,nexty));
            }
        }
        return false;
    }

    /**
     * 最小步数
     */
//    private int minStep;
//    public int dfs(){
//        //重置
//        done = new boolean[m][n];
//
//        minStep = Integer.MAX_VALUE;
//        dfs(start,0);
//        return minStep;
//    }
//
//    private void dfs(Point curPoint, int curStep) {
//        done[curPoint.x][curPoint.y] = true;
//        if(curPoint.x == end.x && curPoint.y == end.y){
//            if(minStep > curStep){
//                minStep = curStep;
//            }
//            return;
//        }
//        //遍历下一个点判断是否到达妹子的位置
//        for (Point next: nexts) {
//            int nextx = curPoint.x + next.x;
//            int nexty = curPoint.y + next.y;
//            //判断当前点是否为有效点
//            if(nextx < 0 || nextx >= m || nexty < 0 || nexty >= n){
//                continue;
//            }
//            //能否走到下一个位置
//            if (graph[nextx][nextx] == 1 || done[nextx][nexty]){
//                continue;
//            }
//            dfs(new Point(nextx,nexty),curStep + 1);
//            done[nextx][nexty] = false;
//        }
//    }

    public void printTable(){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SaveTheBeauty saveTheBeauty = new SaveTheBeauty(5,4,new Point(0,0),new Point(2,3));
        saveTheBeauty.printTable();
        System.out.println(saveTheBeauty.bfs());


//        System.out.println(saveTheBeauty.dfs());
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
