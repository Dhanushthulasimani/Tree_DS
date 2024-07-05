import java.util.*;

public class revtree
{
    public static class node
    {
        int data;
        node left;
        node right;
    }

    static int id = -1;
    static int i = 1;
    static int n = 0;

    public static node build(int a[])
    {
        id++;
        if (id >= a.length || a[id] == -1)
        {
            return null;
        }

        node nn = new node();
        nn.data = a[id];
        nn.left = build(a);
        nn.right = build(a);
        return nn;
    }

    public static void reverse()
    {
        Stack<node> s = new Stack<>();
        while(!nq.isEmpty())
        {
            s.push(nq.poll());
        }
        
        while(!s.isEmpty())
        {
            nq.add(s.pop());
        }
    }

    static Queue<node> nq = new LinkedList<>();

    public static void levelorder(node root)
    {
        if(n %2 == 1)
        {
            if(root.right != null)
            {
                nq.add(root.right);
            }

            if(root.left != null)
            {
                nq.add(root.left);
            }
        }
        else
        {
            if(root.left != null)
            {
                nq.add(root.left);
            }
            
            if(root.right != null)
            {
                nq.add(root.right);
            }
        }

        System.out.print(root.data+" ");
        
        if (nq.isEmpty())
        {
            return;
        }

        if(i == Math.pow(2,n))   
        {
            reverse();
            i = 0;
            n++;
            System.out.println();
        }
        i++;

        levelorder(nq.poll());
    }

    public static void main(String[] args)
    {
        int node[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        node root = build(node);

        levelorder(root);
        System.out.println();

    }
}
