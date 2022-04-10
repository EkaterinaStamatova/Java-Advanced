package Exercise;
import java.util.Scanner;
import java.util.*;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // initialize the size of our matrix

        String[] sizeOfMatrix = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(sizeOfMatrix[0]);
        int columns = rows;

        // create the matrix
        int[][] matrix = new int[rows][columns];

        // read the matrix
        for (int row = 0; row < rows; row++) {
            int[] rowOfMatrix = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = rowOfMatrix;
        }

        // loop for primary diagonal
        int sumOfPrimaryDiagonal = 0;
        for (int row = 0; row < rows; row++) {
            for (int cols = 0; cols < columns; cols++) {
                if(row==cols){
                    sumOfPrimaryDiagonal += matrix[row][cols];
                }
            }
        }

        int counter = 0;
        int sumOfSecondaryDiagonal = 0;
        // loop for second diagonal
        for (int row = rows-1; row >= 0; row--) {
            for (int cols = 0; cols < columns; cols++) {
                if(row==cols){
                    sumOfSecondaryDiagonal += matrix[counter][cols];
                }
            }
            counter++;
        }

        int difference = Math.abs(sumOfPrimaryDiagonal-sumOfSecondaryDiagonal);
        System.out.println(difference);
    }
}

