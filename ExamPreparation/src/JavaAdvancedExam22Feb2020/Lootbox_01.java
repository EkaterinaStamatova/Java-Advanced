package JavaAdvancedExam22Feb2020;

import java.util.*;

public class Lootbox_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque();
        ArrayDeque<Integer> queue = new ArrayDeque();

        List<Integer> claimedItems = new ArrayList<>();

        int[] firstBox = Arrays
                .stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt) .toArray();

        int[] secondBox = Arrays
                .stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt) .toArray();

        // First box -> Queue
        // Second box -> Stack

        for (int i = 0; i < secondBox.length; i++) {
            stack.push(secondBox[i]);
        }

        for (int i = 0; i < firstBox.length; i++) {
            queue.offer(firstBox[i]);
        }
        while(true){
            if(stack.size()<=0){
                System.out.println("Second lootbox is empty");
                printResult(claimedItems);
                return;
            }
            if(queue.size()<=0){
                System.out.println("First lootbox is empty");
                printResult(claimedItems);
                return;
            }

            if((stack.peek()+queue.peek())%2==0){
                //Even number
               int sum = stack.pop()+queue.pop();
               claimedItems.add(sum);
            }else{
                int numberToRemove = stack.pop();
                queue.offer(numberToRemove);
            }
        }
    }

    public static void printResult(List<Integer> collectedItem){
        int value = 0;
        for (Integer n:
             collectedItem) {
            value+=n;
        }

        if(value>=100){
            System.out.printf("Your loot was epic! Value: %d", value);
        }else{
            System.out.printf("Your loot was poor... Value: %d",value);
        }
    }
}
