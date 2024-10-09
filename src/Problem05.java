import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem05 {

    public static String[] unique(String[] inputArray) {

        List<String> sortedInput = new ArrayList<>(Arrays.asList(inputArray)); // take the inputArray to arrayList to sort it
        List<String> uniqueElements = new ArrayList<>(); // the arrayList that will contain the unique strings

        Collections.sort(sortedInput); // sort the input arrayList

        int i = 0; // iterator over the sorted arrayList
        int counts; // the counts of the string in the arrayList

        while (i < sortedInput.size()) {
            String currentString = sortedInput.get(i); // current string in the sorted arrayList
            counts = 1;

            // count how many times the current element repeats
            while (i + counts < sortedInput.size() && sortedInput.get(i + counts).equals(currentString)) {
                counts++;
            }

            if (counts == 1) { // if the element is unique
                uniqueElements.add(currentString); // add to the unique arraylist
            }

            i += counts; // skip over repeated elements
        }

        return uniqueElements.toArray(new String[0]); // return unique elements as array
    }


    public static void main(String[] args) {

        // test cases
        assert Arrays.equals(unique(new String[]{"apples", "oranges", "flowers", "apples"}), new String[]{"flowers", "oranges"}) : "Test 1 failed";
        assert Arrays.equals(unique(new String[]{"apples", "apples"}), new String[]{}) : "Test 2 failed";
        assert Arrays.equals(unique(new String[]{"banana", "apple", "banana", "kiwi"}), new String[]{"apple", "kiwi"}) : "Test 3 failed";
        assert Arrays.equals(unique(new String[]{"car", "bike", "car", "truck", "bike"}), new String[]{"truck"}) : "Test 4 failed";
        assert Arrays.equals(unique(new String[]{"apple"}), new String[]{"apple"}) : "Test 5 failed";

        // If all tests pass
        System.out.println("All tests passed!");
    }
}
