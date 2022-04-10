package Labs;
import java.util.Scanner;
import java.util.*;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        //First lines are for the first matrix
        char[][] firstMatrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] rowData = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                firstMatrix[row][col] = rowData[col].charAt(0);
            }
        }

        //Second lines are for the second matrix
        char[][] secondMatrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] rowData = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                secondMatrix[row][col] = rowData[col].charAt(0);
            }
        }

        //iterate them simultaneously
        //if the elements are the same -> print them , else put a "*"
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(firstMatrix[row][col] == secondMatrix[row][col]){
                    System.out.print(firstMatrix[row][col] +" ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
