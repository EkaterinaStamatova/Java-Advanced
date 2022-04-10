package Stacks;
import java.util.Scanner;
import java.util.*;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binaryNumber = new ArrayDeque<>();

        if(number == 0){
            System.out.println(0);
        } else {
            while(number!=0){
                int leftover = number % 2 ;
                binaryNumber.push(leftover);
                number = number / 2;
            }

            for(Integer integer : binaryNumber){
                System.out.print(integer);
            }
        }

    }
}
