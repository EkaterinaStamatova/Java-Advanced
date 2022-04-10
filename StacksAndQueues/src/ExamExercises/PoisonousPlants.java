package ExamExercises;
import java.util.Scanner;
import java.util.*;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPlants = Integer.parseInt(scanner.nextLine());

        int[] plants = Arrays .stream(scanner.nextLine().split("\\s+")) .mapToInt(Integer::parseInt) .toArray();
        ArrayDeque<Integer> garden = new ArrayDeque<>(); // stack
        int[] days = new int[plants.length];
        garden.push(0);

        for (int x = 1; x < plants.length; x++) {
            int maxDays = 0;
            while (garden.size() > 0 && plants[garden.peek()] >= plants[x]) {

                maxDays = Integer.max(days[garden.pop()], maxDays);
            }

            if (garden.size() > 0) {
                days[x] = maxDays + 1;
            }

            garden.push(x);
        }
        System.out.printf("%d", Arrays.stream(days).max().getAsInt());

    }
}
