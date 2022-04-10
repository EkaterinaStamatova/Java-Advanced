package Queues;
import java.util.Scanner;
import java.util.*;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();
        String line = scanner.nextLine();
        String current = "";
        while (!line.equals("print")) {
            if (line.equals("cancel")) {
                if (!printerQueue.isEmpty()) {
                    current = printerQueue.pop();
                    System.out.println("Canceled " + current);
                } else {
                    System.out.println("Printer is on standby");
                    line = scanner.nextLine();
                    continue;
                }
            } else {
                printerQueue.offer(line);
            }

            line = scanner.nextLine();
        }
        for (String document:
                printerQueue
             ) {
            System.out.println(document);
        }
    }
}

