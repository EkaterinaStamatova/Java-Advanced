package Labs;

import java.util.Scanner;
import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        //Students: Name, Grade
        Map<String, List<Double>> students = new TreeMap<>();



        for (int i = 0; i < numberOfStudents; i++) {
            String[] studentInfo = scanner.nextLine().split(" ");
            String name = studentInfo[0];
            double grade = Double.parseDouble(studentInfo[1]);

            if (!students.containsKey(name)) {
                students.put(name, new LinkedList<>());
                students.get(name).add(grade);
            } else {
                students.get(name).add(grade);
            }

        }
    // This is correct but test 8 gives an error , TODO: add this printing method
     //   students
       //         .entrySet()
         //       .stream()
           //     .forEach(entry -> {
             // System.out.print(entry.getKey() + " -> ");
               // entry.getValue().forEach(innerEntry -> System.out.printf("%.2f ", innerEntry));
                 // System.out.printf("(avg: %.2f)%n", entry.getValue().stream().mapToDouble(e -> e).average().orElse(0.00));
        // });

        // Here we do the average ourselves not with the stream API
        students.entrySet()
                .stream()
                .forEach(entry -> {
                    double sum = 0;
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        sum += entry.getValue().get(i);
                    }
                    double avgSum = sum / entry.getValue().size();

                    System.out.print(entry.getKey() + " -> ");
                    entry.getValue().forEach(e -> System.out.printf("%.2f ", e));
                    System.out.printf("(avg: %.2f)%n", avgSum);
                });
    }
}



