package PokemonTrainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Trainer {
        public void setNumberOfBadges() {
                this.numberOfBadges++;
        }

        private int numberOfBadges;

        public void setPokemons(List<Pokemon> pokemons) {
                this.pokemons = pokemons;
        }
        public List<Pokemon> getPokemons() {
                return new ArrayList<>(this.pokemons);
        }
        private List<Pokemon> pokemons;

        public Trainer(){
                this.numberOfBadges=0;
                this.pokemons = new ArrayList<>();
        }

        public int pokemonCollectionSize(){
                return this.pokemons.size();
        }

        private UnaryOperator<Pokemon> damagePokemon = pokemon ->
                new Pokemon(pokemon.getName(), pokemon.getElement(),pokemon.getHealth()-10);

        public void missingPokemon(){
                this.pokemons = this.pokemons
                        .stream()
                        .map(damagePokemon)
                        .filter(pokemon -> pokemon.getHealth()>0)
                        .collect(Collectors.toList());
        }

        public int getNumberOfBadges(){
                return numberOfBadges;
        }

        public void addPokemon(Pokemon pokemon) {
                this.pokemons.add(pokemon);
        }
}
