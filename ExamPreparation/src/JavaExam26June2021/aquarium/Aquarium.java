package JavaExam26June2021.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    public int getFishInPool() {
        return fishInPool.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        fishInPool = new ArrayList<>();
    }

    private String name;
    private int capacity;
    private int size;

    public void add(Fish fish){
        if (this.capacity > this.fishInPool.size()) {
            this.fishInPool.add(fish);
        }
    }

    public boolean remove(String name){
        return this.fishInPool.removeIf(c -> c.getName().equals(name));
    }

    public Fish findFish(String name){
        return this.fishInPool
                .stream()
                .filter(e-> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public String report(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Aquarium: %s ^ Size: %d%n", this.name,this.size));
        this.fishInPool
                .forEach(fish -> sb
                        .append(fish)
                        .append(System.lineSeparator()));
        return sb.toString();
    }
}
