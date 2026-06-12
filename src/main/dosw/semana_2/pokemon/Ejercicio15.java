package main.dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Ejercicio15 {
    public static void main(String[] args) {
        List<Entrenador> entrenadores = Arrays.asList(
            new Entrenador(1L, "Ash",   8,  null),
            new Entrenador(2L, "Misty", 5,  null),
            new Entrenador(3L, "Brock", 6,  null),
            new Entrenador(4L, "Gary",  10, null)
        );

        Optional<Entrenador> campeon = entrenadores.stream()
            .max(Comparator.comparingInt(e -> e.getMedallas()));

        if (campeon.isPresent()) {
            System.out.println("Campeon de gimnasios: " + campeon.get().getNombre());
            System.out.println("Medallas obtenidas: " + campeon.get().getMedallas());
        }
    }
}