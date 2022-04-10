import java.util.Scanner;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;


public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> add = list -> list.stream().map(number -> number+=1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtract = list -> list.stream().map(number -> number-=1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiply = list -> list.stream().map(number -> number*=2).collect(Collectors.toList());

        Consumer<List<Integer>> printList = list -> {
            for (int n:
                 list) {
                System.out.print(n + " ");
            }
        };

        String line = scanner.nextLine();
        while(!line.equals("end")){
            switch (line){
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    printList.accept(numbers);
                    System.out.println();
                    break;
                default:
                    break;

            }
            line= scanner.nextLine();
        }

    }
}
