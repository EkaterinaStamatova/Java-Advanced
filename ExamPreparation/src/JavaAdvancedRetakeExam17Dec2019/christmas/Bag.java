package JavaAdvancedRetakeExam17Dec2019.christmas;

import java.util.*;

public class Bag {

    public Bag(String color, int capacity) {
        this.data = new ArrayList<>();
        this.color = color;
        this.capacity = capacity;
    }

    private List<Present> data;

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    private String color;
    private int capacity;

    public int count(){
        return this.data.size();
    }

    public void add(Present present){
        if(this.capacity>this.data.size()){
            this.data.add(present);
        }
    }

    public boolean remove(String name){
        for (int i = 0; i < this.data.size(); i++) {
            Present present = this.data.get(i);
            if (present.getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    // HeaviestPresent and getPresent are equal codes. The heaviestPresent() method is simple and readable, while
    // getPresent is the longer version to do this.
    public Present heaviestPresent() {
        Present present2 = this.data.stream()
                .max(Comparator.comparingDouble(Present::getWeight)).orElse(this.data.get(0));
        return present2;
    }

    public Present getPresent(String name){
        for (Present present:
             data) {
            if(present.getName().equals(name)){
                return present;
            }
        }
        return null;
    }

    public String report(){
        StringBuilder builder = new StringBuilder();

        builder.append(String.format(this.color+ " bag contains:%n"));

        for (Present present:
             data) {
            builder.append(String.format(present + "%n"));
        }
        return builder.toString().trim();
    }
}
