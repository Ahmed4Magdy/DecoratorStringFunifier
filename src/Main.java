import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the boring string from the user
        System.out.println("Enter the boring string:");
        String boringString = scanner.nextLine();

        // Get the number of ranges
        System.out.println("Enter the number of ranges:");
        int numRanges = scanner.nextInt();

        List<Integer> startIndexes = new ArrayList<>();
        List<Integer> endIndexes = new ArrayList<>();
        List<String> funOperations = new ArrayList<>();

        // Get the start and end indexes for each range
        for (int i = 0; i < numRanges; i++) {
            System.out.print("Enter start index for range " + (i + 1) + ":");
            startIndexes.add(scanner.nextInt());
        }

        for (int i = 0; i < numRanges; i++) {
            System.out.print("Enter end index for range " + (i + 1) + ":");
            endIndexes.add(scanner.nextInt());
        }

        // Get the operations for each range
        for (int i = 0; i < numRanges; i++) {
            System.out.println("Enter operation for range " + (i + 1) + " (REVERSE, UPPERCASE, LOWERCASE, SORT, COMPRESSION):");
            funOperations.add(scanner.next());
        }

        // Set up transformation strategies
        Map<String, TransformationStrategy> transformationStrategies = new HashMap<>();
        transformationStrategies.put("REVERSE", new ReverseTransformation(new CompressionTransformation(new Base())));
        transformationStrategies.put("UPPERCASE", new UppercaseTransformation(new Base()));
        transformationStrategies.put("LOWERCASE", new SortTransformation(new UppercaseTransformation(new CompressionTransformation(new Base()))));
        transformationStrategies.put("SORT", new CompressionTransformation(new Base()));
        transformationStrategies.put("COMPRESSION", new ReverseTransformation(new UppercaseTransformation(new CompressionTransformation(new Base()))));

        // Inject dependencies into StringFunifier
        StringFunifierDI funifier = new StringFunifierDI(boringString, startIndexes, endIndexes, funOperations, transformationStrategies);
        System.out.println("Resulting funny string: " + funifier.getFunnyString());
    }
}
