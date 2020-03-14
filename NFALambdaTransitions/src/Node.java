
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    private Map<String, List<Transition>> transitionMap;

    public Node() {
        transitionMap = new HashMap<>();
    }

    public void addTransition(String key, Transition transition){
        if (transitionMap.containsKey(key)) {
            List<Transition> transitions = transitionMap.get(key);
            transitions.add(transition);
            transitionMap.put(key,transitions);
        }
        else {
            List<Transition> transitions = new ArrayList<>();
            transitions.add(transition);
            transitionMap.put(key,transitions);
        }
    }

    public List<Transition> getPossibleMove (String key) {
        final List<Transition> possibleKeyMoves = transitionMap.get(key);
        final List<Transition> possibleLambdaMoves = transitionMap.get(Nfa.LAMBDA);
        List<Transition> combinedList = new ArrayList<>();
        if (possibleKeyMoves != null) {
            combinedList.addAll(possibleKeyMoves);
        }
        if (possibleLambdaMoves != null) {
            combinedList.addAll(possibleLambdaMoves);
        }
        return combinedList;
    }
}
