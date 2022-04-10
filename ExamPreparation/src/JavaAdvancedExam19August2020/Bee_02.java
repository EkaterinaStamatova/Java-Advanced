package JavaAdvancedExam19August2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bee_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());

        int rows = sizeOfMatrix;
        int columns = sizeOfMatrix;

        char[][] matrix = new char[rows][columns];
        matrix = fillMatrix(rows, columns, scanner);

        List<Integer> positionOfPlayer = positionOfBee(matrix, rows, columns);
        int playerRow = positionOfPlayer.get(0);
        int playerCol = positionOfPlayer.get(1);
        matrix[playerRow][playerCol] = '.';

        boolean gameOver = false;
        boolean isPayed = false;

        int pollinatedFlowersCount = 0;

        String command = scanner.nextLine();
        while(!command.equals("End")){
            positionOfPlayer = forwardMovement(command,playerRow,playerCol,matrix,positionOfPlayer);
            playerRow = positionOfPlayer.get(0);
            playerCol = positionOfPlayer.get(1);

            if(playerRow>matrix.length-1 || playerCol>matrix.length-1 || playerRow<0 || playerCol<0){
                gameOver=true;
                break;
            }
            if(matrix[playerRow][playerCol]=='f'){
                pollinatedFlowersCount++;
                matrix[playerRow][playerCol]='.';
            }
            if(matrix[playerRow][playerCol]=='O'){
                matrix[playerRow][playerCol]='.';
                continue;
            }
            command = scanner.nextLine();
        }
        if(!gameOver){
            matrix[playerRow][playerCol] = 'B';
        }else{
            System.out.println("The bee got lost!");
        }

        if(pollinatedFlowersCount>=5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n",pollinatedFlowersCount);
        }else{
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n",5-pollinatedFlowersCount);
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
    private static List<Integer> positionOfBee(char[][] neighbourhood, int rows, int cols) {
        List<Integer> currentPosition = new ArrayList<>();
        char charToCheck = 'B';
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

    private static void printMatrix(char[][] squareMatrix, int rows) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < squareMatrix[row].length; col++) {
                System.out.print(squareMatrix[row][col]);
            }
            System.out.println();
        }
    }

}

