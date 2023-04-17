package com.java.CodeCapriccio;

import java.util.HashMap;

public class DpTest {
    int n;
    int[] nums;

    public static void main(String[] args) {
        DpTest dp = new DpTest();
        dp.n = 3;
        dp.nums = new int[]{1,17,5,10,13,15,10,5,16,8};
        System.out.println(dp.climbStairs(dp.n));

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
