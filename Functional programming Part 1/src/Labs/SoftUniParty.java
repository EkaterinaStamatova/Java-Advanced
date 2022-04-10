package Labs;
import java.util.Scanner;
import java.util.*;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vipGuests = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();

        String line = scanner.nextLine();

        // Get the reservation list
        while (!line.equals("PARTY")){

            if(line.length()==8){
                if(Character.isDigit(line.charAt(0))){
                    vipGuests.add(line);
                }else{
                    regularGuests.add(line);
                }
            }

            line = scanner.nextLine();
        }

        String arrivingGuests = scanner.nextLine();

        while (!arrivingGuests.equals("END")){
            if (vipGuests.contains(arrivingGuests)) {
                vipGuests.remove(arrivingGuests);
            }else if(regularGuests.contains(arrivingGuests)){
                regularGuests.remove(arrivingGuests);
            }
            arrivingGuests = scanner.nextLine();
        }

        int didNotComeVIP = vipGuests.size();
        int didNotComeRegular = regularGuests.size();

        int totalMissing = didNotComeRegular+didNotComeVIP;
        System.out.println(totalMissing);

        if(totalMissing>0){
            for (String person:
                 vipGuests) {
                System.out.println(person);
            }
        }
        if(totalMissing>0){
            for (String person:
                    regularGuests) {
                System.out.println(person);
            }
        }
    }
}
