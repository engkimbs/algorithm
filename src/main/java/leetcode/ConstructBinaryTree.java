package leetcode;

import java.util.LinkedList;
import java.util.Queue;


public class ConstructBinaryTree {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeFromArray(0, 0, inorder.length - 1, preorder, inorder);
    }

    public static TreeNode buildTreeFromArray(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if(preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for(int i=inStart; i<=inEnd; ++i) {
            if(inorder[i] == root.val) {
                inIndex = i;
            }
        }

        root.left = buildTreeFromArray(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = buildTreeFromArray(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node==null)
                System.out.println(node);
            else
                System.out.println(node.val);

            if(node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }

    static class TreeNode {
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

}
