package Labs;
import java.util.Scanner;
import java.util.*;

public class DemoOfSorting {
    public static void main(String[] args) {
        Map<String, Integer> students = new LinkedHashMap<>();
        students.put("Ivan", 6);
        students.put("Pesho", 4);
        students.put("Asen", 6);
        students.put("Georgi", 3);

        students
                .entrySet()
                .stream().sorted((left, right) -> {
            return right.getValue().compareTo(left.getValue());
        })
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

        students
                .entrySet()
                .stream().sorted((left, right) -> {
            int res =  right.getValue().compareTo(left.getValue());
            if(res == 0){
                res =  left.getKey().compareTo(right.getKey());
            }
            return res;
        })
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}
