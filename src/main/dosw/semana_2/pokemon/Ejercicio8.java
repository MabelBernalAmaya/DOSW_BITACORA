package dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio8 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon("Pikachu",   45),
            new Pokemon("Raichu",    60),
            new Pokemon("Charmander",30),
            new Pokemon("Charizard", 78),
            new Pokemon("Squirtle",  28),
            new Pokemon("Blastoise", 65)
        );

        List<String> listosParaEvolucionar = pokemones.stream()
            .filter(p -> p.isPuedeEvolucionar())
            .map(p -> p.getNombre())
            .collect(Collectors.toList());

        System.out.println("Listos para evolucionar: " + listosParaEvolucionar);
    }
}