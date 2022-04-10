package JavaAdvancedRetakeExam17Dec2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PresentDelivery_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfPresents = Integer.parseInt(scanner.nextLine());
        int sizeOfNeighborhood = Integer.parseInt(scanner.nextLine());

        int rows = sizeOfNeighborhood;
        int columns = sizeOfNeighborhood;
        char[][] neighborhood = new char[rows][columns];

        int happyNiceKidsCounter = 0;

        neighborhood = fillMatrix(rows, columns, scanner);
        int niceKids = niceKidsCount(neighborhood, rows);
        List<Integer> positionOfSanta = positionOfSanta(neighborhood, rows, columns);
        int rowOfSanta = positionOfSanta.get(0);
        int colOfSanta = positionOfSanta.get(1);
        neighborhood[rowOfSanta][colOfSanta] = '-';

        String newLine = scanner.nextLine();

        while (!newLine.equals("Christmas morning")) {

            String[] command = newLine.split("\\s+");
            String directionToMove = command[0];
            int currentRow = rowOfSanta;
            int currentCol = colOfSanta;

            switch (directionToMove) {
                case "up":
                    if (currentRow - 1 <= neighborhood.length) {
                        currentRow -= 1;
                        if (neighborhood[currentRow][currentCol] == 'X') {
                            neighborhood[currentRow][currentCol] = '-';
                        } else if (neighborhood[currentRow][currentCol] == 'V') {
                            neighborhood[currentRow][currentCol] = '-';
                            countOfPresents--;
                            happyNiceKidsCounter++;
                        }
                    }
                    break;
                case "right":
                    if (currentCol + 1 <= neighborhood.length) {
                        currentCol += 1;
                        if (neighborhood[currentRow][currentCol] == 'X') {
                            neighborhood[currentRow][currentCol] = '-';
                        } else if (neighborhood[currentRow][currentCol] == 'V') {
                            neighborhood[currentRow][currentCol] = '-';
                            countOfPresents--;
                            happyNiceKidsCounter++;
                        }
                    }
                    break;
                case "down":
                    if (currentRow + 1 <= neighborhood.length) {
                        currentRow += 1;
                        if (neighborhood[currentRow][currentCol] == 'X') {
                            neighborhood[currentRow][currentCol] = '-';
                        } else if (neighborhood[currentRow][currentCol] == 'V') {
                            neighborhood[currentRow][currentCol] = '-';
                            countOfPresents--;
                            happyNiceKidsCounter++;
                        }
                    }
                    break;
                case "left":
                    if (currentCol - 1 <= neighborhood.length) {
                        currentCol -= 1;
                        if (neighborhood[currentRow][currentCol] == 'X') {
                            neighborhood[currentRow][currentCol] = '-';
                        } else if (neighborhood[currentRow][currentCol] == 'V') {
                            neighborhood[currentRow][currentCol] = '-';
                            countOfPresents--;
                            happyNiceKidsCounter++;
                        }
                    }
                    break;
                default:
                    break;
            }
            rowOfSanta = currentRow;
            colOfSanta = currentCol;
            if (countOfPresents < 1) {
                break;
            }
            newLine = scanner.nextLine();
        }

        neighborhood[rowOfSanta][colOfSanta] = 'S';
        if (countOfPresents == 0) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(neighborhood, rows);

        if (happyNiceKidsCounter == niceKids) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", happyNiceKidsCounter);
        } else {
            System.out.printf("No presents for %d nice kid/s.", niceKids - happyNiceKidsCounter);
        }

    }

    private static char[][] fillMatrix(int rows, int cols, Scanner scan) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = scan.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                char currentChar = line[col].charAt(0);
                matrix[row][col] = currentChar;
            }
        }
        return matrix;
    }

    private static List<Integer> positionOfSanta(char[][] neighbourhood, int rows, int cols) {
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

    private static void printMatrix(char[][] squareMatrix, int rows) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < squareMatrix[row].length; col++) {
                System.out.print(squareMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int niceKidsCount(char[][] neighborhood, int rows) {
        int counter = 0;
        for (int row = 0; row < rows; row++) {
            for (int cols = 0; cols < neighborhood.length; cols++) {
                if (neighborhood[row][cols] == 'V') {
                    counter++;
                }
            }
        }
        return counter;
    }
}