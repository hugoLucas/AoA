import java.util.UUID;

/**
 *
 * created by Hugo Flores J. Lucas on May 5, 2018
 */

public class GraphNode {

    private UUID nodeId;

    GraphNode(){
        nodeId = UUID.randomUUID();
    }

    public UUID getNodeId() {
        return nodeId;
    }
}
