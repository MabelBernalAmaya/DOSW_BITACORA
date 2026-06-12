package main.dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Ejercicio12 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon("Pikachu",   45),
            new Pokemon("Mewtwo",    88),
            new Pokemon("Dragonite", 82),
            new Pokemon("Charizard", 78)
        );

        Optional<Pokemon> campeon = pokemones.stream()
            .max(Comparator.comparingDouble(p -> p.getPoderCombate()));

        if (campeon.isPresent()) {
            System.out.println("Campeon: " + campeon.get().getNombre()
                + " con PC: " + (int)campeon.get().getPoderCombate());
        }
    }
}