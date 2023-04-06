package com.java.CodeCapriccio;

import java.util.*;

public class BackTracking {
    int n,k;
    public static void main(String[] args) {
        BackTracking backTracking = new BackTracking();
        backTracking.n = 4;
        backTracking.k = 2;
        backTracking.combine(backTracking.n, backTracking.k);
    }

/***************************    组合      *************************
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
你可以按 任何顺序 返回答案。
 示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]

 回溯：
 终止条件：
*/
    public List<List<Integer>> combine(int n, int k) {
//        二维数组res存储最终答案，栈path存储每个组合
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();

        if (k <= 0 || k < n) {
            return res;
        }
        dfs(n,k,1,path,res);
        System.out.println("res为：" + Arrays.toString(res.get(1).toArray()));
        return res;
    }

    private void dfs(int n, int k, int start, Deque<Integer>path, List<List<Integer>> res){
//        终止条件，当前path满足题目组合要求
        if (path.size()==k){
            res.add(new ArrayList<>(path));
            System.out.println("res为：" + Arrays.toString(res.get(1).toArray()));
            return;
        }
//        for循环，对每个集合进行操作
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.push(i);       //处理节点，添加节点值
            System.out.println(path);
            dfs(n,k,i+1,path,res);      //递归
            path.pop();     //回溯
        }
    }






}
