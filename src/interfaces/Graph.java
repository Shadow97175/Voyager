//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package interfaces;

import java.util.Map;
import java.util.Set;

public interface Graph {
    Set<Graph.Vertex> getVertices();

    default Set<Graph.Vertex> getNeighbors(Graph.Vertex v) {
        return this.getConnections(v).keySet();
    }

    Map<Graph.Vertex, Graph.Edge> getConnections(Graph.Vertex var1);

    public interface Edge {
        int getWeight();
    }

    public interface Vertex {
        String getName();
    }
}
