package Queues;
import java.util.Scanner;
import java.util.*;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split(" ");
        int numberOfTurns = Integer.parseInt(scanner.nextLine());
        int numberOfCycles = 1;
        ArrayDeque<String> childrenQueue = new ArrayDeque<>();

        for (int i = 0; i < children.length; i++) {
            childrenQueue.offer(children[i]);
        }

        while (childrenQueue.size() > 1) {
            for (int i = 1; i < numberOfTurns; i++) {
                String currentChild = childrenQueue.poll();
                childrenQueue.offer(currentChild);
            }
            if(IsPrime(numberOfCycles)){
                System.out.println("Prime " + childrenQueue.peek());
            }else{
                System.out.println("Removed " + childrenQueue.poll());
            }
            numberOfCycles++;
        }
        System.out.printf("Last is %s", childrenQueue.peek());
    }

    private static boolean IsPrime(int n) {
        boolean primeCheck = true;
        if (n == 0 || n == 1) {
            primeCheck = false;
            return primeCheck;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    primeCheck = false;
                }
            }
            return primeCheck;
        }
    }
}
