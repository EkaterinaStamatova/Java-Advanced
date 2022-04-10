package Java15Dec2021.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    private int capacity;

    public void add(Pet pet){
        if (this.capacity > this.data.size()) {
            this.data.add(pet);
        }
    }
    public boolean remove(String name){
        return this.data.removeIf(c -> c.getName().equals(name));
    }

    public Pet getPet(String name, String owner){
        return this.data
                .stream()
                .filter(e-> e.getName().equals(name) && e.getOwner().equals(owner))
                .findFirst()
                .orElse(null);
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The grooming salon has the following clients:%n"));
        this.data
                .forEach(pet-> sb
                        .append(String.format("%s %s", pet.getName(),pet.getOwner()))
                        .append(System.lineSeparator()));
        return sb.toString();
    }
}
