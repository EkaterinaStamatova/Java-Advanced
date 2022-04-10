package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;

    private List<Children> children;
    private List<Parents> parents;

    public List<Children> getChildren() {
        return children;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public List<Pokemons> getPokemons() {
        return pokemons;
    }

    private List<Pokemons> pokemons;

    public void setCar(Car car) {
        this.car = car;
    }

    private Car car;

    public void setCompany(Company company) {
        this.company = company;
    }

    private Company company;

    public Person () {
        //company = null
        //car = null
        //parents = празен списък
        this.parents = new ArrayList<>();
        //children = празен списък
        this.children = new ArrayList<>();
        //pokemons = празен списък
        this.pokemons = new ArrayList<>();
    }

    public Person(String name, List<Children> children, List<Parents> parents,
                  List<Pokemons> pokemons, Car car, Company company) {
        this.name = name;
        this.children = children;
        this.parents = parents;
        this.pokemons = pokemons;
        this.car = car;
        this.company = company;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        //Company:
        //Car:
        //Trabant 30
        //Pokemon:
        //Electrode Electricity
        //Parents:
        //Children:
        builder.append("Company:").append("\n");
        if (company != null) {
            builder.append(company).append("\n");
        }
        builder.append("Car:").append("\n");
        if (car != null) {
            builder.append(car).append("\n");
        }

        builder.append("Pokemon:").append("\n");
        for (Pokemons pokemon : pokemons) {
            builder.append(pokemon).append("\n");
        }

        builder.append("Parents:").append("\n");
        for (Parents parent : parents) {
            builder.append(parent).append("\n");
        }

        builder.append("Children:").append("\n");
        for (Children child : children) {
            builder.append(child).append("\n");
        }

        return builder.toString();
    }

}
