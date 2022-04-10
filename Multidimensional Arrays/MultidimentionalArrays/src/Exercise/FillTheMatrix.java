package Exercise;
import java.util.Scanner;
import java.util.*;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // read the size of the matrix
        String[] sizeOfMatrix = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(sizeOfMatrix[0]);
        int columns = rows;
        int[][] matrix = new int[rows][columns];
        char ch = sizeOfMatrix[1].charAt(0);

        if(ch == "A".charAt(0)){
            matrix=patternA(rows);
        }else if(ch == "B".charAt(0)){
            matrix=patternB(rows);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] patternA(int rows){
        int[][] matrix = new int[rows][rows];
        int columnFill = 1;

        for (int row = 0; row < rows; row++) {
            columnFill = row;
            for (int col = 0; col < rows; col++) {
                columnFill+=1;
                matrix[row][col] = columnFill;
                columnFill+=rows-1;
            }

        }
        return matrix;
    }

    private static int[][] patternB(int rows) {
        int[][] matrix = new int[rows][rows];
        int startNumber = 1;
        //четна колона -> редове от 0 до последния
        //нечетна колона -> редове от последния към 0
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = startNumber;
                    startNumber++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = startNumber;
                    startNumber++;
                }
            }
        }
        return matrix;
    }
}