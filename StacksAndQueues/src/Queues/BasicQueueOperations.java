package Queues;
import java.util.Scanner;
import java.util.*;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // N -> representing the number of elements to push into the queue
        // S -> the number of elements to pop from the queue
        // X -> an element to check whether is present

        // First line: input [N,S,X]
        String[] input = scanner.nextLine().split(" ");
        int nToPush = Integer.parseInt(input[0]);
        int sToPop = Integer.parseInt(input[1]);
        int xToCheck = Integer.parseInt(input[2]);

        // Second line: our queue
        String[] stackInput = scanner.nextLine().split(" ");
        ArrayDeque<String> queue = new ArrayDeque<>();
        // note about collections
        for (int i = 0; i < nToPush; i++) {
            queue.offer(stackInput[i]);
        }

        for (int i = 0; i < sToPop ; i++) {
            queue.poll();
        }

        int stackSize = queue.size();
        if(stackSize==0){
            System.out.println(0);
        }else if(stackSize>0){
            if(queue.contains(String.valueOf(xToCheck))){
                System.out.println("true");
            }else{
                System.out.println(Collections.min(queue));
            }
        }
        // System.out.println(queue.peek());

    }
}
