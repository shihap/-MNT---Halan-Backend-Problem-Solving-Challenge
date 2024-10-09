import java.util.Arrays;

public class Problem06 {

    // function to transpose a matrix
    public static int[][] transpose(int[][] matrix) {

        // handle empty matrix case
        if (matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }

        // get the rows and cols of the inputted matrix
        int rows = matrix.length;
        int cols = matrix[0].length;

        // the transposed matrix rows and cols are the inverse of the inputted matrix
        int[][] transposedMatrix = new int[cols][rows];

        // fill the transposed matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        // return the new transposed matrix
        return transposedMatrix;
    }

    public static void main(String[] args) {

        // test cases
        assert Arrays.deepEquals(transpose(new int[][]{{1, 2}, {3, 4}}), new int[][]{{1, 3}, {2, 4}}) : "Test 1 failed"; // expected output: [[1, 3], [2, 4]]
        assert Arrays.deepEquals(transpose(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}}), new int[][]{{1, 5}, {2, 6}, {3, 7}, {4, 8}}) : "Test 2 failed"; // expected output: [[1, 5], [2, 6], [3, 7], [4, 8]]
        assert Arrays.deepEquals(transpose(new int[0][0]), new int[0][0]) : "Test 3 failed"; // expected output: []
        assert Arrays.deepEquals(transpose(new int[][]{{5}}), new int[][]{{5}}) : "Test 4 failed"; // expected output: [[5]]

        // if all tests pass
        System.out.println("All tests passed!");
    }
}
