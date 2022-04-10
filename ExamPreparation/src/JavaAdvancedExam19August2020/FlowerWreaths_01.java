package JavaAdvancedExam19August2020;

import java.util.*;

public class FlowerWreaths_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] lilies = Arrays
                .stream(scanner.nextLine()
                        .split(",\\s+"))
                .mapToInt(Integer::parseInt) .toArray();

        int[] roses = Arrays
                .stream(scanner.nextLine()
                        .split(",\\s+"))
                .mapToInt(Integer::parseInt) .toArray();

        int flowerWreathsCounter = 0;
        List<Integer> storedFlowers = new ArrayList<>();
        // Last lilies with first roses

        // Stack - lilies
        // Queue - roses

        stack = fillStack(lilies);
        queue = fillQueue(roses);

        flowerWreathsCounter = flowerWreaths(flowerWreathsCounter,stack,queue,storedFlowers);
        int storedFlowersWreaths =storedFlowers(storedFlowers);

        flowerWreathsCounter+=storedFlowersWreaths;
        if(flowerWreathsCounter>=5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!",flowerWreathsCounter );
        }else{
            System.out.printf("You didn't make it, you need %d wreaths more!", Math.abs(5-flowerWreathsCounter));
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
    public static Integer flowerWreaths(int flowerWreathsCounter,ArrayDeque<Integer> stack,ArrayDeque<Integer> queue, List<Integer> storedFlowers){
        while(stack.size()>0 && queue.size()>0){
            int rose = queue.peek();
            int lilly = stack.peek();
            int sum = 0;

            sum = rose+lilly;

            if(sum>15){
                while(sum>15){
                    lilly -= 2;
                    sum = rose+lilly;
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
