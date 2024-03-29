package com.java.CodeCapriccio;



import java.util.*;

public class StackTest {
    Deque<Character> stackin;
    Deque<Integer> stackout;
    String s;

    public static void main(String[] args) {
        StackTest stacktest = new StackTest();

//        stacktest.stackin = new Stack<>();
        stacktest.s = "([])";
        System.out.println(stacktest.isValid1(stacktest.s));
//        stringtest.strStr(stringtest.s1,stringtest.s2);
    }


/*********************************   有效的括号   ********************************
     给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     有效字符串需满足：
     左括号必须用相同类型的右括号闭合。
     左括号必须以正确的顺序闭合。
     每个右括号都有一个对应的相同类型的左括号。

     示例 1：
     输入：s = "()"
     输出：true
     示例 2：
     输入：s = "()[]{}"
     输出：true
     示例 3：
     输入：s = "(]"
     输出：false

     思路：栈，无效括号分为三种情况（左括号多余 ((([{}]))()，右括号多余 ({})[[]]}，左右括号数目一样但是不匹配 [[{}]](}）
        将元素依次进栈，比较栈顶元素与当前元素是否匹配，遇到对应的括号出栈
        若匹配失败即左右括号数目一样但是不匹配，若字符遍历完毕最终栈不为空则左括号多余，若栈为空字符未遍历完毕则右括号多余
        匹配方法1：左括号入栈时直接用对应右括号
        匹配方法2：哈希表构建左右括号对应关系：key对应左括号，value对应右括号

     */
    public boolean isValid(String s) {
        stackin = new ArrayDeque<>();
        int i=0;
//      括号落单情况排除
        if (s.length()%2 != 0){
            return false;
        }
//      遍历字符串s，为了方便匹配括号，将与之对应的括号入栈
        while (i<s.length()){
            if(s.charAt(i)=='('){
                stackin.push(')');
            }
            else if(s.charAt(i)=='['){
                stackin.push(']');
            }
            else if(s.charAt(i)=='{'){
                stackin.push('}');
            }
//          判断无效括号：栈为空或者括号不匹配
            else if (stackin.isEmpty() || s.charAt(i)!=stackin.peek()){
                return false;
            }
//          将匹配成功的括号对消除
            else if (s.charAt(i)==stackin.peek()){
                stackin.pop();
            }
            i++;
        }
//      若字符串已遍历完毕，栈仍不为空，则为左括号冗余情况
        return stackin.isEmpty();
    }


    public boolean isValid1(String s) {
        int i=0;
        stackin = new ArrayDeque<>();
//      哈希表构建左右括号对应关系：key对应左括号，value对应右括号
        HashMap<Character,Character> sites = new HashMap<>();
        sites.put('(',')');
        sites.put('{','}');
        sites.put('[',']');

//      括号落单情况排除
        if (s.length()%2 != 0){
            return false;
        }
//      遍历字符串s，为了方便匹配括号，将与之对应的括号入栈
        while (i<s.length()){
            if (sites.containsKey(s.charAt(i))){
                stackin.push(s.charAt(i));
            }
//          判断无效括号：栈为空或者括号不匹配
            else if (stackin.isEmpty() || s.charAt(i)!=sites.get(stackin.peek())){
                return false;
            }
//          将匹配成功的括号对消除
            else if (s.charAt(i)==sites.get(stackin.peek())){
                stackin.pop();
            }
            i++;
        }
//      若字符串已遍历完毕，栈仍不为空，则为左括号冗余情况
        return stackin.isEmpty();
    }



/*********************************  用栈实现队列  ********************************
 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
     实现 MyQueue 类：
     void push(int x) 将元素 x 推到队列的末尾
     int pop() 从队列的开头移除并返回元素
     int peek() 返回队列开头的元素
     boolean empty() 如果队列为空，返回 true ；否则，返回 false

     输入：
     ["MyQueue", "push", "push", "peek", "pop", "empty"]
     [[], [1], [2], [], [], []]
     输出：
     [null, null, null, 1, 1, false]
     解释：
     MyQueue myQueue = new MyQueue();
     myQueue.push(1); // queue is: [1]
     myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
     myQueue.peek(); // return 1
     myQueue.pop(); // return 1, queue is [2]
     myQueue.empty(); // return false
*/

//    public MyQueue() {
//        stackin = new ArrayDeque<>();
//        stackout = new ArrayDeque<>();
//    }

//    public void push(int x) {
//        stackin.push(x);
//    }

    public int pop() {
        while (stackout.isEmpty()){
            intoout();
        }
        return stackout.pop();
    }

    public int peek() {
        while (stackout.isEmpty()){
            intoout();
        }
        return stackout.peek();
    }

    public boolean empty() {
        return stackin.isEmpty()&& stackout.isEmpty();
    }

    private void intoout(){
        while (!stackin.isEmpty()){
//            stackout.push(stackin.pop());
        }
    }




}
