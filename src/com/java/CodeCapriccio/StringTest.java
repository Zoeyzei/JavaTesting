package com.java.CodeCapriccio;

import sun.security.util.Length;

public class StringTest {
    int k;
    String s;

    public static void main(String[] args) {
        StringTest stringtest = new StringTest();
        stringtest.s = "hello";
        stringtest.k = 3;
        stringtest.reverseStr(stringtest.s,stringtest.k);
    }

    public String reverseStr(String s, int k) {
        int i=0,j=0,n=0;
        char[] tempchar=s.toCharArray();
        String news = s;
        while (i<s.length()){
            j=(i+k-1<s.length())?(i+k-1):s.length();    //判断右边界是否越界，若越界则赋值length
            System.out.println(i);
            System.out.println(j);
            System.out.println(s.substring(i,j));
            news = s.substring(i,j+1);
//            反转函数
            i+=2*k;

        }
        return news;
    }

/*
    public void reverseString1{

    }
*/

/******************************  反转字符串II   ***************************
给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
示例 1：
输入：s = "abcdefg", k = 2
输出："bacdfeg"
示例 2：
输入：s = "abcd", k = 2
输出："bacd"

思路：
 双指针法，判断[2nk, 3nk-1]是否越界，若为有效区间则开始反转，若右指针越界则将右指针移至字符串尾，若左指针越界则结束
 f(2nk) <-> f(3nk-1)
*/



/*******************************  反转字符串   ***************************
    编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
    不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     示例 1：
     输入：s = ["h","e","l","l","o"]
     输出：["o","l","l","e","h"]
     示例 2：
     输入：s = ["H","a","n","n","a","h"]
     输出：["h","a","n","n","a","H"]
 思路：双指针法，首尾指针交换位置

     char[] s;
     public static void main(String[] args) {
     StringTest stringtest = new StringTest();
     stringtest.s = new char[]{'h','e','l','l','o'};
     stringtest.reverseString(stringtest.s);

 */
public void reverseString(char[] s) {
    int i=0,j=s.length-1;
    while (i<=j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        i++;
        j--;
    }
    System.out.println(s);
}



}
