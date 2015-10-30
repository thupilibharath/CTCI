/**
 * Created by Bharath on 11/02/15.
 */
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.List;
import java.util.Collections;

public class Dijkstra {
    public static class Vertex {
        public String name;
        public Edge[] adjacencies;
        double minDistance = Double.POSITIVE_INFINITY;
        public Vertex(String na) {
            this.name = na;
        }
        Vertex previous;

    }

    public static class Edge {
        public Vertex targetVertex;
        public int weight;
        public Edge(Vertex v, int w) {
            targetVertex = v;
            weight = w;
        }
    }
    public static void computePaths(Vertex source) {
        source.minDistance = 0;
        Queue q = new LinkedList();
        q.add(source);

        while (!q.isEmpty()) {
            Vertex u = (Vertex)q.poll();

            for (Edge e : u.adjacencies) {
                Vertex v = e.targetVertex;
                int weight = e.weight;
                double distthroughU = u.minDistance + weight;
                if (distthroughU < v.minDistance) {
                    v.minDistance = distthroughU;
                    v.previous = u;
                    q.add(v);
                }

            }
        }
    }
    public static List<String> getShortestPathTo(Vertex target) {
        List<String> path = new ArrayList<String>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex.name);
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        Vertex v0 = new Vertex("Redvile");
        Vertex v1 = new Vertex("Blueville");
        Vertex v2 = new Vertex("Greenville");
        Vertex v3 = new Vertex("Orangeville");
        Vertex v4 = new Vertex("Purpleville");

        v0.adjacencies = new Edge[] { new Edge(v1, 5),
                           new Edge(v2, 10),
                           new Edge(v3, 8)
        };
        v1.adjacencies = new Edge[] { new Edge(v0, 5),
                           new Edge(v2, 3),
                           new Edge(v4, 7)
        };
        v2.adjacencies = new Edge[] { new Edge(v0, 10),
                           new Edge(v1, 3)
        };
        v3.adjacencies = new Edge[] { new Edge(v0, 8),
                           new Edge(v4, 2)
        };
        v4.adjacencies = new Edge[] { new Edge(v1, 7),
                           new Edge(v3, 2)
        };
        Vertex[] vertices = { v0, v1, v2, v3, v4 };
        Dijkstra d = new Dijkstra();
        d.computePaths(v0);
        for (Vertex v : vertices) {
            System.out.println("Distance to " + v + ": " + v.minDistance);
            List<String> path = getShortestPathTo(v);
            System.out.println("Path: " + path);
        }

    }



}
