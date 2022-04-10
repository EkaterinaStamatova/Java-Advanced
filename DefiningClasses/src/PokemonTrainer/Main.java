package PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("Tournament")) {
            String[] information = line.split("\\s+");

            // trainerName - pokemonName - pokemonElement - pokemonHealth
            String trainerName = information[0];
            String pokemonName = information[1];
            String pokemonElement = information[2];
            int pokemonHealth = Integer.parseInt(information[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainers.putIfAbsent(trainerName, new Trainer());
            trainers.get(trainerName).addPokemon(pokemon);
            line = scanner.nextLine();
        }

        String tournament = scanner.nextLine();
        while (!tournament.equals("End")) {

            for (Map.Entry<String, Trainer> kvp : trainers.entrySet()) {
                if (kvp.getValue().pokemonCollectionSize() > 0) {
                    boolean havePokemon = false;
                    for (Pokemon pokemon : kvp.getValue().getPokemons()) {
                        if (pokemon.getElement().equals(tournament)) {
                            havePokemon = true;
                            kvp.getValue().setNumberOfBadges();
                            break;
                        }
                    }
                    if (!havePokemon) {
                        kvp.getValue().missingPokemon();
                    }
                }
            }
            tournament = scanner.nextLine();
        }
        trainers.entrySet().stream()
                .sorted((a,b) -> Integer.compare(b.getValue().getNumberOfBadges(),a.getValue().getNumberOfBadges()))
                .forEach(t-> {
                    System.out.println(String.format("%s %s %s", t.getKey(),
                            t.getValue().getNumberOfBadges(),
                            t.getValue().pokemonCollectionSize()));
                });
    }
}

