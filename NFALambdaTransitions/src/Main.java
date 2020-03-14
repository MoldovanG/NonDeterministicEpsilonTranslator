import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("date.in"));
        String inputString = bufferedReader.readLine();
        Integer numberOfNodes= Integer.valueOf(bufferedReader.readLine());
        Integer startingNodeIndex = Integer.valueOf(bufferedReader.readLine());
        List<Node> nodes = new ArrayList<>();
        String[] parts = bufferedReader.readLine().split(" ");
        List<Integer> indexOfFinalNodes = new ArrayList<>();
        for (int i = 0; i < numberOfNodes; i+=1){
            nodes.add(new Node());
        }
        for (String elem : parts){
            indexOfFinalNodes.add(Integer.valueOf(elem));
        }
        String line = bufferedReader.readLine();
        while(line!=null) {
            List<String> transitionParts = Arrays.asList(line.split(" "));
            int nodeIndex = Integer.parseInt(transitionParts.get(0));
            String key = transitionParts.get(1);
            int destinationNodeIndex = Integer.parseInt(transitionParts.get(2));
            String outputValue = transitionParts.get(3);
            Transition transition = new Transition(outputValue,destinationNodeIndex);
            Node node = nodes.get(nodeIndex);
            node.addTransition(key,transition);
            nodes.remove(nodeIndex);
            nodes.add(nodeIndex,node);
            line = bufferedReader.readLine();
        }
        Nfa nfa = new Nfa(nodes,indexOfFinalNodes);
        System.out.println(nfa.compute(inputString,startingNodeIndex));
    }
}
