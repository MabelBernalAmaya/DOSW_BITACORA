package main.dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Ejercicio4 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon(1L, "Pikachu",    "Electrico", 45, 320, "Kanto", false, false),
            new Pokemon(2L, "Charmander", "Fuego",     30, 310, "Kanto", false, true),
            new Pokemon(3L, "Squirtle",   "Agua",      38, 280, "Kanto", false, true),
            new Pokemon(4L, "Snorlax",    "Normal",    90, 680, "Kanto", false, false),
            new Pokemon(5L, "Mewtwo",     "Psiquico",  88, 660, "Kanto", true,  false)
        );

        Optional<Pokemon> alfa = pokemones.stream()
            .max(Comparator.comparingInt(p -> p.getNivel()));

        if (alfa.isPresent()) {
            System.out.println("Pokemon Alfa: " + alfa.get().getNombre() + " (nivel " + alfa.get().getNivel() + ")");
        }
    }
}
