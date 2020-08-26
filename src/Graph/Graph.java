package Graph;

/* Graphs can be represented with a set of vertices and edges
 * Graphs can be directed or undirected, and can contain self loops and multiedges.
 * The maximum number of edges in a simple directed graph is n(n-1) where n = |# of Vertices|
 * The maximum of edges in a simple undirected graph is (n/2)(n-1)
 */

import java.util.ArrayList;

class Edge {
    // startVertex & endVertex can be points to the vertex objects OR
    // even better - they can refer to the INDEX of the object to which they refer
    int startVertex;
    int endVertex;
    // Edges can also have weights
    int weight;

    // In the undirected case, startVertex and endVertex can be used interchangeably
    Edge(int startVertex, int endVertex, int weight) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }
}

class Vertex {
    String vertex;

    Vertex(String vertex) {
        this.vertex = vertex;
    }

    public String toString() {
        return vertex;
    }
}

public class Graph {
    ArrayList vertices = new ArrayList<Vertex>();
    ArrayList edges = new ArrayList<Edge>();
}
