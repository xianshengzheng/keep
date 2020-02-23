package dongtaiguihua;

/**
 * Definition for a binary tree node.
 * 从一个二叉树的任意节点出发，到任意节点的最短路径
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        System.out.println(solution.maxPathSum(treeNode));
    }

     int MAX_VALUE = Integer.MIN_VALUE;
     public int maxPathSum(TreeNode root) {
         fun(root);
         return MAX_VALUE;
     }
    
    public int fun(TreeNode root) {
        if(root.left == null && root.right == null){
            return root.val;
        }
        int leftMax = 0;
        int rightMax = 0;
        if(root.left !=null){
            leftMax = fun(root.left);
        }
         if(root.right !=null){
            rightMax = fun(root.right);
        }
        
        int result = 0;
        if(leftMax > 0){
            result += leftMax;
        }
        if(rightMax > 0){
            result +=rightMax;
        }
        MAX_VALUE = Math.max(MAX_VALUE,result+root.val);
        
        int childMax = Math.max(leftMax,rightMax);
        
        return Math.max(root.val,childMax+root.val);
        
    }
}

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}