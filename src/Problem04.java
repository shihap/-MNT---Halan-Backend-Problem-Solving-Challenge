import java.util.Objects;
import java.util.function.Function;

public class Problem04 {

    // function to compose two one-argument functions
    // <T, A, B> -> templates used
    // Function<inputType ,outputType>
    public static <T, A, B> Function<T, B> compose(Function <A, B> f, Function <T, A> g) {
        return (T x) -> f.apply(g.apply(x)); // apply g then f
    }

    public static void main(String[] args) {

        // increment function
        Function<Integer, Integer> inc = (x) -> x + 1;

        // square function
        Function<Integer, Integer> square = (x) -> x * x;

        // Compose the functions
        var h = compose(square, inc); // apply inc then square

        // test cases
        assert Objects.equals(h.apply(6), 49) : "Test failed for input 6"; // (6 + 1) ^ 2 = 49
        assert Objects.equals(h.apply(0), 1) : "Test failed for input 0"; // (0 + 1) ^ 2 = 1
        assert Objects.equals(h.apply(-2), 1) : "Test failed for input -2"; // (-2 + 1) ^ 2 = 1
        assert Objects.equals(h.apply(10), 121) : "Test failed for input 10"; // (10 + 1) ^ 2 = 121
        assert Objects.equals(h.apply(3), 16) : "Test failed for input 3"; // (3 + 1) ^ 2 = 16

        // If all test cases passed
        System.out.println("All tests passed!");
    }
}
