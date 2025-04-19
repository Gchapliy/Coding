package leetcode;

public class RotateImage {
    public static void main(String[] args) {
        rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    public static void rotate(int[][] matrix) {
        for (int i = 0, j = matrix.length - 1; i < j; ++i, --j) {
            int[] temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
        }

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = i + 1; j < matrix.length; ++j) {
                final int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if(j < matrix[i].length - 1) System.out.print(", ");
            }
            System.out.print(" ]");
            System.out.println();
        }
    }
}
