public class Problem01 {

    // function to check if a string is a palindrome
    public static boolean isPalindrome(String str) {

        // convert str to lowercase and remove any spaces from it
        str = str.toLowerCase().replaceAll("\\s+", "");

        // will use two pointers
        int left = 0; // left that points to the first letter in str
        int right = str.length() - 1; // right that points to the last letter in str

        // iterate until the left index is less than or equal to right index
        while (left <= right) {
            // if the characters at the left and right pointers are not equal, it's not a palindrome
            if (str.charAt(left) != str.charAt(right)) return false;

            // move the left index to the next character in str
            left++;
            // move the right index to the previous character in str
            right--;
        }

        // if all characters matched, str is a palindrome
        return true;
    }

    // main method to run test cases with expected results
    public static void main(String[] args) {

        assert isPalindrome("anna") == true : "Test failed for 'anna'";
        assert isPalindrome("Apple") == false : "Test failed for 'Apple'";
        assert isPalindrome("level") == true : "Test failed for 'level'";
        assert isPalindrome("rotator") == true : "Test failed for 'rotator'";
        assert isPalindrome("noon") == true : "Test failed for 'noon'";
        assert isPalindrome("example") == false : "Test failed for 'example'";
        assert isPalindrome("") == true : "Test failed for empty string";
        assert isPalindrome("A man a plan a canal Panama") == true : "Test failed for 'A man a plan a canal Panama'";
        assert isPalindrome("Was it a car or a cat I saw") == true : "Test failed for 'Was it a car or a cat I saw'";

        // if all test cases passed
        System.out.println("All tests passed!");
    }
}
