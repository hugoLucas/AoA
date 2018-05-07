
/**
 *
 * created by Hugo Flores J. Lucas on May 5, 2018
 */

public class Main {

    public static void main(String[] args) {
        int nNodes = 5;
        double connFactor = 1.0;

        WeightedGraph graph = new WeightedGraph(nNodes, connFactor);
        graph.visualize();
    }
}
