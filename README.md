# NonDeterministicEpsilonTranslator

Java implementation of a NonDeterministic Epsilon translator, that simulates the translator's outputs for a given inputString.
The configuration of the translator is done through the date.in file of the project.

For configuring a new translator follow the guide:
	*on the first line provide the input string for the Translator
	*on the second line provide the number of nodes of the Translator
	*on the third line provide the start state
	*on the fourth line provide the final states separated by a blank space, if more than one.
	*on the following lines provide the transitions(edges) of the translator, one on every line.
A transition must follow the convention(a b c d) where:
	*a is the starting node
	*b is the input character of the transition
	*c is the destination node
	*d is the output character of the transition 
	

![Configuration Description](/images/inputExplanation.png)
For the above configuration, the following Translator is built: 

![Configuration Description](/images/GeneratedTranslator.jpg)