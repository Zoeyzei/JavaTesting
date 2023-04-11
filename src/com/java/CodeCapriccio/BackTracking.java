package com.java.CodeCapriccio;

import java.util.*;

/*****************   回溯公式    *********************
void backtracking(参数) {
    if (终止条件) {
        存放结果;
        return;}

    for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
        处理节点;
        backtracking(路径，选择列表); // 递归
        回溯，撤销处理结果;}
}
*/

    public class BackTracking {
        int n,k;
        int[] nums;
        String s;
        public static void main(String[] args) {
            BackTracking backTracking = new BackTracking();
            backTracking.n = 4;
            backTracking.k = 2;
            backTracking.s = "aab";
            backTracking.nums = new int[]{1,2,3};
            backTracking.subsets1(backTracking.nums);
        }


/*************************  排列问题    ************************
    输入：nums = [1,2,3]
    输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

*/
    public List<List<Integer>> permute(int[] nums) {

    }






/*************************      子集问题       ******************************
    输入：nums = [1,2,3]
    输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

 思路：
1.回溯
*/
    public List<List<Integer>> subsets1(int[] nums) {
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();

        subsetsdfs(nums,0,path,res);
        System.out.println("res：" + res);
        return res;

    }
    private void subsetsdfs(int[] nums, int i, Deque<Integer> path,  List<List<Integer>> res){
        res.add(new ArrayList<>(path));
        if (i>=nums.length){
            return;
        }
        for (int j=i;j<nums.length;j++){
            path.addLast(nums[j]);
            subsetsdfs(nums,j+1,path,res);
            path.removeLast();
        }
    }





//2.每个元素都有选不选 两种选择，相当于二叉树中序遍历，左子树是不选，右子树是选

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        inorder(nums,0,path,res);
        System.out.println("res：" + res);
        return res;

    }
    public static void inorder(int[] nums, int i, ArrayList<Integer> path,  List<List<Integer>> res){
//        System.out.println(path);
        if (i == nums.length){
            res.add(path);
            return;
        }
        path = new ArrayList<Integer>(path);

        inorder(nums,i+1,path,res);
        path.add(nums[i]);
        inorder(nums,i+1,path,res);
    }




/**************************    分割回文串    *************************
 输入：s = "aab"
 输出：[["a","a","b"],["aa","b"]]

 思路：回溯+回文串判断
 用栈保存当前分割的字符子串，二维数组res存储所有分割组合，若为回文串，递归回溯
 */
    public List<List<String>> partition(String s) {
        Deque<String> path = new ArrayDeque<>();
        List<List<String>> res = new ArrayList<>();

        if (s.length()==0){
            return res;
        }
        partitiondfs(s,0,path,res);
        System.out.println("res：" + res);
        return res;
    }

    private void partitiondfs(String s, int start, Deque<String>path, List<List<String>> res){
//        终止条件：字符串已遍历分割完毕
        if (start==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=start;i<s.length();i++){
//          判断回文串[start,i]，回文标识 flag
            int left = start,right = i;
            boolean flag=true;
            while (left<right){
                if (s.charAt(left)==s.charAt(right)){
                    left++;
                    right--;
                }
                else {
                    flag = false;
                    break;
                }
            }
//          若为回文串，递归回溯
            if (flag){
                path.addLast(s.substring(start,i+1));      //截取回文串[start,i]
                partitiondfs(s,i+1,path,res);
                path.removeLast();
            }

        }
    }






/***************************    组合      *************************
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
你可以按 任何顺序 返回答案。
 示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]

 回溯：用栈保存当前组合，二维数组res存储所有组合，回溯时注意剪枝（避免重复组合），
 优化情况考虑遍历的右边界可根据组合长度进行剪枝：k - path.size() = 接下来要选择的元素个数 = n - 右边界 + 1
*/
    public List<List<Integer>> combine(int n, int k) {
//        二维数组res存储最终答案，栈path存储每个组合
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();

        if (k <= 0 || n < k) {
            return res;
        }
        dfs(n,k,1,path,res);
        System.out.println("res：" + res);
        return res;
    }

    private void dfs(int n, int k, int start, Deque<Integer>path, List<List<Integer>> res){
//        终止条件，当前path满足题目组合要求
        if (path.size()==k){
            res.add(new ArrayList<>(path));
            System.out.println("res：" + res);
            return;
        }
//        for循环，对每个集合进行操作
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.push(i);       //处理节点，添加节点值
            dfs(n,k,i+1,path,res);      //递归
            path.pop();     //回溯
        }
    }






}
