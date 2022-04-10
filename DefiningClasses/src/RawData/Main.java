package RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new LinkedList<>();

        for (int i = 0; i < lines; i++) {
            String[] input = scanner.nextLine().split(" ");

            // Car
            String model = input[0];

            // Engine
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);

            // Cargo
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];

            // Tires
            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);


            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);


            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);


            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);

            Tire tire = new Tire();
            tire.getTireInformation().put(tire1Pressure,tire1Age);
            tire.getTireInformation().put(tire2Pressure,tire2Age);
            tire.getTireInformation().put(tire3Pressure,tire3Age);
            tire.getTireInformation().put(tire4Pressure,tire4Age);

            Cargo cargo = new Cargo(cargoWeight,cargoType);
            Engine engine = new Engine();
            engine.getEngineInformation().put(engineSpeed,enginePower);

            Car car = new Car(model, engine, cargo, tire);
            cars.add(car);
        }

        String flammableOrFragile = scanner.nextLine();

        if(flammableOrFragile.equals("fragile")){
            for (Car car:
                 cars) {
                String cargoType = car.getCargoType();
                boolean isFragile = car.isFragile();
                if(cargoType.equals("fragile") && isFragile){
                    System.out.println(car.getModel());
                }
            }
        }else if(flammableOrFragile.equals("flamable")){
            for (Car car:
                    cars) {
                String cargoType = car.getCargoType();
                boolean isPowerful = car.isPowerful();
                if(cargoType.equals("flamable") && isPowerful){
                    System.out.println(car.getModel());
                }
            }
        }
    }

}
