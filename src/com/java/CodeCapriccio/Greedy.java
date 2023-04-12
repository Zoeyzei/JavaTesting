package com.java.CodeCapriccio;

import java.util.Arrays;

public class Greedy {
    int[] g,s,prices;
    public static void main(String[] args) {
        Greedy greedy = new Greedy();
        greedy.g = new int[]{1,2};
        greedy.s = new int[]{1,2,3};
        greedy.prices = new int[]{7,1,5,3,6,4};
        System.out.println(greedy.maxProfit(greedy.prices));

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
