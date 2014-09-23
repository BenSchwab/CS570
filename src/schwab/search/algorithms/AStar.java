package schwab.search.algorithms;

import schwab.search.graph.AbstractGraphEdge;
import schwab.search.graph.AbstractGraphNode;
import schwab.search.graph.DirectedGraphEdge;
import schwab.search.graph.NodeCostComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Ben on 9/22/14.
 *
 * Generic AStar search using my Graph API.
 */
public class AStar {

    private PriorityQueue<AbstractGraphNode> fringe =
            new PriorityQueue<AbstractGraphNode>(100, new NodeCostComparator());

    private AbstractGraphNode seed;

    public AStar(AbstractGraphNode seed){
       this.seed = seed;
    }

    public AbstractGraphNode start(){
        fringe.add(seed);
        while(true){
            if(fringe.size() == 0){
                System.out.println("fringe empty");
                throw new Error("Ran out of fringe. Search impossible.");
            }
            AbstractGraphNode cheapest = fringe.remove();
            if(cheapest.verifySolution()){
                cheapest.print();
                System.out.println("Found answer of cost:" + cheapest.getCost());
                ArrayList<AbstractGraphNode> path = new ArrayList<AbstractGraphNode>();
                path.add(cheapest);
                DirectedGraphEdge retraceEdge = cheapest.getParentEdge();
                while(retraceEdge.getToNode() != null){
                    path.add(retraceEdge.getToNode());
                    retraceEdge = retraceEdge.getToNode().getParentEdge();
                }

                //Todo: move this Simulator
                Collections.reverse(path);
                System.out.println("The set of moves: ");
                for(AbstractGraphNode node: path){
                    node.print();
                    System.out.println(" ");
                }
                return cheapest;
            }
            //Add all the children to the fringe
            for(DirectedGraphEdge edge : cheapest.getChildren()){
                fringe.add(edge.getToNode());
            }

        }
    }


}
