import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FormulaOne_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        int numberOfTurns = Integer.parseInt(scanner.nextLine());

        int rows = sizeOfMatrix;
        int columns = sizeOfMatrix;

        char[][] matrix = new char[rows][columns];
        matrix = fillMatrix(rows, columns, scanner);

        List<Integer> positionOfPlayer = positionOfPlayer(matrix, rows, columns);
        int playerRow = positionOfPlayer.get(0);
        int playerCol = positionOfPlayer.get(1);
        matrix[playerRow][playerCol] = '.';

        boolean gameOver = false;
        boolean isPlayed = false;

        for (int i = 0; i < numberOfTurns ; i++) {
            String command = scanner.nextLine();
            positionOfPlayer = forwardMovement(command,playerRow,playerCol,matrix,positionOfPlayer);
            playerRow = positionOfPlayer.get(0);
            playerCol = positionOfPlayer.get(1);

            if(playerRow>matrix.length-1 || playerCol>matrix.length-1 || playerRow<0 || playerCol<0){
                gameOver=true;
                break;
            }
            if(matrix[playerRow][playerCol]=='F'){
                matrix[playerRow][playerCol] = '.';
                System.out.printf("Well done, the player won first place!%n");
                isPlayed = true;
                break;
            }else if(matrix[playerRow][playerCol]=='B'){
                //matrix[playerRow][playerCol] = '.';
                positionOfPlayer = forwardMovement(command,playerRow,playerCol,matrix,positionOfPlayer);
                playerRow = positionOfPlayer.get(0);
                playerCol = positionOfPlayer.get(1);
            } else if(matrix[playerRow][playerCol]=='T'){
                positionOfPlayer = stepBack(command,playerRow,playerCol,matrix,positionOfPlayer);
                playerRow = positionOfPlayer.get(0);
                playerCol = positionOfPlayer.get(1);
                matrix[playerRow][playerCol] = '.';
            } else{
                matrix[playerRow][playerCol]='.';
            }
        }

        matrix[playerRow][playerCol] = 'P';
        if(!isPlayed){
            System.out.printf("Oh no, the player got lost on the track!%n");
        }
        printMatrix(matrix,rows);
    }

    private static char[][] fillMatrix(int rows, int cols, Scanner scan) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = scan.nextLine().split("");
            for (int col = 0; col < matrix[row].length; col++) {
                char currentChar = line[col].charAt(0);
                matrix[row][col] = currentChar;
            }
        }
        return matrix;
    }

    private static List<Integer> positionOfPlayer(char[][] neighbourhood, int rows, int cols) {
        List<Integer> currentPosition = new ArrayList<>();
        char charToCheck = 'P';
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char currentChar = neighbourhood[row][col];
                if (currentChar == charToCheck) {
                    currentPosition.add(row);
                    currentPosition.add(col);
                }
            }
            System.out.println();
        }
        return currentPosition;
    }

    private static List<Integer> forwardMovement(String command, int playerRow, int playerCol, char[][] matrix, List<Integer> positions){
        switch (command) {
            case "up":
                if(playerRow-1>=0){
                    playerRow--;
                }else{
                    playerRow = matrix.length-1;
                }
                break;
            case "down":
                if(playerRow+1< matrix.length){
                    playerRow++;
                }else{
                    playerRow=0;
                }
                break;
            case "left":
                if (playerCol - 1 >= 0)
                {
                    playerCol--;
                }
                else
                {
                    playerCol = matrix.length - 1;
                }
                break;
            case "right":
                if (playerCol + 1 < matrix.length)
                {
                    playerCol++;
                }
                else
                {
                    playerCol = 0;
                }
                break;
        }
        positions.set(0,playerRow);
        positions.set(1,playerCol);
        return positions;
    }

    private static void printMatrix(char[][] squareMatrix, int rows) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < squareMatrix[row].length; col++) {
                System.out.print(squareMatrix[row][col]);
            }
            System.out.println();
        }
    }

    private static List<Integer> stepBack(String command, int playerRow, int playerCol, char[][] matrix, List<Integer> positions){
        switch (command) {
            case "up":
                if(playerRow+1< matrix.length){
                    playerRow++;
                }else{
                    playerRow=0;
                }
                break;
            case "down":
                //Go up
                if(playerRow-1>=0){
                    playerRow--;
                }else{
                    playerRow = matrix.length-1;
                }
                break;
            case "left":
                if (playerCol + 1 < matrix.length)
                {
                    playerCol++;
                }
                else
                {
                    playerCol = 0;
                }
                break;
            case "right":
                if (playerCol - 1 >= 0)
                {
                    playerCol--;
                }
                else
                {
                    playerCol = matrix.length - 1;
                }
                break;
        }

        positions.set(0,playerRow);
        positions.set(1,playerCol);
        return positions;
    }


}
