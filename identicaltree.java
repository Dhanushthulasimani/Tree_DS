public class identicaltree {
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
    public static boolean find(Node r, Node q)
    {
        if(r==null || q==null)
        {
            return false;
        }


        if(r==null && q==null)
        {
            return true;
        }
        if(r.data==q.data)
        {
            return true;
        }
        return find(r.left,q.left) && find(r.right,q.right);

    }
    public static void main(String[] args) {
        Node r = new Node(1);
        r.left = new Node(2);
        r.right = new Node(3);

        Node q = new Node(1);
        q.left = new Node(2);
        q.right = new Node(3);
        System.out.println(find(r,q));

    }
}

