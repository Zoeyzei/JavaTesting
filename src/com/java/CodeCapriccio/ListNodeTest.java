package com.java.CodeCapriccio;

public class ListNodeTest {
    int val;
    ListNodeTest next;
    ListNodeTest() {}
    ListNodeTest(int val) {
        this.val = val;
    }
    ListNodeTest(int val, ListNodeTest next) {
        this.val = val;
        this.next = next;
    }




    public static void main(String[] args) {
        ListNodeTest listnode = new ListNodeTest();
//        head.val = [1,2,6,3,4,5,6];
        listnode.val = 6;
        listnode.head = new ListNodeTest();
        ListNodeTest.removeElements(head,listnode.val);
    }

    public static ListNodeTest removeElements(ListNodeTest head, int val) {
        if (head==null){
            return head;
        }
        head.next = removeElements(head.next,val);
        return head.val==val ? head.next : head;
        System.out.println(head);
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


