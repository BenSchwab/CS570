package schwab.hw1.q1;

import schwab.search.algorithms.AStar;

/**
 * Created by Ben on 9/14/14.
 */
public class FifteenKnightSimulator {
    private static final int BOARD_SIZE = 4;
    private static String heuristicString = "0  3  2  5  3  4  1  2  2  1  4  3  5  2  3  2  3  0  3  2  2  3  2  1  1  2  1  4  2  3  2  3  2  3  0  3  1  2  3  2  4  1  2  1  3  2  3  2  5  2  3  0  2  1  4  3  3  4  1  2  2  3  2  5  3  2  1  2  0  3  2  3  3  2  1  2  2  1  4  3  4  3  2  1  3  0  3  2  2  3  2  1  1  2  1  4  1  2  3  4  2  3  0  3  1  2  3  2  4  1  2  1  2  1  2  3  3  2  3  0  2  1  2  3  3  4  1  2  2  1  4  3  3  2  1  2  0  3  2  3  3  2  1  2  1  2  1  4  2  3  2  1  3  0  3  2  4  3  2  1  4  1  2  1  1  2  3  2  2  3  0  3  1  2  3  4  3  4  1  2  2  1  2  3  3  2  3  0  2  1  2  3  5  2  3  2  2  1  4  3  3  4  1  2  0  3  2  5  2  3  2  3  1  2  1  4  2  3  2  1  3  0  3  2  3  2  3  2  4  1  2  1  1  2  3  2  2  3  0  3  2  3  2  5  3  4  1  2  2  1  4  3  5  2  3  0";
    public static int[] heuristicArray;

    private static void prepare(){
        String[] splitArray = heuristicString.split("  ");
        heuristicArray = new int[splitArray.length];
        for(int i =0; i<splitArray.length; i++){
            heuristicArray[i] = Integer.parseInt(splitArray[i]);
        }
    }

    private void printHeader(){
                return;
    }
    private int[] readFile(String fileDescriptor){
        return null;
    }



    public static void main(String[] args){
        FifteenKnightSimulator sim = new FifteenKnightSimulator();
        sim.prepare();
        for(String s: args){
            //sim.printHeader(s);

            //testcode


        }
        int[] initialState;// = sim.readFile(s);
        //initialState = new int[]{1, 2, 12, 13,5, 6, 7, 8,9, 3, 4, 0,11, 14, 15, 10};
        initialState = new int[]{10,11,3,13,5,4,1,2,9,8,6,12,0,14,15,7};
        FifteenKnightNode seed = new FifteenKnightNode(0, initialState);
        AStar searcher = new AStar(seed);
        searcher.start();

        System.out.println("Hello world!");
    }


}
