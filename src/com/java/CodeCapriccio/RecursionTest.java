package com.java.CodeCapriccio;


public class RecursionTest {
    int n;

    public static void main(String[] args) {
        RecursionTest recursion = new RecursionTest();
        recursion.n = 7;
        System.out.println(recursion.numWays(recursion.n));
    }

/********************************   青蛙跳台阶问题    ************************************
    一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
    答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
    示例 1：
    输入：n = 2
    输出：2
    示例 2：
    输入：n = 7
    输出：21
    示例 3：
    输入：n = 0
    输出：1
思路：f(n) = f(n-1) + f(n-2)
    终止条件：f(1)=1;f(2)=2
*/
public int numWays(int n){
    if (n==0) {
        return 1;
    }
    if (n==1){
        return 1;
    }
    return numWays(n-1)+numWays(n-2);
}


/*********************************   斐波那契数列    *************************************
 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 F(0) = 0,   F(1) = 1
 F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 1、1、2、3、5、8、13、21、34

 思路：递推公式题目已给出，终止条件n=0/1
*/
    public int fib(int n){
        if (n==0){
            return 1;
        }
        if (n==1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }



/************************************   N的阶层    *******************************************
    输入 n ，输出 n!

    思路：f(n) = n! = n*f(n-1)
         终止条件：n=1时，f(n) = 1
*/
    public int stratum(int n){
        if (n==1){
            return 1;
        }
        return n*stratum(n-1);
    }








}
