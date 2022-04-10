package Stacks;
import java.util.Scanner;
import java.util.*;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // N -> representing the number of elements to push into the stack
        // S -> the number of elements to pop from the stack
        // X -> an element to check whether is present

        // First line: input [N,S,X]
        String[] input = scanner.nextLine().split(" ");
        int nToPush = Integer.parseInt(input[0]);
        int sToPop = Integer.parseInt(input[1]);
        int xToCheck = Integer.parseInt(input[2]);

        // Second line: our stack
        String[] stackInput = scanner.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        // note about collections
        for (int i = 0; i < nToPush; i++) {
            stack.push(stackInput[i]);
        }

        for (int i = 0; i < sToPop ; i++) {
            stack.pop();
        }

        int stackSize = stack.size();
        if(stackSize==0){
            System.out.println(0);
        }else if(stackSize>0){
            if(stack.contains(String.valueOf(xToCheck))){
                System.out.println("true");
            }else{
                int minNumber = getMin(stack);
                System.out.println(minNumber);
            }
        }
       // System.out.println(stack.peek());

    }
    public static Integer getMin(ArrayDeque<String> stack){
        // Function to get the minimum element of a stack
        int stackSize = stack.size();
        int currentNumber = Integer.parseInt(stack.pop());
        int minNumber = currentNumber;

        for (int i = 0; i < stackSize-1; i++) {
            currentNumber = Integer.parseInt(stack.pop());
            if(currentNumber<minNumber){
                minNumber=currentNumber;
            }else{
                continue;
            }
        }

        return minNumber;
    }
}
