package JavaAdvanced14April2021;

import java.util.*;

public class Bouquets_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int bouquetsCounter = 0;
        // Last tulips with first daffodils

        int[] tulips = Arrays
                .stream(scanner.nextLine()
                        .split(",\\s+"))
                .mapToInt(Integer::parseInt) .toArray();

        int[] daffodils = Arrays
                .stream(scanner.nextLine()
                        .split(",\\s+"))
                .mapToInt(Integer::parseInt) .toArray();

        // Stack -> Tulips
        // Queue -> Daffodils

        stack = fillStack(tulips);
        queue = fillQueue(daffodils);

        List<Integer> storedFlowers = new ArrayList<>();
        bouquetsCounter = flowerWreaths(bouquetsCounter,stack,queue,storedFlowers);
        int storedFlowersWreaths = storedFlowers(storedFlowers);

        bouquetsCounter+=storedFlowersWreaths;
        if(bouquetsCounter>=5){
            System.out.printf("You made it! You go to the competition with %d bouquets!",bouquetsCounter);
        }else{
            System.out.printf("You failed... You need more %d bouquets.", Math.abs(5-bouquetsCounter));
        }

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

    public static Integer flowerWreaths(int flowerWreathsCounter,ArrayDeque<Integer> stack,ArrayDeque<Integer> queue, List<Integer> storedFlowers){
        while(stack.size()>0 && queue.size()>0){
            int daffodil = queue.peek();
            int tulip = stack.peek();
            int sum = 0;

            sum = daffodil+tulip;

            if(sum>15){
                while(sum>15){
                    tulip -= 2;
                    sum = daffodil+tulip;
                }
            }
            if(sum<15){
                storedFlowers.add(sum);
                stack.pop();
                queue.pop();
            }
            if(sum==15){
                flowerWreathsCounter++;
                queue.pop();
                stack.pop();
            }
        }
        return flowerWreathsCounter;
    }

    public static Integer storedFlowers(List<Integer> storedFlowers){
        int counter=0;
        int sum = 0;
        for (int flower:
                storedFlowers) {
            sum+=flower;
        }
        counter= sum/15;
        return counter;
    }
}
