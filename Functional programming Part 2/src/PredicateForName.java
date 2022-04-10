import java.util.Scanner;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxLetters = Integer.parseInt(scanner.nextLine());
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Predicate<String> checkMaxDigits = name -> name.length()>maxLetters;
        names.removeIf(checkMaxDigits);

        names.forEach(name -> System.out.println(name));
    }
}
