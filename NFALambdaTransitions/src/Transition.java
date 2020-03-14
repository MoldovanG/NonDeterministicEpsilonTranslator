public class Transition {
    private String outputChar;
    private int destinationNodeNumber;

    public Transition(String outputChar, int destinationNodeNumber) {
        this.outputChar = outputChar;
        this.destinationNodeNumber = destinationNodeNumber;
    }

    public String getOutputChar() {
        return outputChar;
    }

    public int getDestinationNodeNumber() {
        return destinationNodeNumber;
    }
}
