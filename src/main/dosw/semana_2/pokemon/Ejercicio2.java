package main.dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio2 {
    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Pikachu", "Charmander", "Squirtle", "Bulbasaur");

        List<String> enMayusculas = nombres.stream()
            .map(n -> n.toUpperCase())
            .collect(Collectors.toList());

        System.out.println("Pokedex Gritona: " + enMayusculas);
    }
}