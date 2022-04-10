package Exercises;
import java.util.Scanner;
import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int lengthOfSetOne = Integer.parseInt(input[0]);
        int lengthOfSetTwo = Integer.parseInt(input[1]);

        Set<Integer> setOne = new LinkedHashSet<>();
        Set<Integer> setTwo = new LinkedHashSet<>();

        for (int i = 0; i < lengthOfSetOne; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            setOne.add(number);
        }

        for (int i = 0; i < lengthOfSetTwo; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            setTwo.add(number);
        }

        for (int number:
             setOne) {
            if(setTwo.contains(number)){
                System.out.print(number+" ");
            }
        }

    }
}
