package com.java.CodeCapriccio;

import java.util.Arrays;

public class Greedy {
    int[] g,s,prices;
    public static void main(String[] args) {
        Greedy greedy = new Greedy();
        greedy.g = new int[]{2,3,1,1,4};
        greedy.s = new int[]{1,6,10,8,7,3,2};
        greedy.prices = new int[]{7,1,5,3,6,4};
        System.out.println(greedy.candy(greedy.s));

    }



/****************************   分发糖果    ***************************
n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
每个孩子至少分配到 1 个糖果。
相邻两个孩子评分更高的孩子会获得更多的糖果。
请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
     输入：ratings = [1,2,2]
     输出：4
     解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 思路：
 输入：[1, 6, 10, 8, 7, 3, 2]
 输出：[1, 2,  5 , 4, 3, 2, 1]
 正序遍历ratings,若递增,则nums[i+1] = nums[i] + 1,否则置1;递减情况通过倒序循环解决,在正序遍历基础上倒序,若倒序递增但不满足题意则nums[i-1] = nums[i] + 1
*/
    public int candy(int[] ratings) {
        int sum = 0;
        int[] nums = new int[ratings.length];
        if (ratings.length == 1){
            return 1;
        }
        nums[0] = 1;
//        System.out.println(Arrays.toString(ratings));
        for (int i = 0; i < ratings.length - 1; i++) {
            //正序遍历ratings,若递增,则nums[i+1] = nums[i] + 1,否则置1
            if (ratings[i+1] > ratings[i]){
                nums[i+1] = nums[i] + 1;
            }
            else {
                nums[i+1] = 1;
            }
        }
//        System.out.println(Arrays.toString(nums));
        sum = nums[ratings.length-1];
        for (int i = ratings.length - 1; i > 0; i--) {
            //递减情况通过倒序循环解决,在正序遍历基础上倒序,若倒序递增但不满足题意则nums[i-1] = nums[i] + 1
            if (ratings[i-1] > ratings[i] && nums[i-1] <= nums[i]){
                nums[i-1] = nums[i] + 1;
            }
            sum += nums[i-1];
        }
//        System.out.println(Arrays.toString(nums));
        return sum;
    }





/****************************   跳跃游戏    ***************************
给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个下标。
     输入：nums = [2,3,1,1,4]
     输出：true
     解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     输入：nums = [3,2,1,0,4]
     输出：false
     解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。

 思路：指针i每次跳一步，定义一个len为目前所能跳跃到的最大长度，根据i每次更新len，若len<i说明无法到达i指标，循环结束，
 若len>=nums.length或者i>=nums.length，说明可以到达终点
*/
    public boolean canJump(int[] nums) {
//      定义一个len为目前所能跳跃到的最大长度
        int len=0;
        //指针i每次跳一步，根据i每次更新len
        for (int i = 0; i < nums.length; i++) {
//          若len<i说明无法到达i指标，循环结束
            if (len<i){
                return false;
            }
            len = Math.max(len,i+nums[i]);
//          若len>=nums.length或者i>=nums.length，说明可以到达终点，这里提前结束循环
            if (len >= nums.length){
                return true;
            }
        }
        return true;
    }








/***************************    买卖股票的最佳时机 II    **************************
 prices[i] 表示某支股票第 i 天的价格。
 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 返回你能获得的最大利润 。
     输入：prices = [7,1,5,3,6,4]
     输出：7
     解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
     总利润为 4 + 3 = 7 。
思路：贪心，若今天买入明天卖出能获利，则今天买入
*/
    public int maxProfit(int[] prices) {
        int fit = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i]<prices[i+1]){
                fit += prices[i+1] - prices[i];
            }
        }
        return fit;
    }





    /************************** 发饼干 ***************************
对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。
如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 输入: g = [1,2], s = [1,2,3]
 输出: 2

 思路：排序，分给胃口最小的孩子能满足的最小的饼干，依次处理胃口较大的孩子
*/
    public int findContentChildren(int[] g, int[] s) {
        int count=0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0,j = 0; i < g.length && j < s.length; i++) {
            while (g[i] > s[j] && j < s.length-1){
                j++;
            }
            if (g[i] <= s[j] && j < s.length){
                count++;
                j++;
            }
        }
        return count;
    }

}
