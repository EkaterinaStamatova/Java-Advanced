import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//sorry ama masata e re-ser-ve
public class ThePartyReservationModel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        HashMap<String, Predicate> predicates = new HashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("Print")){

            String[] tokens = line.substring(line.indexOf(";") + 1).split("([ ;]+)");
            int index = 2;
            if(tokens.length == 2){
                index = 1;
            }
            String name = tokens[0] + tokens[index];

            if(line.contains("Add")){
                Predicate<String> predicate = null;
                switch (tokens[0]){
                    case "Starts":
                        predicate = s -> s.startsWith(tokens[2]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                    case "Ends":
                        predicate = s -> s.endsWith(tokens[2]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                    case "Length":
                        predicate = s -> s.length() == Integer.parseInt(tokens[2]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                    case "Contains":
                        predicate = s -> s.contains(tokens[1]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                }
            }else{
                predicates.remove(name);
            }
            line = scanner.nextLine();
        }

        for (String guest : guests) {
            boolean isGoing = true;

            for (String entry : predicates.keySet()) {
                if (predicates.get(entry).test(guest)) {
                    isGoing = false;
                    break;
                }
            }

            if (isGoing) {
                System.out.print(guest + " ");
            }
        }
    }
}
