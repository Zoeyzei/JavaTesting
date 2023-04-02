package com.java.CodeCapriccio;

import javax.swing.text.html.parser.Entity;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HashTest {
    int i;
    int[]nums;
    String s,t;


    public static void main(String[] args) {
        HashTest hashTest = new HashTest();
        hashTest.i = 9;
        hashTest.nums = new int[]{2,7,11,15};
        hashTest.s = "anagram";
        hashTest.t = "nagaram";
        System.out.println(hashTest.isAnagram(hashTest.s, hashTest.t));
    }


/*****************************  有效的字母异位词    ****************************
 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 示例 1:
 输入: s = "anagram", t = "nagaram"
 输出: true
 示例 2:
 输入: s = "rat", t = "car"
 输出: false

 思路：hashmap
 [key,value] = [字母，字母出现次数]
*/
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> sites = new HashMap<>();
        for (int i=0;i<s.length();i++) {
//            遍历s，将当前元素出现次数存入map，首次出现put值为1
            if (sites.containsKey(s.charAt(i))) {
                sites.put(s.charAt(i), sites.get(s.charAt(i)) + 1);
            } else if (!sites.containsKey(s.charAt(i))) {
                sites.put(s.charAt(i), 1);
            }
        }
//            遍历t，将map中对应字母value值-1，如果不存在该字母，则不符合原题设定，返回false
        for (int i=0;i<t.length();i++) {
            if (sites.containsKey(t.charAt(i))) {
                sites.put(t.charAt(i), sites.get(t.charAt(i)) - 1);
            } else if (!sites.containsKey(t.charAt(i))) {
                return false;
            }
        }
//        map中值全为0时表示有效的字母异位词
        for (int val : sites.values()){
            if (val!=0){
                return false;
            }
        }
        return true;
    }


/*****************************  两数之和    ****************************
    给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    你可以按任意顺序返回答案。

    输入：nums = [2,7,11,15], target = 9
    输出：[0,1]
    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

    思路：哈希表，hashmap, key=nums[i], value=i
    遍历当前数组，寻找哈希表中是否存在相应的value满足nums[value]=target-nums[i]，如果存在则返回[i,value]
*/

    public int[] twoSum(int[] nums, int target) {
        int[]res = new int[2];
        HashMap<Integer,Integer> sites = new HashMap<>();
        for (int i=0;i<nums.length;i++){
//      遍历当前数组，寻找哈希表中是否存在相应的value满足nums[value]=target-nums[i]，如果存在则返回[i,value]
            if (sites.containsKey(target-nums[i])){
                res[0] = i;
                res[1] = sites.get(target-nums[i]);
            }
            else {
//          若未找到匹配值，则将当前键值对存入hashmap
                sites.put(nums[i],i);
            }
        }
        System.out.println(Arrays.toString(res));
        return res;
    }









}
