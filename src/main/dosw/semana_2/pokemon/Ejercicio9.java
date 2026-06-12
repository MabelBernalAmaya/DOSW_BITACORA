package main.dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio9 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon("Pikachu",   45),
            new Pokemon("Mewtwo",    88),
            new Pokemon("Dragonite", 82),
            new Pokemon("Squirtle",  38),
            new Pokemon("Gengar",    65),
            new Pokemon("Charizard", 78)
        );

        List<Pokemon> equipoElite = pokemones.stream()
            .filter(p -> p.getPoderCombate() > 500)
            .collect(Collectors.toList());

        System.out.println("Equipo Elite (PC > 500): " + equipoElite);
    }
}