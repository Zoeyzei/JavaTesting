package com.java.CodeCapriccio;

import java.util.HashMap;
import java.util.List;

public class DpTest {
    int m,n;
    int[] nums;

    public static void main(String[] args) {
        DpTest dp = new DpTest();
        dp.m = 10;
        dp.n = 10;
        dp.nums = new int[]{1,17,5,10,13,15,10,5,16,8};
        System.out.println(dp.uniquePaths(dp.m,dp.n));

    }



/***************************     杨辉三角     *************************
    给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
    在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     输入: numRows = 5
     输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 思路: 动态规划;对于坐标[i,j]表示第i行第j个数,dp[i,j] = dp[i-1,j-1] + dp[i-1,j]
*/
//    public List<List<Integer>> generate(int numRows) {
//
//    }





/**************************     不同路径     *************************
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
    问总共有多少条不同的路径？
     输入：m = 3, n = 7
     输出：28
 思路: m x n 网格从左上角到右下角位置,需要下移 m-1 ,右移 n-1 ,相当于在 m+n-2 个位置穿插 n-1 个右移动作,可以连续右移,故一共可能情况 = C(m+n-2,n-1)
 注:C(m,n)表示在 m 个位置中选 n 个的可能选法
*/
    public int uniquePaths(int m, int n) {
        if (m == 1){
            return 1;
        }
        else if (n == 1){
            return 1;
        }
        // 一共可能情况 = C(m+n-2,n-1)
        else {
            return (int) (pathC(m+n-2)/pathC(n-1)/pathC(m-1));
        }
    }
    // 阶乘
    private static long pathC(int m){
        long res=1;
        for (int i = 1; i <= m; i++) {
            res = res * i;
        }
        System.out.println(res);
        return res;
    }





/**************************     爬楼梯     *************************
    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？[1 <= n <= 45]
     输入：n = 3
     输出：3
     解释：有三种方法可以爬到楼顶。
     1. 1 阶 + 1 阶 + 1 阶
     2. 1 阶 + 2 阶
     3. 2 阶 + 1 阶
思路: f(n) = f(n-1) + f(n-2)
 直接递归return climbStairs(n-1) + climbStairs(n-2)超时;哈希表超时;
 迭代法: 使用3个int变量m,k,l 循环存储climbStairs(n-1),climbStairs(n-2),climbStairs(n)
 */
    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int m=0,k=1,l=2;
        for (int i = 3; i <= n; i++) {
            m = k;
            k = l;
            l = m + k;
        }
        return l;
    }






/*************************     斐波那契数列    ************************
     F(0) = 0，F(1) = 1
     F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 */
    public int fib(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

}
