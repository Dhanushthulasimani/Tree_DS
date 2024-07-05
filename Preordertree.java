public class Preordertree {
    static class Node {
        int data;
        Node left;    Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);


        System.out.println("Preorder traversal of binary tree is:");
        preorder(root);
    }
}
// TreeNode class definition
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// Solution class
class Solution {
    int max = 0;
    int temp = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return temp;
    }

    public int dfs(TreeNode root, int cur) {
        if (root == null) {
            return 0;
        }

        if (cur > max && root.left == null && root.right == null) {
            max = cur;
            temp = root.val;
            return root.val;
        }

        int a = dfs(root.left, cur + 1);
        int b = dfs(root.right, cur + 1);

        if (a != 0) {
            return a;
        } else {
            return b;
        }
    }
}


