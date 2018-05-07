
/**
 *
 * created by Hugo Flores J. Lucas on May 5, 2018
 */

class GraphConnection {

    private int weight;
    private GraphNode nodeOne;
    private GraphNode nodeTwo;

    GraphConnection(int w, GraphNode n1, GraphNode n2){
        weight = w;
        nodeOne = n1;
        nodeTwo = n2;
    }

    GraphNode[] getNodes(){
        return new GraphNode[]{nodeOne, nodeTwo};
    }

    boolean sameConnection(GraphConnection conn){
        boolean resultOne = false;
        boolean resultTwo = false;

        for (GraphNode node: conn.getNodes()){
            if (nodeOne == node)
                resultOne = true;
            if (nodeTwo == node)
                resultTwo = true;
        }

        return resultOne && resultTwo;
    }
}
