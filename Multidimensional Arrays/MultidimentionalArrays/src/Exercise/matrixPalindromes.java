package Exercise;
import java.util.Scanner;
import java.util.*;

public class matrixPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // read the size of the matrix
        String[] sizeOfMatrix = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(sizeOfMatrix[0]);
        int columns = Integer.parseInt(sizeOfMatrix[1]);

        // create the matrix
        String[][] matrix = new String[rows][columns];
        char startLetter = 'a';

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                String palindrome = "" + startLetter+ (char)(startLetter+col)+startLetter;
                matrix[row][col] = palindrome;
            }
            startLetter = (char) (startLetter+1);
        }
        printMatrix(matrix, rows, columns);
    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
