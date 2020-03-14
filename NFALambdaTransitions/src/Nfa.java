import java.util.ArrayList;
import java.util.List;

public class Nfa {
    //every node has a map for every transition possible given an input character
    public static final String LAMBDA ="/|";
    private List<Node> nodes;
    private List<Integer> finalNodesIndexes;

    public Nfa(List<Node> nodes, List<Integer> finalNodesIndexes) {
        this.nodes = nodes;
        this.finalNodesIndexes = finalNodesIndexes;
    }

    public List<String> compute(String inputString, int nodeIndex) {
        Node currentNode = nodes.get(nodeIndex);
        if (reachedFinalVertexWithEmptyString(nodeIndex,inputString)){
            List<String> result = new ArrayList<>();
            result.add("");
            return result;
        }
        else if (stringEmptyOrNull(inputString)){
            return null;
        }
        String currentKey = inputString.substring(0,1);
        String remainingString;
        try{
             remainingString = inputString.substring(1);
        }
        catch(IndexOutOfBoundsException e){
            remainingString = null;
        }
        List<Transition> possibleMoves = currentNode.getPossibleMove(currentKey);
        if (possibleMoves == null){
            return null;
        }
        List<String> result = new ArrayList<>();
        for (Transition transition : currentNode.getPossibleMove(currentKey)){
            String outputChar = transition.getOutputChar();
            if (!outputChar.equals(Nfa.LAMBDA)){
                List<String> resultStrings = compute(remainingString,transition.getDestinationNodeNumber());
                if (resultStrings != null) {
                    for (String string : resultStrings) {
                        result.add(outputChar + string);
                    }
                }
            }
            else {
                List<String> resultStrings = compute(inputString,transition.getDestinationNodeNumber());
                if (resultStrings != null) {
                    result.addAll(resultStrings);
                }
            }
        }
        return result;
    }

    private boolean reachedFinalVertexWithEmptyString(int nodeIndex,String inputString) {
        return finalNodesIndexes.contains(nodeIndex) && stringEmptyOrNull(inputString);
    }
    private boolean stringEmptyOrNull(String inputString) {
        return (inputString == null || inputString.length() == 0);
    }
}
