package JavaExam26June2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Python_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pythonLength = 1;

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");

        int rows = sizeOfMatrix;
        int columns = sizeOfMatrix;

        char[][] matrix = new char[rows][columns];
        matrix = fillMatrix(rows, columns, scanner);

        List<Integer> positionOfPlayer = positionOfSnake(matrix, rows, columns);
        int playerRow = positionOfPlayer.get(0);
        int playerCol = positionOfPlayer.get(1);
        matrix[playerRow][playerCol] = '*';

        boolean gameOver = false;
        boolean enemy = false;
        boolean eatenAll = false;

        int food = foodInField(matrix,rows,columns);

        for(int i = 0; i<commands.length; i++){
            positionOfPlayer = forwardMovement(commands[i],playerRow,playerCol,matrix,positionOfPlayer);
            playerRow = positionOfPlayer.get(0);
            playerCol = positionOfPlayer.get(1);

            if(playerRow>matrix.length-1 || playerCol>matrix.length-1 || playerRow<0 || playerCol<0){
                gameOver=true;
                break;
            }

            if(matrix[playerRow][playerCol]=='f'){
                pythonLength++;
                food--;
                matrix[playerRow][playerCol] = '*';
                if(food==0){
                    eatenAll = true;
                    System.out.printf("You win! Final python length is %d%n", pythonLength);
                    break;
                }
            }else if(matrix[playerRow][playerCol]=='e'){
                matrix[playerRow][playerCol] = '*';
                enemy = true;
                System.out.printf("You lose! Killed by an enemy!");
                break;
            }else{
                matrix[playerRow][playerCol]='*';
            }
        }
        if(!enemy && !eatenAll){
            System.out.printf("You lose! There is still %d food to be eaten.", food);
        }

    }

    private static char[][] fillMatrix(int rows, int cols, Scanner scan) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = scan.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                char currentChar = line[col].charAt(0);
                matrix[row][col] = currentChar;
            }
        }
        return matrix;
    }

    private static List<Integer> positionOfSnake(char[][] neighbourhood, int rows, int cols) {
        List<Integer> currentPosition = new ArrayList<>();
        char charToCheck = 's';
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

    private static int foodInField(char[][] matrix, int rows, int cols){
        char charToCheck = 'f';
        int foodCount = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char currentChar = matrix[row][col];
                if (currentChar == charToCheck) {
                    foodCount++;
                }
            }
            System.out.println();
        }
        return foodCount;
    }


}
