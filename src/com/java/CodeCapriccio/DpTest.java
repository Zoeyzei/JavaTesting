package com.java.CodeCapriccio;

import java.lang.reflect.WildcardType;
import java.util.*;

public class DpTest {
    int m,n;
    int[] nums,value;
    String s;

    public static void main(String[] args) {
        DpTest dp = new DpTest();
        dp.m = 4;
        dp.n = 2;
        dp.nums = new int[]{1,3,4};
        dp.value = new int[]{15,20,30};
        dp.s = "bab";
        System.out.println(dp.bagProblem01(dp.nums,dp.value,dp.m));

    }


/******************************     完全背包     *************************
有N件物品和一个最多能背重量为W的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。
每件物品都有无限个（也就是可以放入背包多次），求解将哪些物品装入背包里物品价值总和最大。
           重量	价值
     物品0	1	15
     物品1	3	20
     物品2	4	30
 递推公式:从下标为[0-i]的物品里任意取无数个,放入容量为 j 的背包,有放不放得下第 i 件物品两种情况,最终能获得的最大价值为 dp[i][j] = max{dp[i-1][j], dp[i-1][j-weight[i]]+value[i]}
 初始条件: 根据示例数据,dp[][0]=0, dp[0][j>=1]=15
 遍历顺序: i++ j++ 或者 j++ i++
*/







/*****************************     01 背包     *************************
有n件物品和一个最多能背重量为w 的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。
每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
           重量 	价值
     物品0	1	15
     物品1	3	20
     物品2	4	30
 思路:动态规划;
 递推公式:从下标为[0-i]的物品里任意取,放入容量为 j 的背包,有放不放得下第 i 件物品两种情况,最终能获得的最大价值为 dp[i][j] = max{dp[i-1][j], dp[i-1][j-weight[i]]+value[i]}
 初始条件: 根据示例数据,dp[][0]=0, dp[0][j>=1]=15
 遍历顺序: i++ j++ 或者 j++ i++
*/
    public int bagProblem01(int[] weight, int[] value, int bagSize) {
        int[][] dp = new int[weight.length][bagSize+1];
        if (bagSize==0){
            return 0;
        }
        // 初始化
        for (int i = weight[0]; i <= bagSize; i++) {
            dp[0][i] = value[0];
        }
        // 先遍历物品再遍历背包容量
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                // 若j < weight[i],肯定放不下物品i
                if (j < weight[i]){
                    dp[i][j] = dp[i-1][j];
                }
                // 若j >= weight[i],有放不放得下第 i 件物品两种情况,取max
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
                }
            }
        }
        return dp[weight.length-1][bagSize];
    }




/*****************************     打家劫舍     *************************
    如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
    给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     输入：[2,7,9,3,1]
     输出：12
     解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 思路: 动态规划, 在 i 个屋子里偷窃,有第i个房子偷不偷两种情况, 所得最大总金额为 dp[i] = max{dp[i-2]+nums[i], dp[i-1]}
*/
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length==1){
            return nums[0];
        }
        else if (nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }





/****************************     最长回文子串     *************************
    输入：s = "babad"
    输出："bab"
    解释："aba" 同样是符合题意的答案。
 思路1: i i+1...j-1 j; 若s[i+1,j-1]是回文子串,s[i]=s[j],那么s[i,j]也是回文串.由于由s[i+1,j-1] && s[i]=s[j]→s[i,j],故双层循环顺序为i-- j++
 思路2:中心扩散法,遍历选取中心点 i,每个中心点向左右两侧扩散,得到最长回文串f(i),取max
*/
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];   //dp[][]
        String res="";
        // 由s[i+1,j-1]→s[i,j],故双层循环顺序为i-- j++
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                // j-i<2时符合回文串定义
                if (s.charAt(i)==s.charAt(j) && (j-i<2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    // 取最长子串
                    res = res.length() >= j-i+1 ? res : s.substring(i,j+1);
                }
                else {
                    dp[i][j] = false;
                }
            }

        }
        return res;
    }






/***************************     杨辉三角     *************************
    给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
    在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     输入: numRows = 5
     输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 思路: 动态规划;对于坐标[i,j]表示第i行第j个数(非首末): dp[i,j] = dp[i-1,j-1] + dp[i-1,j]
*/
    public List<List<Integer>> generate(int numRows) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();

        if (numRows == 1){
            return Arrays.asList(Arrays.asList(1));
        }
        else if (numRows == 2){
            return Arrays.asList(Arrays.asList(1),Arrays.asList(1, 1));
        }
        // 行数>=3时,逐行进行计算,对于第i行非首末的数: dp[i,j] = dp[i-1,j-1] + dp[i-1,j]
        res.add(Arrays.asList(1));
        res.add(Arrays.asList(1, 1));;
        stack.push(1);
        for (int i = 2; i < numRows; i++) {
            stack.clear();
            stack.addLast(1);
            int index=1;
            while (index<i){
                stack.addLast((res.get(i-1)).get(index-1) + (res.get(i-1)).get(index));
                index++;
            }
            stack.addLast(1);
            res.add(new ArrayList<>(stack));
        }
        return res;
    }





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
