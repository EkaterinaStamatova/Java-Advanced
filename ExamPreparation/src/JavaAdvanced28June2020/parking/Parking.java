package JavaAdvanced28June2020.parking;

import java.util.Comparator;
import java.util.List;
import java.util.*;

public class Parking {
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    private String type;
    private int capacity;

    public void add(Car car){
        if(this.capacity>this.data.size()){
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model){
        return this.data.removeIf(c -> c.getManufacturer().equals(manufacturer)
               && c.getModel().equals(model));
    }


    public Car getLatestCar() {
        Car car = this.data.stream()
                .max(Comparator.comparingInt(Car::getYear)).orElse(null);
        return car;
    }

    public Car getCar(String manufacturer, String model){
        for (Car car:
                data) {
            if(car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                return car;
            }
        }
        return null;
    }

    public int getCount(){
        return data.size();
    }


    public String getStatistics(){
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("%nThe cars are parked in %s:%n",this.type));

        for (Car car:
                data){
            builder.append(String.format(car + "%n"));
        }
        return builder.toString().trim();
    }
}
