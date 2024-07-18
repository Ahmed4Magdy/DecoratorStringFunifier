import java.util.*;

public interface TransformationStrategy {
    String transform(String str);
}

 class ReverseTransformation extends DecoratorString {

     private List<String> funOperations;

     public ReverseTransformation(TransformationStrategy transformationstrategy) {
         super(transformationstrategy);
     }

     @Override
    public String transform(String str) {
         str=super.transform(str);
        return new StringBuilder(str).reverse().toString();
    }
}


 class UppercaseTransformation extends DecoratorString {
     private List<String> funOperations;

     public UppercaseTransformation(TransformationStrategy transformationstrategy) {
         super(transformationstrategy);
     }

     @Override
    public String transform(String str) {
         str=super.transform(str);
        return str.toUpperCase();
    }
}


  class LowercaseTransformation extends DecoratorString {
    private List<String> funOperations;

      public LowercaseTransformation(TransformationStrategy transformationstrategy) {
          super(transformationstrategy);
      }

      @Override
    public String transform(String str) {
          str=super.transform(str);
        return str.toLowerCase();
    }
}


class SortTransformation extends DecoratorString {
    private List<String> funOperations;

    public SortTransformation(TransformationStrategy transformationstrategy) {
        super(transformationstrategy);
    }

    @Override
    public String transform(String str) {
        str=super.transform(str);
        List<Character> charList = new ArrayList<>();
        for (char c : str.toCharArray()) {
            charList.add(c);
        }
        Collections.sort(charList);
        StringBuilder sortedString = new StringBuilder();
        for (char c : charList) {
            sortedString.append(c);
        }

        return sortedString.toString();
    }

}

class CompressionTransformation extends DecoratorString {

    private List<String> funOperations;

    public CompressionTransformation(TransformationStrategy transformationstrategy) {
        super(transformationstrategy);
    }

    @Override
    public String transform(String str) {
        str=super.transform(str);
        StringBuilder compressed = new StringBuilder();
        char currentChar = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == currentChar) {
                count++;
            } else {
                compressed.append(currentChar).append(count);
                currentChar = str.charAt(i);
                count = 1;
            }
        }

        compressed.append(currentChar).append(count);
        return compressed.toString();
    }

     class Base implements TransformationStrategy{


        @Override
        public String transform(String str) {

            return str;
        }
    }

}
