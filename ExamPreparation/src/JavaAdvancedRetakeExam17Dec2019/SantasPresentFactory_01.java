package JavaAdvancedRetakeExam17Dec2019;

import java.util.*;

public class SantasPresentFactory_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque();
        ArrayDeque<Integer> queue = new ArrayDeque();

        TreeMap<String, Integer> toys = new TreeMap<>();

        int dollCounter = 0;
        int woodenTrainCounter = 0;
        int teddyBearCounter = 0;
        int bicycleCounter = 0;

        int[] numberOfMaterialsForCrafting = Arrays
                .stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt) .toArray();

        int[] magicalLevel = Arrays
                .stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt) .toArray();

        for (int i = 0; i < numberOfMaterialsForCrafting.length; i++) {
            stack.push(numberOfMaterialsForCrafting[i]);
        }

        for (int i = 0; i < magicalLevel.length; i++) {
            queue.offer(magicalLevel[i]);
        }

        while (queue.size()>0 && stack.size()>0) {
            int values = queue.peek();
            int boxes = stack.peek();
            int product = values * boxes;

            if (product < 0) {
                int result = values + boxes;
                queue.poll();
                stack.pop();
                stack.push(result);

            }
            else if (boxes == 0 || values == 0) {
                if (boxes == 0) {
                    stack.pop();
                }
                if (values == 0) {
                    queue.poll();
                }

            }

            else if (product == 150 || product == 250 || product == 300 || product == 400) {
                String gift ;
                if (product == 150) {
                    gift = "Doll";
                    queue.poll();
                    stack.pop();
                    toys.putIfAbsent(gift, 0);
                    toys.put(gift, toys.get(gift) + 1);
                } else if (product == 250) {
                    gift = "Wooden train";
                    queue.poll();
                    stack.pop();
                    toys.putIfAbsent(gift, 0);
                    toys.put(gift, toys.get(gift) + 1);
                } else if (product == 300) {
                    gift = "Teddy bear";
                    queue.poll();
                    stack.pop();
                    toys.putIfAbsent(gift, 0);
                    toys.put(gift, toys.get(gift) + 1);
                } else  {
                    gift = "Bicycle";
                    queue.poll();
                    stack.pop();
                    toys.putIfAbsent(gift, 0);
                    toys.put(gift, toys.get(gift) + 1);
                }
            }
            else if (product>0) {
                queue.poll();
                boxes += 15;
                stack.pop();
                stack.push(boxes);
            }
        }

        if (toys.containsKey("Doll") && toys.containsKey("Wooden train")){
            System.out.println("The presents are crafted! Merry Christmas!");
        }
        else if (toys.containsKey("Teddy bear") && toys.containsKey("Bicycle")){
            System.out.println("The presents are crafted! Merry Christmas!");
        }
        else {
            System.out.println("No presents this Christmas!");
        }

         if(stack.size()>0){
             System.out.print("Materials left: ");
             for (int i = 0; i < stack.size(); i++) {
                 if (i == stack.size() - 1) {
                     System.out.println(stack.pop());
                 } else {
                     System.out.print(stack.pop() + ", ");
                     i--;
                 }
             }
         }

        if (queue.size() > 0) {
            System.out.print("Magic left: ");
            for (int i = 0; i < queue.size(); i++) {
                if (i == queue.size() - 1) {
                    System.out.println(queue.poll());
                } else {
                    System.out.print(queue.poll() + ", ");
                    i--;
                }
            }
        }
        toys.entrySet().stream().forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(),entry.getValue()));

    }

}
