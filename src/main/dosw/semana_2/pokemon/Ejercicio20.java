package main.dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Ejercicio20 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon("Pikachu",    45),
            new Pokemon("Mewtwo",     88),
            new Pokemon("Dragonite",  82),
            new Pokemon("Squirtle",   38),
            new Pokemon("Gengar",     65),
            new Pokemon("Charizard",  78),
            new Pokemon("Chikorita",  25),
            new Pokemon("Totodile",   23),
            new Pokemon("Lugia",      90),
            new Pokemon("Torchic",    22)
        );

        // Cantidad por tipo
        Map<String, Long> porTipo = pokemones.stream()
            .collect(Collectors.groupingBy(p -> p.getTipo(), Collectors.counting()));

        // Cantidad por region
        Map<Object\ porRegion = pokemones.stream()
            .collect(Collectors.groupingBy(p -> p.getRegion(), Collectors.counting()));

        // Total legendarios
        long legendarios = pokemones.stream()
            .filter(p -> p.isLegendario())
            .count();

        // Promedio de nivel
        OptionalDouble promedioNivel = pokemones.stream()
            .mapToInt(p -> p.getNivel())
            .average();

        // Pokemon mas fuerte
        Optional<Pokemon> masFuerte = pokemones.stream()
            .max(Comparator.comparingDouble(p -> p.getPoderCombate()));

        System.out.println("Por tipo:    " + porTipo);
        System.out.println("Por region:  " + porRegion);
        System.out.println("Legendarios: " + legendarios);
        if (promedioNivel.isPresent()) {
            System.out.printf("Promedio niv: %.1f%n", promedioNivel.getAsDouble());
        }
        if (masFuerte.isPresent()) {
            System.out.println("Mas fuerte:  " + masFuerte.get().getNombre()
                + " (PC: " + (int)masFuerte.get().getPoderCombate() + ")");
        }
    }
}