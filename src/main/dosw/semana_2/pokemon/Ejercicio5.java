package main.dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio5 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon("Pikachu",   45),
            new Pokemon("Mewtwo",    88),
            new Pokemon("Dragonite", 82),
            new Pokemon("Squirtle",  38),
            new Pokemon("Mew",       85),
            new Pokemon("Charmander",62)
        );

        long cantidad = pokemones.stream()
            .filter(p -> p.getNivel() > 80)
            .count();

        List<String> nombres = pokemones.stream()
            .filter(p -> p.getNivel() > 80)
            .map(p -> p.getNombre())
            .collect(Collectors.toList());

        System.out.println("Pokemon con nivel > 80: " + cantidad);
        System.out.println(nombres);
    }
}