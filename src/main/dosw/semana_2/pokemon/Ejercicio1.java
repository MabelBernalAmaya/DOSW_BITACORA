package main.dosw.semana_2.pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio1 {
    public static void main(String[] args) {
        
        List<Pokemon> pokemons = List.of(
            new Pokemon("Pikachu", "Electrico"),
            new Pokemon("Charmander", "Fuego"),
            new Pokemon("Squirtle", "Agua"),
            new Pokemon("Vulpix", "Fuego"),
            new Pokemon("Bulbasaur", "Planta"),
            new Pokemon("Flareon", "Fuego")
        );
        
       
        List<Pokemon> pokemonFuego = pokemons.stream()
            .filter(p -> p.getTipo().equals("Fuego"))
            .collect(Collectors.toList());
        
       
        System.out.println("=== Pokémon de tipo Fuego ===");
        for (Pokemon p : pokemonFuego) {
            System.out.println(p.getNombre());
        }
    }
}