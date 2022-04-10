package JavaExam26June2021.aquarium;

public class Fish {
    public Fish(String name, String color, int fins) {
        this.name = name;
        this.color = color;
        this.fins = fins;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getFins() {
        return fins;
    }

    private String name;
    private String color;
    private int fins;

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Fish: %s%n" +
                "Color: %s%n" +
                "Number of fins: %d%n",this.name,this.color,this.fins));

        return sb.toString().trim();
    }
}
