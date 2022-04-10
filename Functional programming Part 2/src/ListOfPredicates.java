import java.util.Scanner;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int range = Integer.parseInt(scanner.nextLine());

        List<Integer> numbersList = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        BiFunction<Integer, List<Integer>, Boolean> isDivisible = ((number,list) -> {
            for (int numInList:
                 list) {
                    if(number%numInList !=0){
                        return false;
                    }
            }
            return true;
        });

        for (int number = 1; number <= range; number++) {
            if (isDivisible.apply(number, numbersList)) {
                System.out.print(number + " ");
            }
        }


    }
}
