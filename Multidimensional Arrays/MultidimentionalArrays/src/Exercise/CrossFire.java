package Exercise;
import java.util.Scanner;
import java.util.*;

public class CrossFire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimension = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);
        String[][] matrix = new String[rows][cols];

        int nextNumber = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = String.valueOf(nextNumber);
                nextNumber++;
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")){
            String[] commandLine = command.split("\\s+");
            int selectedRow = Integer.parseInt(commandLine[0]);
            int selectedCol = Integer.parseInt(commandLine[1]);

            int radius = Integer.parseInt(commandLine[2]);
            if (selectedRow < matrix.length && selectedRow >= 0 && selectedCol < matrix[selectedRow].length && selectedCol >= 0){
                matrix[selectedRow][selectedCol] = null;
            }
            for (int currentNuke = 1; currentNuke <= radius; currentNuke++) {
                if (selectedRow - currentNuke < matrix.length && selectedRow - currentNuke >= 0 && selectedCol < matrix[selectedRow - currentNuke].length && selectedCol >= 0){
                    matrix[selectedRow - currentNuke][selectedCol] = null;

                }
                if (selectedRow + currentNuke < matrix.length && selectedRow + currentNuke >= 0 && selectedCol < matrix[selectedRow + currentNuke].length && selectedCol >= 0){
                    matrix[selectedRow + currentNuke][selectedCol] = null;

                }
                if (selectedRow < matrix.length && selectedRow >= 0 && selectedCol - currentNuke < matrix[selectedRow].length && selectedCol - currentNuke >= 0){
                    matrix[selectedRow][selectedCol - currentNuke] = null;
                }
                if (selectedRow < matrix.length && selectedRow >= 0 && selectedCol + currentNuke < matrix[selectedRow].length && selectedCol + currentNuke >= 0){
                    matrix[selectedRow][selectedCol + currentNuke] = null;
                }
            }

            for (int row = 0; row < matrix.length; row++) {
                matrix[row] = Arrays.stream(matrix[row]).filter(value -> value != null).toArray(size -> new String[size]);

            }
            //проверяваме колко празни реда имаме
            int count = 0;
            for (int i = 0; i < matrix.length ; i++) {
                if (matrix[i].length == 0){
                    count++;
                }
            }
            //създаваме нова временна матрица ,в която да съхраним САМО редовете, които не са празни!
            String[][] resultMatrix = new String[matrix.length - count][];

            int counter = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i].length != 0){
                    resultMatrix[counter] = matrix[i];
                    counter++;
                }
            }
            //презаписваме матрицата без празните редове
            matrix = resultMatrix;



            command = scanner.nextLine();
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length ; col++) {
                System.out.print(matrix[row][col] + " ");

            }
            if (matrix[row].length > 0){
                System.out.println();
            }

        }
        System.out.println();
    }

}



