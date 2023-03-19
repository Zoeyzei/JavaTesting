package com.java.CodeCapriccio;



import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class StackTest {
    Deque<Character> stackin;
    Deque<Integer> stackout;
    String s;

    public static void main(String[] args) {
        StackTest stacktest = new StackTest();

//        stacktest.stackin = new Stack<>();
        stacktest.s = "()[]{}";
        System.out.println(stacktest.isValid(stacktest.s));
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
     将元素依次进栈，遇到对应的括号出栈，验证最终栈是否为空
     */
    public boolean isValid(String s) {
        stackin = new ArrayDeque<>();
        int i=0;
        while (i<s.length()){
            if(s.charAt(i)=='('){
                stackin.push(')');
            }
            if(s.charAt(i)=='['){
                stackin.push(']');
            }
            if(s.charAt(i)=='{'){
                stackin.push('}');
            }

        }
        return true;
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
