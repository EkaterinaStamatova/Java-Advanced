package JavaAdvanced28June2020;

import sun.awt.SunHints;

import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque();
        ArrayDeque<Integer> queue = new ArrayDeque();

        TreeMap<String, Integer> bombs = new TreeMap<>();

        boolean hasFilledBombPouch = false;

        int daturaBombsCounter = 0;
        int cherryBombsCounter = 0;
        int smokeDecoyBombCounter =0;
        // First bomb effect is mixed with last bomb casting
        // -> Stack: bomb effect
        // -> Queue: bomb casting

        int[] bombEffects = Arrays
                .stream(scanner.nextLine()
                        .split(",\\s+"))
                .mapToInt(Integer::parseInt) .toArray();

        int[] bombCasings = Arrays
                .stream(scanner.nextLine()
                        .split(",\\s+"))
                .mapToInt(Integer::parseInt) .toArray();

        queue = fillQueue(bombEffects);
        stack = fillStack(bombCasings);

        while (queue.size()>0 && stack.size()>0) {
            int effects = queue.peek();
            int casings = stack.peek();
            int product = effects + casings;

            // Products:
                // Datura Bombs: 40
                // Cherry Bombs: 60
                // Smoke Decoy Bombs: 120
            if(product == 40){
                daturaBombsCounter++;
                stack.pop();
                queue.pop();
            }else if(product==60){
                cherryBombsCounter++;
                stack.pop();
                queue.pop();
            }else if(product==120){
                smokeDecoyBombCounter++;
                stack.pop();
                queue.pop();
            }else{
                casings-=5;
                stack.pop();
                stack.push(casings);
            }

            if(smokeDecoyBombCounter>=3 && cherryBombsCounter>=3 && daturaBombsCounter>=3){
                hasFilledBombPouch = true;
                break;
            }
        }


        if(hasFilledBombPouch){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else{
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        printQueue(queue);
        printStack(stack);


        bombs.put("Datura Bombs", daturaBombsCounter);
        bombs.put("Cherry Bombs", cherryBombsCounter);
        bombs.put("Smoke Decoy Bombs", smokeDecoyBombCounter);

        bombs.entrySet().stream().forEach(entry -> System.out.printf("%s: %d%n",entry.getKey(),entry.getValue()));
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
            System.out.printf("Bomb Casings: ");
            for (int i = 0; i < stack.size(); i++) {
                if (i == stack.size() - 1) {
                    System.out.printf("%d%n",stack.pop());
                } else {
                    System.out.print(stack.pop() + ", ");
                    i--;
                }
            }
        }else{
            System.out.println("Bomb Casings: empty");
        }
    }

    public static void printQueue(ArrayDeque<Integer> queue){
        if (queue.size() > 0) {
            System.out.print("Bomb Effects: ");
            for (int i = 0; i < queue.size(); i++) {
                if (i == queue.size() - 1) {
                    System.out.println(queue.poll());
                } else {
                    System.out.print(queue.poll() + ", ");
                    i--;
                }
            }
        }else{
            System.out.println("Bomb Effects: empty");
        }
    }
}

