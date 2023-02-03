package com.java.CodeCapriccio;

import java.util.Arrays;

public class ArrayTest {
    int nums [];
    int val;

    public static void main(String[] args) {
        ArrayTest arraytest = new ArrayTest();
        arraytest.nums = new int[]{1, 2, 5, 8};
        arraytest.val = 5;
        System.out.println(arraytest.removeElement1(arraytest.nums, arraytest.val));
    }


/*
    给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。



    示例 1：

    输入：nums = [-4,-1,0,3,10]
    输出：[0,1,9,16,100]
    解释：平方后，数组变为 [16,1,0,9,100]
    排序后，数组变为 [0,1,9,16,100]
    示例 2：

    输入：nums = [-7,-3,2,3,11]
    输出：[4,9,9,49,121]
*/



/*  ****************************移除元素***********************************
给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

示例 1：
输入：nums = [3,2,2,3], val = 3
输出：2, nums = [2,2]
解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
示例 2：
输入：nums = [0,1,2,2,3,0,4,2], val = 2
输出：5, nums = [0,1,4,0,3]
解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。

思路1（元素交换位置，减少元素移动次数）：设置左右指针，左指针指向需处理的元素，从左至右依次移位，右指针指向数组最后一个元素；
因为元素顺序可以改变，若当前元素=val，则将最后一个元素赋值给当前元素，即将右指针指向的元素复制到左指针，并将右指针左移一位;若当前元素!=val，左指针右移
    eg:nums = [1,2,3,4,5],val=1,第一个元素处理后序列变为[5,2,3,4]


public class ArrayTest {
    int nums [];
    int val;

    public static void main(String[] args) {
        com.java.CodeCapriccio.ArrayTest arraytest = new com.java.CodeCapriccio.ArrayTest();
        arraytest.nums = new int[]{1, 2, 5, 8};
        arraytest.val = 5;
        System.out.println(arraytest.removeElement(arraytest.nums, arraytest.val));
    }
*/
    public int removeElement(int[] nums, int val) {
        int i=0, j=nums.length-1;
        while (i<=j){     //取等号即处理到最后一个元素
            if (nums[i] == val){
                nums[i] = nums[j];
                j--;
            }
            else {
                i++;
            }
            System.out.println(i);
            System.out.println(j);
            System.out.println(Arrays.toString(nums));
        }
        return j+1;//返回最终数列的长度
    }





/*  ****************************移除元素***********************************
    思路2（快慢双指针法）：左指针指向需处理的元素，从左至右依次移位，右指针指向新数组需赋值的位置。
    若左指针当前元素!=val，则将当前元素复制给右指针，左右指针右移一位;若当前元素=val，左指针右移一位
*/
public int removeElement1(int[] nums, int val) {
    int i=0, j=0;
    while (i<=nums.length-1){
        if (nums[i] != val){
            nums[j] = nums[i];
            i++;
            j++;
        }
        else {
            i++;
        }
        System.out.println(i);
        System.out.println(j);
        System.out.println(Arrays.toString(nums));
    }
    return j;//返回最终数列的长度
}





    /*********************** []闭区间 BinarySearch 二分查找    **************************
    给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
            输入: nums = [-1,0,3,5,9,12], target = 9
            输出: 4
            解释: 9 出现在 nums 中并且下标为 4
    思路：对于有序数组，将区间分为左右闭区间，取中间值middle，比较target与middle大小，缩小定位范围，在新区间内继续上述操作，直至找到目标值

    public class ArrayTest {
        int nums [];
        int target;

        public static void main(String[] args) {
            CcMain arraytest = new CcMain();
            arraytest.nums = new int[]{1, 2, 5, 8};
            arraytest.target = 5;
            System.out.println(arraytest.BinarySearch(arraytest.nums, arraytest.target));
    */
    public int BinarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else{
                left = middle + 1;
            }
        }
        return -1;
    }

}




