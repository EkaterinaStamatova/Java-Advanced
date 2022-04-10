import java.util.Scanner;
import java.util.*;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split(" ");

        Consumer<String[]> printNames = array -> {
            for(String name : array){
                System.out.println(name);
            }
        };

        printNames.accept(names);
    }
}
