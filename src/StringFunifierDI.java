import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class StringFunifierDI {
    private String boringString;
    private List<Integer> startIndexes;
    private List<Integer> endIndexes;
    private List<String> funOperations;
    private Map<String, TransformationStrategy> transformationStrategies;

    public StringFunifierDI(String boringString, List<Integer> startIndexes, List<Integer> endIndexes, List<String> funOperations, Map<String, TransformationStrategy> transformationStrategies) {
        this.boringString = boringString;
        this.startIndexes = startIndexes;
        this.endIndexes = endIndexes;
        this.funOperations = funOperations;
        this.transformationStrategies = transformationStrategies;
    }


    public String getFunnyString() {
        StringBuilder funnyString = new StringBuilder();
        int currentIndex = 0;

        for (int i = 0; i < startIndexes.size(); i++) {
            int startIndex = startIndexes.get(i);
            int endIndex = endIndexes.get(i);
            String operation = funOperations.get(i);

            // Append the substring before the current range
            funnyString.append(boringString, currentIndex, startIndex);

            // Get the substring to be transformed
            String substring = boringString.substring(startIndex, endIndex + 1);

            // Apply the transformation
            TransformationStrategy strategy = transformationStrategies.get(operation);
            if (strategy != null) {
                String transformedSubstring = strategy.transform(substring);
                funnyString.append("(").append(transformedSubstring).append(")");
            } else {
                funnyString.append("(").append(substring).append(")"); // Fallback in case the strategy is not found
            }

            // Update the current index
            currentIndex = endIndex + 1;
           }

        // Append the remaining substring (if any)
        funnyString.append(boringString, currentIndex, boringString.length());

        return funnyString.toString();
    }
}
