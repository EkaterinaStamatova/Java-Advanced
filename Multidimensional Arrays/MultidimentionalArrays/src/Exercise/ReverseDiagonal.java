package Exercise;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;
import java.util.*;

public class ReverseDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sizeOfMatrix = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(sizeOfMatrix[0]);
        int columns = Integer.parseInt(sizeOfMatrix[1]);
        //First lines are for the first matrix
        int[][] matrix = new int[rows][columns];

        // read the matrix
        for (int row = 0; row < rows; row++) {
            int[] rowOfMatrix = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = rowOfMatrix;
        }
        int row = rows - 1;
        int col = columns - 1;

        while (row != -1) {
            int r = row;
            int c = col;
            while (c < columns && r >= 0) {
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            col--;
            if (col == -1) {
                col = 0;
                row--;
            }
        }
    }
}
