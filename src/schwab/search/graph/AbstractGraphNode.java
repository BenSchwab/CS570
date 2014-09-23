package schwab.search.graph;

import java.util.List;

/**
 * Created by Ben on 9/14/14.
 */
public abstract class AbstractGraphNode implements ISolutionVerifier {

    public int getCost(){
        return 0;
    };

    public abstract List<DirectedGraphEdge> getChildren();

    public abstract DirectedGraphEdge getParentEdge();

    public abstract void print();

}
