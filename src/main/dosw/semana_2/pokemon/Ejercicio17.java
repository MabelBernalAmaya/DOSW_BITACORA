package main.dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Ejercicio17 {
    public static void main(String[] args) {
        List<Pokemon> equipoAsh = Arrays.asList(
            new Pokemon("Pikachu",   45),
            new Pokemon("Charizard", 78),
            new Pokemon("Snorlax",   60),
            new Pokemon("Gengar",    65)
        );

        List<Pokemon> equipoGary = Arrays.asList(
            new Pokemon("Mewtwo",    88),
            new Pokemon("Dragonite", 82),
            new Pokemon("Arcanine",  70),
            new Pokemon("Alakazam",  75)
        );

        List<Pokemon> equipoBrock = Arrays.asList(
            new Pokemon("Onix",      50),
            new Pokemon("Geodude",   40),
            new Pokemon("Graveler",  55),
            new Pokemon("Golem",     65)
        );

        List<Entrenador> entrenadores = Arrays.asList(
            new Entrenador(1L, "Ash",   8, equipoAsh),
            new Entrenador(2L, "Gary",  10, equipoGary),
            new Entrenador(3L, "Brock", 6, equipoBrock)
        );

        Optional<Entrenador> masFuerte = entrenadores.stream()
            .max(Comparator.comparingDouble(e ->
                e.getEquipo().stream()
                    .mapToDouble(p -> p.getPoderCombate())
                    .sum()
            ));

        if (masFuerte.isPresent()) {
            double pcTotal = masFuerte.get().getEquipo().stream()
                .mapToDouble(p -> p.getPoderCombate())
                .sum();
            System.out.println("Entrenador mas poderoso: " + masFuerte.get().getNombre());
            System.out.println("Poder acumulado del equipo: " + (int)pcTotal);
        }
    }
}