package schwab.search.graph;

import java.util.Comparator;

/**
 * Created by Ben on 9/22/14.
 */
public class NodeCostComparator implements Comparator<AbstractGraphNode> {
    @Override
    public int compare(AbstractGraphNode abstractGraphNode, AbstractGraphNode abstractGraphNode2) {
        return abstractGraphNode.getCost() - abstractGraphNode2.getCost();
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }
}
