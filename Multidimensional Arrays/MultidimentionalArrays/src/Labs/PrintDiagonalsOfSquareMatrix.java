package Labs;
import java.util.Scanner;
import java.util.*;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sizeOfMatrix = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(sizeOfMatrix[0]);
        int columns = rows;
        //First lines are for the first matrix
        int[][] matrix = new int[rows][columns];

        // read the matrix
        for (int row = 0; row < rows; row++) {
            int[] rowOfMatrix = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = rowOfMatrix;
        }

        for (int row = 0; row < rows; row++) {
            for (int cols = 0; cols < columns; cols++) {
                if(row==cols){
                    System.out.print(matrix[row][cols]+" ");

                }
            }
        }
        System.out.println();
        int counter = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int row = rows-1; row >= 0; row--) {

            for (int cols = 0; cols < columns; cols++) {
                if(row==cols){
                    stack.push(matrix[counter][cols]);
                }
            }
            counter++;
        }
        int sizeOfStack = stack.size();
        for (int i = 0; i < sizeOfStack; i++) {
            System.out.print(stack.pop() + " ");
        }

    }
}
