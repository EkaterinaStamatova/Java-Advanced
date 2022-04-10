package Stacks;
import java.util.Scanner;
import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(scanner.nextLine());

        //Commands for the next number of lines
        //•	"1 X" - Push the element X into the stack.
        //•	"2" - Delete the element present at the top of the stack.
        //•	"3" - Print the maximum element in the stack.

        //Stack
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= numberOfLines; i++) {
            String commandIndex = scanner.nextLine();
            switch (commandIndex){
                case "2":
                    // Delete the element at top
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    break;
                case "3":
                    // Print the max element
                    if(!stack.isEmpty()){
                        System.out.println(Collections.max(stack));
                    }
                    break;
                default:
                    // Push the element
                    String[] commandData = commandIndex.split(" ");
                    int elementX = Integer.parseInt(commandData[1]);
                    stack.push(elementX);
                    break;
            }
        }
    }
}
