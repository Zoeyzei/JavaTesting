package com.java.CodeCapriccio;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTreeTest test = new BinaryTreeTest();
//        test.root = [1,2,3,null,5];
//        binaryTreePaths(TreeNode root);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


/**********************     二叉树的所有路径    ********************
 输入：root = [1,2,3,null,5]
 输出：["1->2->5","1->3"]

深度优先遍历+递归
*/
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        if (root.left==null && root.right==null){
            res.add(root.val + "");
        }
        for (String path : binaryTreePaths(root.left)){
            res.add(root.val + "->" + path);
        }
        for (String path : binaryTreePaths(root.right)){
            res.add(root.val + "->" + path);
        }
        return res;
    }



/*********************  遍历  ***********************
 前序遍历：中左右
 中序遍历：左中右
 后序遍历：左右中
*/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }
//  前序遍历
    void preorder(TreeNode root, List<Integer> list){
        if (root==null){
            return;
        }
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
    }
//  中序遍历
    void inorder(TreeNode root, List<Integer> list){
        if (root==null){
            return;
        }
        preorder(root.left,list);
        list.add(root.val);
        preorder(root.right,list);
    }
//  后序遍历
    void postorder(TreeNode root, List<Integer> list){
        if (root==null){
            return;
        }
        preorder(root.left,list);
        list.add(root.val);
        preorder(root.right,list);
    }

}
