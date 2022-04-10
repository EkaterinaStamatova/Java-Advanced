package Stacks;
import java.util.Scanner;
import java.util.*;

public class ReverseNumbersStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> reverseStack = new ArrayDeque<>();

        Collections.addAll(stack,numbers);

        int stackSize = stack.size();

        for (int i = 0; i < stackSize; i++) {
            reverseStack.push(stack.pop());
        }
        stackSize = reverseStack.size();
        for (int i = 0; i < stackSize; i++) {
            System.out.print(reverseStack.pop()+" ");
        }
    }
}
