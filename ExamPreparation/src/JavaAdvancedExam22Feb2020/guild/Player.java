package JavaAdvancedExam22Feb2020.guild;

public class Player {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String name;
    private String clazz;
    private String rank;
    private String description;

    public Player(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
        this.rank = "Trial";
        this.description = "n/a";
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Player %s: %s%n", this.name,this.clazz))
                .append(String.format("Rank: %s%n",this.rank))
                .append(String.format("Description: %s",this.description));

        return sb.toString();
    }
}
