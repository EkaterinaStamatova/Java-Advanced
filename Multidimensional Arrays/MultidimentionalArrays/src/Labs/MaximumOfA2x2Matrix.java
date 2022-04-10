package Labs;
import java.util.Scanner;
import java.util.*;

public class MaximumOfA2x2Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sizeOfMatrix = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(sizeOfMatrix[0]);
        int columns = Integer.parseInt(sizeOfMatrix[1]);
        //First lines are for the first matrix
        int[][] matrix = new int[rows][columns];

        // read the matrix
        for (int row = 0; row < rows; row++) {
            int[] rowOfMatrix = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = rowOfMatrix;
        }
        int sum = 0;
        int maximumSum = 0;

        int[][] matrix2x2 = new int[2][2];

        for (int row = 0; row < rows-1; row++) {
            for (int col = 0; col < columns-1; col++) {
                sum = matrix[row][col] + matrix[row][col+1] + matrix[row+1][col] + matrix[row+1][col+1];
                if(sum>maximumSum){
                    maximumSum=sum;
                    matrix2x2[0][0] = matrix[row][col];
                    matrix2x2[0][1] = matrix[row][col+1];
                    matrix2x2[1][0] = matrix[row+1][col];
                    matrix2x2[1][1] = matrix[row+1][col+1];
                }
            }
        }

        for (int row = 0; row < 2; row++) {
            for (int cols = 0; cols < 2; cols++) {
                System.out.print(matrix2x2[row][cols] + " ");
            }
            System.out.println();
        }

        System.out.println(maximumSum);
    }
}
