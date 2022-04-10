package Exercise;
import java.util.Scanner;
import java.util.*;

public class MaximalSum {
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
        int sum = 0;
        int maximumSum = 0;

        int[][] matrix3x3 = new int[3][3];

        for (int row = 0; row < rows-2; row++) {
            for (int col = 0; col < columns-2; col++) {
                sum = matrix[row][col] + matrix[row][col+1] + matrix[row][col+2] + matrix[row+1][col] + matrix[row+1][col+1] + matrix[row+1][col+2] + matrix[row+2][col] + matrix[row+2][col+1] + matrix[row+2][col+2]   ;
                if(sum>maximumSum){
                    maximumSum=sum;
                    matrix3x3[0][0] = matrix[row][col];
                    matrix3x3[0][1] = matrix[row][col+1];
                    matrix3x3[0][2] = matrix[row][col+2];
                    matrix3x3[1][0] = matrix[row+1][col];
                    matrix3x3[1][1] = matrix[row+1][col+1];
                    matrix3x3[1][2] = matrix[row+1][col+2];
                    matrix3x3[2][0] = matrix[row+2][col];
                    matrix3x3[2][1] = matrix[row+2][col+1];
                    matrix3x3[2][2] = matrix[row+2][col+2];
                }
            }
        }
        System.out.println("Sum = "+ maximumSum);
        for (int row = 0; row < 3; row++) {
            for (int cols = 0; cols < 3; cols++) {
                System.out.print(matrix3x3[row][cols] + " ");
            }
            System.out.println();
        }


    }
}

