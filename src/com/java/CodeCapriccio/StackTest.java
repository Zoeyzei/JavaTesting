package com.java.CodeCapriccio;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class StackTest {
    Stack<Integer> stackin;
    Stack<Integer> stackout;

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

 Stack<Integer> stackin;
 Stack<Integer> stackout;
*/

    public MyQueue() {
        stackin = new Stack<>();
        stackout = new Stack<>();
    }

    public void push(int x) {
        stackin.push(x);
    }

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
            stackout.push(stackin.pop());
        }
    }

}
