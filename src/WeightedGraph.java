import java.util.*;

/**
 *
 * created by Hugo Flores J. Lucas on May 5, 2018
 */

class WeightedGraph {

    private ArrayList<GraphNode> nodes;
    private ArrayList<GraphConnection> connections;

    WeightedGraph(int nNodes, double connFactor){
        createNodes(nNodes);
        createConnections(connFactor);
    }

    private void createNodes(int nNodes){
        nodes = new ArrayList<>(nNodes);
        for (int i = 0; i < nNodes; i ++)
            nodes.add(new GraphNode());
    }

    private void createConnections(double connFactor){
        connections = new ArrayList<>();

        int connectionAttempts = (int)(connFactor * nodes.size());
        Random generator = new Random();

        while (connectionAttempts > 0){
            int[] indices = this.selectIndices(generator);
            int weight = generator.nextInt(100) + 1;

            GraphConnection conn = new GraphConnection(weight, nodes.get(indices[0]), nodes.get(indices[1]));
            if (uniqueConnection(conn))
                connections.add(conn);

            connectionAttempts --;
        }
    }

    private boolean uniqueConnection(GraphConnection conn){
        for (GraphConnection c: connections)
            if (c.sameConnection(conn))
                return false;

        return true;
    }

    private int[] selectIndices(Random gen){
        int index1 = gen.nextInt(nodes.size());
        int index2 = gen.nextInt(nodes.size());

        while(index1 == index2)
            index2 = gen.nextInt(nodes.size());

        return new int[]{index1, index2};
    }

    void visualize() {
        HashMap<GraphNode, Set<GraphNode>> connectionsByNode = new HashMap<>();
        for (GraphConnection c : this.connections) {
            GraphNode[] connections = c.getNodes();

            if (!connectionsByNode.containsKey(connections[0]))
                connectionsByNode.put(connections[0], new HashSet<>());
            connectionsByNode.get(connections[0]).add(connections[1]);

            if (!connectionsByNode.containsKey(connections[1]))
                connectionsByNode.put(connections[1], new HashSet<>());
            connectionsByNode.get(connections[1]).add(connections[0]);
        }

        for (GraphNode key: connectionsByNode.keySet()){
            System.out.println("Node: " + key.getNodeId());
            for (GraphNode conn: connectionsByNode.get(key))
                System.out.print(conn.getNodeId() + ", ");
            System.out.println("\n");
        }
    }
}

