package com.java.CodeCapriccio;

//import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DualpointerTest {
    int i=0;
    int[] nums;

    public static void main(String[] args) {
        DualpointerTest dptest = new DualpointerTest();
        dptest.i = 2;
        dptest.nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(dptest.threeSum(dptest.nums));
    }




/******************************* 三数之和   ******************************
 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 注意：答案中不可以包含重复的三元组。
     示例 1：
     输入：nums = [-1,0,1,2,-1,-4]
     输出：[[-1,-1,2],[-1,0,1]]
     注意，输出的顺序和三元组的顺序并不重要。
     示例 2：
     输入：nums = [0,1,1]
     输出：[]
     示例 3：
     输入：nums = [0,0,0]

*/
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> temp = new ArrayList();
        int i,j,k,sum;
        int n = nums.length;
        Arrays.stream(nums).sorted();
        for (i=0;i<n;i++){
            if (nums[i]>0){
                break;
            }
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            j = i+1;
            k = n-1;
            sum = nums[i] + nums[j] + nums[k];
            if (sum<0){
                j++;
            }
            else if (sum>0){
                k--;
            }
            else {
                temp.add(Arrays.asList(nums[i],nums[j],nums[k]));
                j++;
                k--;
                while (j<k && nums[j]==nums[j-1]){j++;};
                while (j<k && nums[k]==nums[k+1]){k--;};
            }
        }
        return temp;
    }








/********************************   移除元素    *******************************
     给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

     示例 2：
     输入：nums = [0,1,2,2,3,0,4,2], val = 2
     输出：5, nums = [0,1,4,0,3]
     解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。

    思路：双指针，在原数组上移除元素，不开辟新空间
*/
    public int removeElement(int[] nums, int val) {
        int i=0,j=0;
        while (i<nums.length){
            if (nums[i]!=val){
                nums[j]=nums[i];
                i++;
                j++;
            }
            else {
                i++;
            }
        }
        return j;
    }







}
