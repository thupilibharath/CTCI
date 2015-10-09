/**
 * Created by Bharath on 11/02/15.
 */
public class DFS {
    static String result = null;
    public static class Vertex
    {
        public String name;
        public Edge[] adjacencies;
        double minDistance = Double.POSITIVE_INFINITY;
        boolean visited=false;
        public Vertex(String na)
        {
            this.name = na;
        }
        Vertex previous;

    }

    public static class Edge
    {
        public Vertex targetVertex;
        public int weight;
        public Edge(Vertex v, int w)
        {
            targetVertex=v;
            weight=w;
        }
    }

    public static String findDFS(Vertex v, String element)
    {
        //String result=null;
        v.visited=true;
     if(v.name.equals(element))
     {
         result="found";
         return result;
     }
        for(Edge e:v.adjacencies)
        {
            if(e.targetVertex.visited==true)
                continue;
            else
                findDFS(e.targetVertex,element);
        }
        return result;
    }

    public static void main(String[] args) {
        Vertex v0 = new Vertex("Redvile");
        Vertex v1 = new Vertex("Blueville");
        Vertex v2 = new Vertex("Greenville");
        Vertex v3 = new Vertex("Orangeville");
        Vertex v4 = new Vertex("Purpleville");

        v0.adjacencies = new Edge[]{new Edge(v1, 5),
                new Edge(v2, 10),
                new Edge(v3, 8)};
        v1.adjacencies = new Edge[]{new Edge(v0, 5),
                new Edge(v2, 3),
                new Edge(v4, 7)};
        v2.adjacencies = new Edge[]{new Edge(v0, 10),
                new Edge(v1, 3)};
        v3.adjacencies = new Edge[]{new Edge(v0, 8),
                new Edge(v4, 2)};
        v4.adjacencies = new Edge[]{new Edge(v1, 7),
                new Edge(v3, 2)};
        Vertex[] vertices = {v0, v1, v2, v3, v4};
        DFS d = new DFS();
        for(Vertex v:vertices)
        {
            for(Vertex v7:vertices) {
                String res = d.findDFS(v, v7.name);
                System.out.println(res + " "+v7.name +" from " + v.name);
            }
        }
    }
}
