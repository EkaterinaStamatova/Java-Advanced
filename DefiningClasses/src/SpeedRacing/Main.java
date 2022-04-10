package SpeedRacing;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Car> carModels = new LinkedHashMap<>();

        for (int i = 0; i < numberOfLines; i++) {
            String[] carInformation = scanner.nextLine().split(" ");
            String carModel = carInformation[0];
            double fuelAmount = Double.parseDouble(carInformation[1]);
            double fuelPer1Km = Double.parseDouble(carInformation[2]);
            Car car = new Car(carModel,fuelAmount,fuelPer1Km);
            carModels.put(carModel,car);
        }

        String input = scanner.nextLine();
        while(!input.equals("End")){
            String[] commandData = input.split(" ");
            String carModel = commandData[1];
            int kmToDrive = Integer.parseInt(commandData[2]);

            Car carToDrive = carModels.get(carModel);
            if(!carToDrive.canMove(kmToDrive)){
                System.out.println("Insufficient fuel for the drive");
            }
            input = scanner.nextLine();
        }

        for(Car car: carModels.values()){
            System.out.println(car.toString());
        }
    }
}
