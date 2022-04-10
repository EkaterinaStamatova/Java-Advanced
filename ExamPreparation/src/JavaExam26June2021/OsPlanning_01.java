package JavaExam26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OsPlanning_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] tasks = Arrays
                .stream(scanner.nextLine()
                        .split(",\\s+"))
                .mapToInt(Integer::parseInt) .toArray();

        int[] threads = Arrays
                .stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt) .toArray();

        int taskToKill = Integer.parseInt(scanner.nextLine());

        // First threads ->  queue
        // Last task -> stack

        stack = fillStack(tasks);
        queue = fillQueue(threads);

        while(stack.size()>=0 && queue.size()>=0){
            int thread = queue.peek();
            int task = stack.peek();

            if(task == taskToKill){
                System.out.printf("Thread with value %d killed task %d%n", thread,taskToKill);
                break;
            }else if(thread>=task){
                queue.poll();
                stack.pop();
            }else if(thread<task){
                queue.poll();
            }
        }
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

    public static void printQueue(ArrayDeque<Integer> queue){
        if (queue.size() > 0) {
            for (int i = 0; i < queue.size(); i++) {
                if (i == queue.size() - 1) {
                    System.out.println(queue.poll());
                } else {
                    System.out.print(queue.poll() + " ");
                    i--;
                }
            }
        }
    }

}
