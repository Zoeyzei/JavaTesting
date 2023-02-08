package com.java.CodeCapriccio;

import sun.security.util.Length;

import javax.swing.*;

public class ListNodeTest {
    int val;
    ListNodeTest next;
    int nums [];


    ListNodeTest() {
    }

    ListNodeTest(int val) {
        this.val = val;
    }

    ListNodeTest(int val, ListNodeTest next) {
        this.val = val;
        this.next = next;

    }


    public void addNode(ListNodeTest head, int val) {
        ListNodeTest newNode = new ListNodeTest(val);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNodeTest temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }





        public void main(String[] args) {
            ListNodeTest listnode = new ListNodeTest();
            listnode.nums = new int[]{2, 3, 1, 2, 4, 3};
            for (int i=0;i< listnode.nums.length;i++){
                listnode.val = listnode.nums[i];
                listnode = listnode.next;
            }
            System.out.println();
            listnode.val = 6;
            ListNodeTest.removeElements(listnode, listnode.val);
        }

        public static ListNodeTest removeElements(ListNodeTest head, int val) {
            if (head == null) {
                return head;
            }
            head.next = removeElements(head.next, val);
            return head.val == val ? head.next : head;
//        System.out.println(head);
        }
    }
/********************************       移除列表元素       **************************************
    给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     示例 1：
     输入：head = [1,2,6,3,4,5,6], val = 6
     输出：[1,2,3,4,5]
     示例 2：
     输入：head = [], val = 1
     输出：[]
     示例 3：
     输入：head = [7,7,7,7], val = 7
     输出：[]

 思路：当头节点为Null，返回head；当头节点不为空时判断每个节点的值是否等于val，删除=val的节点
*/


