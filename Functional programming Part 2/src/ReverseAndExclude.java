import java.util.Scanner;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int number = Integer.parseInt(scanner.nextLine());
        Collections.reverse(numbers);

        Predicate<Integer> checkDivision = numberToCheck -> numberToCheck % number ==0;
        numbers.removeIf(checkDivision);

        numbers.forEach(n-> System.out.print(n + " "));
    }
}
