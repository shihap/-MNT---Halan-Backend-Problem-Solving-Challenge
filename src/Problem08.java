import java.util.HashSet;
import java.util.Set;

public class Problem08 {

    // function to find the index of the first duplicate element
    public static int index_of_first_duplicate(int[] arr) {

        Set<Integer> uniqueNumbers = new HashSet<>(); // Set to store unique numbers

        // loop at the array
        for (int i = 0; i < arr.length; i++) {

            // add the current number to the set
            uniqueNumbers.add(arr[i]);

            // if the size of the set has not increased, then it's a duplicate
            if (uniqueNumbers.size() != i + 1) {
                return i; // return the index of the duplicate
            }
        }

        return -1; // return -1 if no duplicates found
    }

    public static void main(String[] args) {

        // test cases
        assert index_of_first_duplicate(new int[]{5, 17, 3, 17, 4, -1}) == 3 : "Test 1 failed"; // duplicate : 17
        assert index_of_first_duplicate(new int[]{1, 2, 3, 4, 2, 5}) == 4 : "Test 2 failed"; // duplicate : 2
        assert index_of_first_duplicate(new int[]{1, 2, 3, 1}) == 3 : "Test 3 failed"; // duplicate : 1
        assert index_of_first_duplicate(new int[]{1, 2, 3}) == -1 : "Test 4 failed"; //  duplicate : non
        assert index_of_first_duplicate(new int[]{5, 6, 7, 8, 5, 6}) == 4 : "Test 5 failed"; // duplicate : 5
        assert index_of_first_duplicate(new int[]{1}) == -1 : "Test 6 failed"; // duplicate : non
        assert index_of_first_duplicate(new int[]{}) == -1 : "Test 7 failed"; // duplicate : non

        // if all tests pass
        System.out.println("All tests passed!");
    }
}
