package Java15Dec2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Meeting_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] males = Arrays
                .stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] females = Arrays
                .stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt).toArray();

        // First female -> queue
        // Last male -> stack

        queue = fillQueue(females);
        stack = fillStack(males);
        int matches = 0;

        while (stack.size() > 0 && queue.size() > 0) {
            int female = queue.peek();
            int male = stack.peek();

            if (male <= 0 || female <= 0) {
                if (male <= 0) {
                    stack.pop();
                }
                if (female <= 0) {
                    queue.poll();
                }
            }else if(male%25==0 || female%25==0){

                if(male%25==0){
                    stack.pop();
                    stack.pop();
                }else{
                    queue.poll();
                    queue.poll();
                }
            } else if(male==female){
                queue.poll();
                stack.pop();
                matches++;
            }else if(male!=female){
                queue.poll();
                male-=2;
                stack.pop();
                stack.push(male);
            }
        }

        System.out.printf("Matches: %d%n", matches);
        printStack(stack);
        printQueue(queue);
    }
    public static ArrayDeque<Integer> fillStack(int[] array){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }
        return stack;
    }

    public static ArrayDeque<Integer> fillQueue(int[] array){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            queue.offer(array[i]);
        }
        return queue;
    }

    public static void printStack(ArrayDeque<Integer> stack){
        if(stack.size()>0){
            System.out.printf("Males left: ");
            for (int i = 0; i < stack.size(); i++) {
                if (i == stack.size() - 1) {
                    System.out.printf("%d%n",stack.pop());
                } else {
                    System.out.print(stack.pop() + ", ");
                    i--;
                }
            }
        }else{
            System.out.println("Males left: none");
        }
    }

    public static void printQueue(ArrayDeque<Integer> queue){
        if(queue.size()>0){
            System.out.printf("Females left: ");
            for (int i = 0; i < queue.size(); i++) {
                if (i == queue.size() - 1) {
                    System.out.printf("%d%n",queue.pop());
                } else {
                    System.out.print(queue.pop() + ", ");
                    i--;
                }
            }
        }else{
            System.out.println("Females left: none");
        }
    }
}
