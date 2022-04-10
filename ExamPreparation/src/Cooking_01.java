import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Cooking_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] liquids = Arrays
                .stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt) .toArray();

        int[] ingredients = Arrays
                .stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt) .toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // First liquid - queue
        // Last ingredient  - stack
        stack = fillStack(ingredients);
        queue = fillQueue(liquids);

        int breadCounter = 0;
        int cakeCounter = 0;
        int pastryCounter = 0;
        int fruitPieCounter = 0;

        while (queue.size()>0 && stack.size()>0) {
            int liquid = queue.peek();
            int ingredient = stack.peek();
            int product = liquid + ingredient;

            // Products:
            // Bread: 25
            // Cake: 50
            // Pastry: 75
            // Fruit pie: 100

            if(product == 25){
                breadCounter++;
                stack.pop();
                queue.pop();
            }else if(product==50){
                cakeCounter++;
                stack.pop();
                queue.pop();
            }else if(product==75){
                pastryCounter++;
                stack.pop();
                queue.pop();
            }else if(product==100){
                fruitPieCounter++;
                stack.pop();
                queue.pop();
            } else{
                ingredient+=3;
                stack.pop();
                stack.push(ingredient);
                queue.pop();
            }

        }
    if(breadCounter>=1 && cakeCounter>=1 && pastryCounter>=1 && fruitPieCounter>=1){
        System.out.println("Wohoo! You succeeded in cooking all the food!");
    }else{
        System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
    }

    printQueue(queue);
    printStack(stack);

        TreeMap<String, Integer> advancedMaterials = new TreeMap<>();
        advancedMaterials.put("Bread", breadCounter);
        advancedMaterials.put("Cake", cakeCounter);
        advancedMaterials.put("Fruit Pie", fruitPieCounter);
        advancedMaterials.put("Pastry", pastryCounter);

        advancedMaterials.entrySet().stream()
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(),e.getValue()));

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
            System.out.print("Liquids left: ");
            for (int i = 0; i < queue.size(); i++) {
                if (i == queue.size() - 1) {
                    System.out.println(queue.poll());
                } else {
                    System.out.print(queue.poll() + ", ");
                    i--;
                }
            }
        }else{
            System.out.println("Liquids left: none");
        }
    }

    public static void printStack(ArrayDeque<Integer> stack){
        if (stack.size() > 0) {
            System.out.print("Ingredients left: ");
            for (int i = 0; i < stack.size(); i++) {
                if (i == stack.size() - 1) {
                    System.out.println(stack.poll());
                } else {
                    System.out.print(stack.poll() + ", ");
                    i--;
                }
            }
        }else{
            System.out.println("Ingredients left: none");
        }
    }

}
