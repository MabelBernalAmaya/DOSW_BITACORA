package main.dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Ejercicio18 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon("Pikachu",   45),
            new Pokemon("Mewtwo",    88),
            new Pokemon("Dragonite", 82),
            new Pokemon("Squirtle",  38),
            new Pokemon("Gengar",    65),
            new Pokemon("Charizard", 78),
            new Pokemon("Alakazam",  75)
        );

        List<Pokemon> top5 = pokemones.stream()
            .sorted(Comparator.comparingDouble(p -> -p.getPoderCombate()))
            .limit(5)
            .collect(java.util.stream.Collectors.toList());

        AtomicInteger posicion = new AtomicInteger(1);
        top5.forEach(p ->
            System.out.println("#" + posicion.getAndIncrement()
                + " " + p.getNombre() + " - PC: " + (int)p.getPoderCombate())
        );
    }
}