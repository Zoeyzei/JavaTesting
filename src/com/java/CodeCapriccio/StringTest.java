package com.java.CodeCapriccio;



public class StringTest {
    int n;
    String s;

    public static void main(String[] args) {
        StringTest stringtest = new StringTest();
        stringtest.s = "example";
        stringtest.n = 2;
        System.out.println(stringtest.reverseLeftWords(stringtest.s,stringtest.n));
    }



/***************************  左旋转字符串   *************************
 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 示例 1：
 输入: s = "abcdefg", k = 2
 输出: "cdefgab"
 示例 2：
 输入: s = "lrloseumgh", k = 6
 输出: "umghlrlose"
思路：新建一个字符串，将两个区间的字符串复制到新空间
 思路2：不申请额外空间，采取两个区间字符串反转

*/
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        char[] temp = s.toCharArray();

        for (int i=n;i<s.length();i++){
            res.append(temp[i]);
        }
        for (int i=0;i<n;i++){
            res.append(temp[i]);
        }
        return res.toString();
    }


/*****************************  反转字符串中的单词   ***************************
 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。

 示例 1：
 输入：s = "the sky is blue"
 输出："blue is sky the"
 示例 2：
 输入：s = "  hello world  "
 输出："world hello"
 解释：反转后的字符串中不能存在前导空格和尾随空格。
 示例 3：
 输入：s = "a good   example"
 输出："example good a"
 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。

 思路：
 1、新建StringBuilder对象res，判断空格时需要将string字符串转换为char[]数组
 2、双指针从后往前，遇到空格左右指针一起左移，遇到单词仅左指针往左移位直到前一位元素是空格，定位一个单词，将单词复制到StringBuilder对象res
 3、终止条件：i=l，l为去掉字符串首端空格的位置

 stringtest.s = "  a good  example  ";
 */
public String reverseWords(String s) {
    StringBuilder res = new StringBuilder();
    int i=s.length()-1,j=s.length()-1,l=0;
    char[] temp = s.toCharArray();

    System.out.println("i="+i+" j="+j);
    while (temp[l]==' '){   //从后往前遍历，去除字符串首端空格
        l++;
    }
    if (i==l){      //当只有一个有效字符，"  a"
        res.append(temp[i]);
    }
    while (i>l){
        while (temp[i]==' '){   //跳过连续空格
            i--;
            j--;
        }
        if (i>l){       //左指针跳过该单词定位到单词左侧空格
            i--;
        }
        System.out.println("i="+i+" j="+j);
        if (temp[i]==' '){         //定位单词两端，将该单词复制到新字符串并加上空格
            for (int k=i+1;k<=j;k++){
                System.out.println(temp[k]);
                res.append(temp[k]);
            }
            res.append(' ');
            j=i;
        } else if (i==l) {      //当左指针已经移动到字符串第一个元素，将第一个单词输出
            for (int k=i;k<=j;k++){
                System.out.println(temp[k]);
                res.append(temp[k]);
            }
        }
    }
    return res.toString();
}





/******************************  替换空格   ***************************
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
示例 1：
输入：s = "We are happy."
输出："We%20are%20happy."

 思路：String类为不可变类型，需先创建StringBuilder对象，判断空格时需要将string字符串转换为char[]数组，对char元素进行比较
        常规思路：新建StringBuilder对象，从前往后遍历s，对空格进行替换后复制到news
        优化：为了减少元素移动次数，从后往前进行遍历，双指针法，左指针将非空格元素往后移
             注意首先需要扩充数组到每个空格替换成"%20"之后的大小
*/
    public String replaceSpace(String s) {
        StringBuilder news = new StringBuilder();   //创建可变字符串类StringBuilder对象
        char[] temp = s.toCharArray();      //判断空格时需要将string字符串转换为char[]数组，对char元素进行比较
        int i=0;
        for (i=0;i<s.length();i++){
            if (temp[i]==' '){
                news.append("%20");     //调用StringBuilder类函数
            }
            else {
                news.append(temp[i]);
            }
        }
        return news.toString();     //转换为String类型返回

    }


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
 双指针法，判断[2nk, i+k-1]是否越界length-1，若为有效区间则开始反转，若右指针越界则将右指针移至字符串尾，若左指针越界则结束
 注意char[]数组与String字符串的转换
 f(2nk) <-> f(i+k-1)

 StringTest stringtest = new StringTest();
 stringtest.s = "hello";
 stringtest.k = 2;
 stringtest.reverseStr(stringtest.s,stringtest.k);
 */
    public String reverseStr(String s, int k) {
        int i=0,j=0;
        char[] temp = s.toCharArray();
        while (i<s.length()){
            j=(i+k-1<s.length())?(i+k-1):(s.length()-1);    //判断右边界是否越界，若越界则赋值length-1
            reverseString1(temp,i,j);   //反转[i,j]
            i+=2*k;
        }
        System.out.println(String.copyValueOf(temp));
        return String.copyValueOf(temp);
    }

    //创建字符串反转函数，将char数组中的[i,j]区间反转
    public void reverseString1(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }



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
