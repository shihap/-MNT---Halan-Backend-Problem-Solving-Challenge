import java.util.Objects;

public class Problem03 {

    // function to compress the string using run-length encoding
    public static String runLengthEncode(String str) {
        StringBuilder encodedStr = new StringBuilder(); // use StringBuilder for efficiency
        char currentChar = ' '; // initialize current character
        int currentCharCount = 0; // count of the current character

        for (int i = 0; i < str.length(); i++) { // looping at str characters
            if (str.charAt(i) != currentChar) { // found a new character
                if (currentCharCount > 0) // if not the first character
                    encodedStr.append(currentChar).append(currentCharCount); // append the previous character and its count
                currentChar = str.charAt(i); // update current character
                currentCharCount = 1; // reset the count for the new character
            } else { // same character as before
                currentCharCount++; // increment the count for the current character
            }
        }

        // append the last character and its count
        if (currentCharCount > 0)
            encodedStr.append(currentChar).append(currentCharCount);

        return encodedStr.toString(); // convert StringBuilder to String and return it
    }

    // function to decode a run-length encoded string
    public static String runLengthDecode(String str) {
        StringBuilder decodedStr = new StringBuilder(); // use StringBuilder for efficiency
        char currentChar = ' '; // current character being decoded
        StringBuilder currentCharCount = new StringBuilder(); // string to hold the count of current character
        int count ; // used for hold currentCharCount value as int

        for (int i = 0; i < str.length(); i++) { // looping at str characters
            if (Character.isDigit(str.charAt(i))) { // check if the character is a digit
                currentCharCount.append(str.charAt(i)); // accumulate digits
            } else {
                // decode the previous character and its count
                if (!currentCharCount.isEmpty()) {
                    count = Integer.parseInt(currentCharCount.toString()); // convert accumulated string to int
                    for (int j = 0; j < count; j++) { // for count times
                        decodedStr.append(currentChar); // append the character
                    }
                }
                currentChar = str.charAt(i); // update current character
                currentCharCount = new StringBuilder(); // reset the count for the new character
            }
        }

        // decode the last character and its count
        if (!currentCharCount.isEmpty()) {
            count = Integer.parseInt(currentCharCount.toString());
            for (int j = 0; j < count; j++) {
                decodedStr.append(currentChar);
            }
        }

        return decodedStr.toString(); // convert StringBuilder to String and return it
    }

    // main method to run test cases with expected results
    public static void main(String[] args) {
        // Test cases for encoding
        assert Objects.equals(runLengthEncode("aaaaaaaaaabbbaxxxxyyyzyx"), "a10b3a1x4y3z1y1x1") : "Test failed for 'aaaaaaaaaabbbaxxxxyyyzyx'";
        assert Objects.equals(runLengthEncode("abc"), "a1b1c1") : "Test failed for 'abc'";
        assert Objects.equals(runLengthEncode("a"), "a1") : "Test failed for 'a'";
        assert Objects.equals(runLengthEncode(""), "") : "Test failed for empty string";

        // Test cases for decoding
        assert Objects.equals(runLengthDecode("a10b3a1x4y3z1y1x1"), "aaaaaaaaaabbbaxxxxyyyzyx") : "Test failed for 'a10b3a1x4y3z1y1x1'";
        assert Objects.equals(runLengthDecode("a1b1c1"), "abc") : "Test failed for 'a1b1c1'";
        assert Objects.equals(runLengthDecode("a1"), "a") : "Test failed for 'a1'";
        assert Objects.equals(runLengthDecode(""), "") : "Test failed for empty string";

        // if all test cases passed
        System.out.println("All tests passed!");
    }
}
