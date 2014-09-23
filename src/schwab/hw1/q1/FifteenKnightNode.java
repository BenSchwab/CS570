package schwab.hw1.q1;

import schwab.search.graph.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ben on 9/14/14.
 */
public class FifteenKnightNode extends AbstractGraphNode implements Heuristical, ISolutionVerifier {

    private int searchDepth;
    private FifteenKnightNode parentNode;

    public int[] getGameMapping() {
        return gameMapping;
    }

    private int[] gameMapping;

    public FifteenKnightNode(int level, int[] gameMapping){
        this.searchDepth = level;
        this.gameMapping = gameMapping;
    }

    public FifteenKnightNode(int level, int[] gameMapping, FifteenKnightNode parent){
        this.searchDepth = level;
        this.gameMapping = gameMapping;
        this.parentNode = parent;
    }

    @Override
    public int getCost() {
        return getHeuristic() + searchDepth;
    }

    @Override
    public List<DirectedGraphEdge> getChildren() {

        int openPosition = getOpenPosition();
        Point openPoint = convertLocToPoint(openPosition);

        List<Point> points = generatePossibleMoves(openPoint);
        List<DirectedGraphEdge> edges = new ArrayList<DirectedGraphEdge>();
        for(Point p: points){
            int swapPosition = pointToInt(p);
            int [] mappingNew = gameMapping.clone();
            swapPositions(mappingNew, openPosition, swapPosition);
            edges.add(new FifteenKnightEdge(this, new FifteenKnightNode(this.searchDepth+1, mappingNew, this)));
        }
        return edges;

    }

    @Override
    public DirectedGraphEdge getParentEdge() {
        return new DirectedGraphEdge(this, parentNode, -1);
    }


    @Override
    public int getHeuristic() {
        int[] heuristicArray = FifteenKnightSimulator.heuristicArray;
        int cost = 0;
        for(int i =0; i<gameMapping.length; i++){
            //Count the minimimum number of moves to put pieces in optimal slot with the condition of only moving
            //on the open spaced relaxed.
            int goalPosition = gameMapping[i]-1;
            int currentPosition = i;
            if(gameMapping[i]!=0 && goalPosition != currentPosition){
                cost+=heuristicArray[16*currentPosition+goalPosition];
            }
        }
        return cost;
    }

    @Override
    public boolean equals(Object other){
        if(!(other instanceof FifteenKnightNode)){
            return false;
        }
        FifteenKnightNode otherKnight = (FifteenKnightNode)(other);
        for(int i=0; i<gameMapping.length; i++){
            if(gameMapping[i]!=otherKnight.getGameMapping()[i]){
                return false;
            }
        }
        return true;
    }
    @Override
    public int hashCode(){
        StringBuilder b = new StringBuilder();
        for(int i: gameMapping){
            b.append(i);
        }
        return b.toString().hashCode();
    }


    /*****************************
     * State representaiton code
     ****************************/

    private static final int MAP_SIZE = 4;

    public List<Point> generatePossibleMoves(Point fromPoint){

        Point a = new Point(fromPoint.x -1, fromPoint.y -2);
        Point b = new Point(fromPoint.x +1, fromPoint.y -2);
        Point c = new Point(fromPoint.x +1, fromPoint.y +2);
        Point d = new Point(fromPoint.x -1, fromPoint.y +2);
        Point e = new Point(fromPoint.x -2, fromPoint.y -1);
        Point f = new Point(fromPoint.x +2, fromPoint.y -1);
        Point g = new Point(fromPoint.x +2, fromPoint.y +1);
        Point h = new Point(fromPoint.x -2, fromPoint.y +1);
        ArrayList<Point> possiblePoints = new ArrayList<Point>(Arrays.asList(a,b,c,d,e,f,g,h));
        for(int i = possiblePoints.size()-1; i>=0; i--){
            if(!isValidPoint(possiblePoints.get(i))){
                possiblePoints.remove(i);
            }
        }
        return possiblePoints;

    }

    public boolean isValidPoint(Point p){
        return p.x>=0&&p.x<MAP_SIZE&&p.y>=0&&p.y<MAP_SIZE;
    }

    public static int pointToInt(Point point){
        return point.x*MAP_SIZE+point.y;
    }

    public static void swapPositions(int[] mapping, int posOne, int posTwo){
        int old = mapping[posOne];
        mapping[posOne] = mapping[posTwo];
        mapping[posTwo] = old;
    }

    public static Point convertLocToPoint(int loc){
        int row = loc/4;
        int col = loc%4;
        return new Point(row, col);
    }

    public int getOpenPosition(){
        for(int i = 0; i<gameMapping.length; i++){
            if(gameMapping[i] == 0){
                return i;
            }
        }
        return -1;
    }


    @Override
    public boolean verifySolution() {
        for(int i = 0; i<gameMapping.length-1; i++){
            if(gameMapping[i] != i+1){
                return false;
            }
        }
        return true;
    }

    public void print(){
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                System.out.print(gameMapping[i*4+j]+" ");

            }
            System.out.println("");
        }
    }
}
