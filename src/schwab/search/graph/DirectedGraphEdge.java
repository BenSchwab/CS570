package schwab.search.graph;

/**
 * Created by Ben on 9/22/14.
 */
public class DirectedGraphEdge extends AbstractGraphEdge {

    protected AbstractGraphNode fromNode;
    protected AbstractGraphNode toNode;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    protected int weight;

    public DirectedGraphEdge(AbstractGraphNode from, AbstractGraphNode to, int weight){
        fromNode = from;
        toNode = to;
        this.weight = weight;
    }

    public AbstractGraphNode getFromNode() {
        return fromNode;
    }

    public AbstractGraphNode getToNode() {
        return toNode;
    }

    public void setToNode(AbstractGraphNode toNode) {
        this.toNode = toNode;
    }

    public void setFromNode(AbstractGraphNode fromNode) {
        this.fromNode = fromNode;
    }

}
