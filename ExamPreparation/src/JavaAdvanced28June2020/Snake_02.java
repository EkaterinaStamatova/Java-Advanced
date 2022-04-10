package JavaAdvanced28June2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snake_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());

        int rows = sizeOfMatrix;
        int columns = sizeOfMatrix;

        boolean isFed = false;
        boolean gameOver = false;

        int eatenPiecesCounter = 0;

        char[][] matrix = new char[rows][columns];
        matrix = fillMatrix(rows, columns, scanner);

        List<Integer> positionOfPlayer = positionOfSnake(matrix, rows, columns);
        int playerRow = positionOfPlayer.get(0);
        int playerCol = positionOfPlayer.get(1);
        matrix[playerRow][playerCol] = '.';

        String command = scanner.nextLine();
        while(true){

            positionOfPlayer = forwardMovement(command,playerRow,playerCol,matrix,positionOfPlayer);
            playerRow = positionOfPlayer.get(0);
            playerCol = positionOfPlayer.get(1);

            if(playerRow>matrix.length-1 || playerCol>matrix.length-1 || playerRow<0 || playerCol<0){
                gameOver=true;
                break;
            }

            if(matrix[playerRow][playerCol]=='*'){
                eatenPiecesCounter++;
                matrix[playerRow][playerCol] = '.';
            }else if(matrix[playerRow][playerCol]=='B'){
                matrix[playerRow][playerCol] = '.';
                List<Integer> positionOfOtherB = findBurrow(matrix,rows,columns);
                if(!positionOfOtherB.isEmpty()){
                    playerRow=positionOfOtherB.get(0);
                    playerCol=positionOfOtherB.get(1);
                }
            }else{
                matrix[playerRow][playerCol]='.';
            }
            if(eatenPiecesCounter>=10){
                isFed=true;
                break;
            }
            command = scanner.nextLine();
        }

        if(!gameOver){
            matrix[playerRow][playerCol] = 'S';
        }

        if(isFed){
            System.out.println("You won! You fed the snake.");
        }else{
            System.out.println("Game over!");
        }
        System.out.printf("Food eaten: %d%n", eatenPiecesCounter);
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

    private static List<Integer> positionOfSnake(char[][] neighbourhood, int rows, int cols) {
        List<Integer> currentPosition = new ArrayList<>();
        char charToCheck = 'S';
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
                    playerRow--;
                break;
            case "down":
                    playerRow++;
                break;
            case "left":
                    playerCol--;
                break;
            case "right":
                    playerCol++;
                break;
        }
        positions.set(0,playerRow);
        positions.set(1,playerCol);
        return positions;
    }

    private static List<Integer> findBurrow(char[][] field, int rows, int cols){
        List<Integer> positionOfBurrow = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if(field[row][col]=='B'){
                    positionOfBurrow.add(row);
                    positionOfBurrow.add(col);
                    field[row][col] = '.';
                }
            }
        }

        return positionOfBurrow;
    }

    private static void printMatrix(char[][] squareMatrix, int rows) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < squareMatrix[row].length; col++) {
                System.out.print(squareMatrix[row][col]);
            }
            System.out.println();
        }
    }

}