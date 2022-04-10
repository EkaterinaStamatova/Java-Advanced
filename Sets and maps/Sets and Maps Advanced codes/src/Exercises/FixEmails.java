package Exercises;
import java.util.Scanner;
import java.util.*;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emails = new LinkedHashMap<>();

        String line = scanner.nextLine();
        int oddOrEvenLineCounter = 1;
        String name = "";
        String email = "";
        while (!line.equals("stop")){

            if(oddOrEvenLineCounter%2==0){
                email = line;
            }else{
                name = line;
            }

            if(!emails.containsKey(name)){
                emails.put(name,email);
            }else{
                String[] typeOfEmail = email.split("@");
                // email = typeOfEmail[1];
                String[] domain = typeOfEmail[1].split("\\.");
                String currentDomain = domain[1];
                if(currentDomain.equals("us")||currentDomain.equals("com")||currentDomain.equals("uk")){
                    emails.remove(name);
                }else{
                    emails.replace(name,email);
                }
            }
            oddOrEvenLineCounter++;
            line = scanner.nextLine();
        }

        emails.entrySet().stream().forEach(entry -> System.out.printf("%s -> %s%n", entry.getKey(),entry.getValue()));

    }
}
