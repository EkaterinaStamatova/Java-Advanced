package Exercises;
import java.util.Scanner;
import java.util.*;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<Character, Integer> countSymbols = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            int currentOccurrence = 1;

            if(!countSymbols.containsKey(currentSymbol)){
                countSymbols.put(currentSymbol, currentOccurrence);
            }else{
                currentOccurrence = countSymbols.get(currentSymbol) + 1;
                countSymbols.replace(currentSymbol,currentOccurrence);
            }
        }

        countSymbols.entrySet().stream().forEach(entry -> System.out.printf("%c: %d time/s%n", entry.getKey(),entry.getValue()));

    }
}
