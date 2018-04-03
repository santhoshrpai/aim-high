package interview.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rajasan
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        int row = matrix.length;
        int col = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        int rowBegin = 0;
        int rowEnd = row - 1;
        int colBegin = 0;
        int colEnd = col - 1;

        int i, j;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (j = colBegin; j <= colEnd; j++) {
                result.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            for (i = rowBegin; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            for (j = colEnd; j >= colBegin; j--) {
                result.add(matrix[rowEnd][j]);
            }

            rowEnd--;

            for (i = rowEnd; i >= rowBegin; i--) {
                result.add(matrix[i][colBegin]);
            }
            colBegin++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] m = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        int[][] m1 = {{2,3}};

        List<Integer> x = spiralOrder(m1);

        for (Integer n : x) {
            System.out.print(n + ", ");
        }

    }

}
