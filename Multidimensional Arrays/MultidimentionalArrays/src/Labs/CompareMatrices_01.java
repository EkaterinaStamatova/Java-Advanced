package Labs;
import java.util.Scanner;
import java.util.*;

public class CompareMatrices_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // read the size for the first Matrix
        String[] sizeOfMatrix = scanner.nextLine().split(" ");
        int firstMatrixRows = Integer.parseInt(sizeOfMatrix[0]);
        int firstMatrixColumns = Integer.parseInt(sizeOfMatrix[1]);
        int[][] firstMatrix = new int[firstMatrixRows][firstMatrixColumns];

        // read the matrix
        for (int row = 0; row < firstMatrixRows; row++) {
            int[] rowOfMatrix = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            firstMatrix[row] = rowOfMatrix;
        }

        // read the size of the second Matrix
        String[] sizeOfMatrixTwo = scanner.nextLine().split(" ");
        int secondMatrixRows = Integer.parseInt(sizeOfMatrixTwo[0]);
        int secondMatrixColumns = Integer.parseInt(sizeOfMatrixTwo[1]);
        int[][] secondMatrix = new int[secondMatrixRows][secondMatrixColumns];

        // read the matrix
        for (int row = 0; row < secondMatrixRows; row++) {
            int[] rowOfMatrix = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            secondMatrix[row] = rowOfMatrix;
        }

        if(firstMatrixRows!= secondMatrixRows || firstMatrixColumns!=secondMatrixColumns){
            System.out.println("not equal");
            return;
        }

        for (int row = 0; row < firstMatrixRows; row++) {
            for (int col = 0; col < secondMatrixColumns; col++) {
                if (firstMatrix[row][col] !=
                        secondMatrix[row][col]) {
                    System.out.println("not equal");
                    return;
                }
            }
        }

        System.out.println("equal");
    }

}
