package Exercises;
import java.util.Scanner;
import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> userLogs = new TreeMap<>();

        String line = scanner.nextLine();
        while (!line.equals("end")){

            // IP=192.23.30.40 message='Hello&derps.' user=destroyer
            String[] input = line.split(" ");

            // IP=192.23.30.40
            String[] ipAddress = input[0].split("=");
            String IP = ipAddress[1];
            int occurrence = 1;
            // user=destroyer
            String[] userName = input[2].split("=");
            String username = userName[1];

            if(!userLogs.containsKey(username)){
                userLogs.put(username,new LinkedHashMap<>());
                userLogs.get(username).put(IP, occurrence);
            }else{
                if(userLogs.get(username).containsKey(IP)){
                    occurrence = userLogs.get(username).get(IP) + 1;
                    userLogs.get(username).replace(IP,occurrence);
                }
                userLogs.get(username).put(IP,occurrence);
            }

            line= scanner.nextLine();
        }

        userLogs.entrySet().stream()
                .forEach(entry -> {
                    System.out.printf("%s: %n",entry.getKey());
                    final int[] count = {entry.getValue().size()}; // final one element array

                    entry.getValue().entrySet().stream().forEach(secondMapEntry -> {

                        if(count[0] >1){
                            System.out.printf("%s => %s, ", secondMapEntry.getKey(),secondMapEntry.getValue());
                        }else{
                            System.out.printf("%s => %s.%n", secondMapEntry.getKey(),secondMapEntry.getValue());
                        }
                        count[0]--;

                    });
                });
    }
}
