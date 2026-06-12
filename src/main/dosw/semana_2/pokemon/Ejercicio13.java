package main.dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio13 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon("Squirtle",   28),
            new Pokemon("Psyduck",    30),
            new Pokemon("Charmander", 30),
            new Pokemon("Vulpix",     22),
            new Pokemon("Bulbasaur",  25)
        );

        Map<String, List<String>> porTipo = pokemones.stream()
            .collect(Collectors.groupingBy(
                p -> p.getTipo(),
                Collectors.mapping(p -> p.getNombre(), Collectors.toList())
            ));

        porTipo.forEach((tipo, lista) ->
            System.out.println(tipo + ": " + lista)
        );
    }
}