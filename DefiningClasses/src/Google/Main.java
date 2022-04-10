package Google;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String,Person> people = new LinkedHashMap<>();

        String newLine = scanner.nextLine();
        while (!newLine.equals("End")){
            String[] data = newLine.split(" ");
            String name = data[0];
            String informationToAdd = data[1];

            if(!people.containsKey(name)){
                people.put(name,new Person());
            }

            switch (informationToAdd){
                case "company":
                    String companyName = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);
                    Company company = new Company(companyName,department,salary);
                    people.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = data[2];
                    String pokemonType = data[3];
                    Pokemons pokemon = new Pokemons(pokemonName, pokemonType);
                    people.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = data[2];
                    String parentBirthday = data[3];
                    Parents parent = new Parents(parentName, parentBirthday);
                    people.get(name).getParents().add(parent);
                    break;
                case "children":
                    String childName = data[2];
                    String childBirthday = data[3];
                    Children child = new Children(childName, childBirthday);
                    people.get(name).getChildren().add(child);
                    break;
                case "car":
                    String carModel = data[2];
                    int carSpeed = Integer.parseInt(data[3]);
                    Car car = new Car(carModel, carSpeed);
                    people.get(name).setCar(car);
                    break;
            }

            newLine = scanner.nextLine();
        }

        String searchedPerson = scanner.nextLine();
        System.out.println(searchedPerson);

        //данните на човек
        Person personalData = people.get(searchedPerson);
        System.out.println(personalData);

    }
}
