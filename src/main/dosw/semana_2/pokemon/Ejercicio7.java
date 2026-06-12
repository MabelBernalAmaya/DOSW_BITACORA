package main.dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio7 {
    public static void main(String[] args) {
        List<String> pokemones = Arrays.asList(
            "Squirtle", "Pikachu", "Mewtwo",
            "Bulbasaur", "Charmander", "Abra"
        );

        List<String> ordenados = pokemones.stream()
            .sorted()
            .collect(Collectors.toList());

        System.out.println("Pokedex ordenada: " + ordenados);
    }
}