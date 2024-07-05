import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class levelorder2 {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void levelor(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        boolean reverse = false;
        Stack<Integer> stack = new Stack<>();

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                Node tp = q.poll();

                if (!reverse) {
                    System.out.print(tp.data + " ");
                } else {
                    stack.push(tp.data);
                }

                if (tp.left != null) {
                    q.offer(tp.left);
                }
                if (tp.right != null) {
                    q.offer(tp.right);
                }
            }

            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }

            reverse = !reverse;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);

        System.out.println("levelorder traversal :");
        levelor(root);
    }
}
