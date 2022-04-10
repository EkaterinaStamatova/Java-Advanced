package Labs;
import java.util.Scanner;
import java.util.*;

public class SumMatrixElements_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // read the size of the matrix
        String[] sizeOfMatrix = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(sizeOfMatrix[0]);
        int columns = Integer.parseInt(sizeOfMatrix[1]);
        int[][] matrix = new int[rows][columns];

        // read the matrix
        for (int row = 0; row < rows; row++) {
            String[] rowOfMatrix = scanner.nextLine().split(", ");
            for (int col = 0; col < columns; col++) {
                matrix[row][col] = Integer.parseInt(rowOfMatrix[col]);
            }
        }
        // sum the elements of the matrix
        int sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                sum = sum + matrix[row][col];
            }
        }

        // print
        System.out.println(rows);
        System.out.println(columns);
        System.out.println(sum);

    }
}
