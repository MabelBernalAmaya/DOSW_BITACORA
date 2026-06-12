package main.dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio10 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon("Pikachu",   45),
            new Pokemon("Mewtwo",    88),
            new Pokemon("Dragonite", 82),
            new Pokemon("Squirtle",  38),
            new Pokemon("Gengar",    65),
            new Pokemon("Charizard", 78)
        );

        List<String> nombres = pokemones.stream()
            .map(p -> p.getNombre())
            .collect(Collectors.toList());

        System.out.println("Nombres del equipo: " + nombres);
    }
}