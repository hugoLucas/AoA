import java.util.ArrayList;
import java.util.Random;

/**
 *
 * created by Hugo Flores J. Lucas on May 5, 2018
 */

class WeightedGraph {

    ArrayList<GraphNode> nodes;
    ArrayList<GraphConnection> connections;

    WeightedGraph(int nNodes, double connFactor){
        createNodes(nNodes);
        createConnections(connFactor);
    }

    public void visualizeGraph(){

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
}

