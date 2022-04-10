package RawData;

public class Cargo {
    public Cargo(int cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    //state
    private int cargoWeight;

    public String getCargoType() {
        return cargoType;
    }

    private String cargoType;


}
