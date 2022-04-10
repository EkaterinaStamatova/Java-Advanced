import java.util.Scanner;
import java.util.*;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split(" ");

        Consumer<String[]> putSirInFrontOfName = array -> {
            for (String name:
                 array) {
                System.out.println("Sir " + name);
            }
        };

        putSirInFrontOfName.accept(names);

    }
}
