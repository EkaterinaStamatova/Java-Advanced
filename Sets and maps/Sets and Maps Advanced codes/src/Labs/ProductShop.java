package Labs;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String,String>> shops = new TreeMap<>();
        DecimalFormat df = new DecimalFormat("0.0");

        String newLine = scanner.nextLine();

        while (!newLine.equals("Revision")){
            String[] info = newLine.split(", ");
            String shop = info[0];
            String product = info[1];
            String price = df.format(Double.parseDouble(info[2]));

            if (!shops.containsKey(shop)) {
                shops.put(shop, new LinkedHashMap<>());
                shops.get(shop).put(product,price);

            } else {
                shops.get(shop).put(product,price);

            }
            newLine = scanner.nextLine();
        }

        shops.entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.printf("%s->%n", entry.getKey());
                    entry.getValue().entrySet().stream().forEach( e -> System.out.printf("Product: %s, Price: %s%n", e.getKey(),e.getValue()));
                });
    }
}
