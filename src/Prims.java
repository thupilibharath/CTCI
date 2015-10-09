/**
 * Created by Bharath on 13/02/15.
 */
import java.util.*;

public class Prims {
    public static class Vertex
    {
        public String name;
        public Edge[] adjacencies;
        double minDistance = Double.POSITIVE_INFINITY;
        public Vertex(String na)
        {
            this.name = na;
        }
        Vertex previous;
        boolean visited=false;

    }

    public static class Edge
    {
        public Vertex targetVertex;
        public double weight;
        public Edge()
        {}
        public Edge(Vertex v, Double w)
        {
            targetVertex=v;
            weight=w;
        }
    }
    public static void mstPrim(Vertex source, HashSet<Vertex> V, HashSet<Vertex> X)
    {
        try {
            source.minDistance = 0;
            source.visited=true;
            X.add(source);
            Queue q = new LinkedList();
            Queue mst = new LinkedList();
            Queue q1 = new PriorityQueue(4, new Comparator<Edge>(){
                public int compare(Edge e1, Edge e2)
                {
                    if(e1.weight<e2.weight)
                        return -1;
                    else
                        return 1;
                }
            });

            Vertex temp = source;

            while(!X.containsAll(V))
            {

            for(Edge e: temp.adjacencies)
            {

                if(temp.visited==true&&e.targetVertex.visited==true)
                    continue;
                q1.add(e);
            }
            Edge e1=(Edge)q1.poll();
            X.add(e1.targetVertex);
                System.out.println(X);

                System.out.println(e1.targetVertex.name);
                temp.visited=true;
                e1.targetVertex.visited=true;
                mst.add(temp.name);
                temp = e1.targetVertex;
                mst.add(e1.targetVertex.name);

            }
            System.out.println(mst);

        }
        catch (Exception e){
            e.printStackTrace();

        }
    }
    public static List<String> getShortestPathTo(Vertex target)
    {
        List<String> path = new ArrayList<String>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex.name);
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args)
    {
        Vertex v0 = new Vertex("Redvile");
        Vertex v1 = new Vertex("Blueville");
        Vertex v2 = new Vertex("Greenville");
        Vertex v3 = new Vertex("Orangeville");
        Vertex v4 = new Vertex("Purpleville");

        v0.adjacencies = new Edge[]{ new Edge(v1, 5.0),
                new Edge(v2, 10.0),
                new Edge(v3, 8.0) };
        v1.adjacencies = new Edge[]{ new Edge(v0, 5.0),
                new Edge(v2, 3.0),
                new Edge(v4, 7.0) };
        v2.adjacencies = new Edge[]{ new Edge(v0, 10.0),
                new Edge(v1, 3.0) };
        v3.adjacencies = new Edge[]{ new Edge(v0, 8.0),
                new Edge(v4, 2.0) };
        v4.adjacencies = new Edge[]{ new Edge(v1, 7.0),
                new Edge(v3, 2.0) };
        Vertex[] vertices = { v0, v1, v2, v3, v4 };
        Prims d = new Prims();
        HashSet<Vertex> X= new HashSet<Vertex>();
        HashSet<Vertex> V= new HashSet<Vertex>();
        V.add(v0);
        V.add(v1);
        V.add(v2);
        V.add(v3);
        V.add(v4);
        d.mstPrim(v0, V, X);
        /*for (Vertex v : vertices)
        {
            System.out.println("Distance to " + v + ": " + v.minDistance);
            List<String> path = getShortestPathTo(v);
            System.out.println("Path: " + path);
        }*/

    }



}
