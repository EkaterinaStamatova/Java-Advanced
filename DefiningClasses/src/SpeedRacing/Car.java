package SpeedRacing;

public class Car {



    private String model;

    private double fuelAmount;
    private int distance;
    private double fuelCostFor1Km;


    public Car(String model, double fuelAmount, double fuelCostFor1Km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1Km = fuelCostFor1Km;
    }

    public boolean canMove(int kmToMove){
        // distance
        double needFuel = kmToMove*this.fuelCostFor1Km;
        if(needFuel<=this.fuelAmount){
            this.distance += kmToMove;
            this.fuelAmount -= needFuel;
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        return String.format("%s %.2f %d", this.model, this.fuelAmount,this.distance);
    }

}
