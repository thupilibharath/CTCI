/**
 * Created by Bharath on 11/02/15.
 */
import java.util.*;

public class BFS {
    public static class Node
    {
        int value;
        List<Node> vertices = new ArrayList<Node>();
        boolean visited = false;

        public Node(int val)
        {
            value=val;
        }

        public void addVertex(Node v)
        {
            vertices.add(v);
        }

    }

    public static Node find(Node root, int element)
    {
        Queue q= new LinkedList();
        q.add(root);

        while(!q.isEmpty())
        {
            Node n = (Node)q.poll();
            n.visited=true;

            if(n.value==element)
                return n;

            for(Node v:n.vertices)
            {
                if(v.visited==true)
                    continue;
                else
                    q.add(v);
            }

        }
        return null;
    }

    public static void main(String[] args)
    {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        // call traverse
        n1.addVertex(n2);
        n1.addVertex(n3);

        n3.addVertex(n4);
        n3.addVertex(n5);

        Node found = find(n1, 4);
        System.out.println(found.value);
        // Node [value=4, visited=true, vertices=[]]

        found = find(n1, 7);
        //System.out.println(found.value);
    }

}
