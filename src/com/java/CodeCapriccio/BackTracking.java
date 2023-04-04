package com.java.CodeCapriccio;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BackTracking {
    public static void main(String[] args) {
        BackTracking backTracking = new BackTracking();

    }

/***************************    组合      *************************
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
你可以按 任何顺序 返回答案。
 示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]

 回溯：
 终止条件：
*/
    public List<List<Integer>> combine(int n, int k) {
        int start=1;
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();

        if (k <= 0 || k <= n) {
            return res;
        }
        dfs(n,k,start,path,res);
        return res;
    }

    private void dfs(int n, int k, int start, Deque<Integer>path, List<List<Integer>> res){
        if (path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < n; i++) {
            path.push(i);
            dfs(n,k,i+1,path,res);
            path.pop();
        }
    }






}
