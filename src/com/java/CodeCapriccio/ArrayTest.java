package com.java.CodeCapriccio;

public class ArrayTest {
    int nums [];
    int target;

    public static void main(String[] args) {
        ArrayTest arraytest = new ArrayTest();
        arraytest.nums = new int[]{1, 2, 5, 8};
        arraytest.target = 5;
        System.out.println(arraytest.BinarySearch(arraytest.nums, arraytest.target));


    }










    /*     []闭区间 BinarySearch 二分查找
    给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
            输入: nums = [-1,0,3,5,9,12], target = 9
            输出: 4
            解释: 9 出现在 nums 中并且下标为 4
    思路：对于有序数组，将区间分为左右闭区间，取中间值middle，比较target与middle大小，缩小定位范围，在新区间内继续上述操作，直至找到目标值

    public class CcMain {
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




