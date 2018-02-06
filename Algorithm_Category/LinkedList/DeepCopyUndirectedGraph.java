package LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Make a deep copy of an undirected graph, there could be cycles in the original graph.

    Assumptions:
        The given graph is not null
 */

//Time: O(V + E), Space: O(V)
//Think of topology of the graph, both BFS and DFS can solve this problem.
public class DeepCopyUndirectedGraph {
    public List<GraphNode> cloneGraph(List<GraphNode> graph) {
        Map<GraphNode, GraphNode> lookup = new HashMap<>();
        //think of isolated island problem
        for (GraphNode node : graph) {
            cloneGraph(node, lookup);
        }
        return new ArrayList<GraphNode>(lookup.values());
    }

    private GraphNode cloneGraph(GraphNode node, Map<GraphNode, GraphNode> lookup) {
        if (lookup.containsKey(node)) {
            return lookup.get(node);
        }
        GraphNode copy = new GraphNode(node.key);
        lookup.put(node, copy);
        for (GraphNode nei: node.neighbors) {
            copy.neighbors.add(cloneGraph(nei, lookup));
        }
        return copy;
    }
}

class GraphNode {
    public int key;
    public List<GraphNode> neighbors;
    public GraphNode(int key) {
        this.key = key;
        this.neighbors = new ArrayList<>();
    }
}

