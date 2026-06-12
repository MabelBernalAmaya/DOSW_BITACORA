package main.dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Ejercicio19 {
    public static void main(String[] args) {
        List<Pokemon> equipoGary = Arrays.asList(
            new Pokemon("Mewtwo",    88),
            new Pokemon("Dragonite", 82),
            new Pokemon("Arcanine",  70),
            new Pokemon("Alakazam",  75)
        );

        List<Pokemon> equipoAsh = Arrays.asList(
            new Pokemon("Pikachu",   45),
            new Pokemon("Charizard", 78),
            new Pokemon("Snorlax",   60),
            new Pokemon("Gengar",    65)
        );

        List<Pokemon> equipoDawn = Arrays.asList(
            new Pokemon("Piplup",    20),
            new Pokemon("Togekiss",  70),
            new Pokemon("Mamoswine", 65),
            new Pokemon("Empoleon",  75)
        );

        List<Pokemon> equipoBrock = Arrays.asList(
            new Pokemon("Onix",    50),
            new Pokemon("Golem",   65),
            new Pokemon("Geodude", 40),
            new Pokemon("Graveler",55)
        );

        List<Entrenador> entrenadores = Arrays.asList(
            new Entrenador(1L, "Gary",  10, equipoGary),
            new Entrenador(2L, "Ash",   8,  equipoAsh),
            new Entrenador(3L, "Dawn",  7,  equipoDawn),
            new Entrenador(4L, "Brock", 6,  equipoBrock)
        );

        List<Entrenador> top3 = entrenadores.stream()
            .sorted(
                Comparator.comparingInt(Entrenador::getMedallas).reversed()
                    .thenComparingDouble((Entrenador e) ->
                        e.getEquipo().stream()
                            .mapToDouble(p -> p.getPoderCombate())
                            .sum()
                    ).reversed()
                    .thenComparing(Entrenador::getNombre)
            )
            .limit(3)
            .collect(Collectors.toList());

        AtomicInteger pos = new AtomicInteger(1);
        top3.forEach(e -> {
            double pcTotal = e.getEquipo().stream()
                .mapToDouble(p -> p.getPoderCombate())
                .sum();
            System.out.println("#" + pos.getAndIncrement()
                + " " + e.getNombre()
                + " - " + e.getMedallas() + " medallas"
                + ", PC: " + (int)pcTotal);
        });
    }
}