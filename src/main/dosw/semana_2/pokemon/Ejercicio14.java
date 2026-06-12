package main.dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio14 {
    
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon("Pikachu",    45),
            new Pokemon("Chikorita",  25),
            new Pokemon("Torchic",    22),
            new Pokemon("Piplup",     20),
            new Pokemon("Charmander", 30),
            new Pokemon("Totodile",   23)
        );

        Map<Object> porRegion = pokemones.stream()
            .collect(Collectors.groupingBy(
                p -> p.getRegion(),
                Collectors.mapping(p -> p.getNombre(), Collectors.toList())
            ));

        porRegion.forEach((region, lista) ->
            System.out.println(region + ": " + lista)
        );
    }
}