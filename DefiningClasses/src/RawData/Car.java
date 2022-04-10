package RawData;

public class Car {

    public Car(String model, Engine engine, Cargo cargo, Tire tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public String getCargoType(){
        return cargo.getCargoType();
    }

    public boolean isFragile(){
        return tires.getLowPressureTires();
    }

    public boolean isPowerful(){
        return engine.getPowerfulEngine();
    }

    // state
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tires;


}
