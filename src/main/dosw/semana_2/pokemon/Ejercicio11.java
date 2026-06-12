package main.dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Ejercicio11 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon("Pikachu",   45),
            new Pokemon("Mewtwo",    88),
            new Pokemon("Dragonite", 82),
            new Pokemon("Squirtle",  38),
            new Pokemon("Gengar",    65),
            new Pokemon("Charizard", 78)
        );

        OptionalDouble promedio = pokemones.stream()
            .mapToDouble(p -> p.getPoderCombate())
            .average();

        if (promedio.isPresent()) {
            System.out.printf("Poder de combate promedio: %.2f%n", promedio.getAsDouble());
        }
    }
}