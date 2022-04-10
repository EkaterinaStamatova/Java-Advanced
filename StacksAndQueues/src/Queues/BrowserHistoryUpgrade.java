package Queues;
import java.util.Scanner;
import java.util.*;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browser = new ArrayDeque<>();
        ArrayDeque<String> forwardPages = new ArrayDeque<>();

        String command;

        while(!"Home".equals(command = scanner.nextLine())) {
            if(command.equals("back")) {
                if(!browser.isEmpty()) {
                    forwardPages.addFirst(browser.peek());
                    browser.pop();
                    System.out.println(browser.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            }else if(command.equals("forward")){
                if(!forwardPages.isEmpty()) {
                    System.out.println(forwardPages.peek());
                    browser.push(forwardPages.pop());
                } else {
                    System.out.println("no next URLs");
                }
            }
            else {
                System.out.println(command);
                browser.push(command);
                forwardPages.clear();
            }

        }

    }
}
