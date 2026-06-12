package main.dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio16 {
    public static void main(String[] args) {
        List<Entrenador> entrenadores = Arrays.asList(
            new Entrenador(1L, "Ash",   8,  null),
            new Entrenador(2L, "Misty", 5,  null),
            new Entrenador(3L, "Brock", 6,  null),
            new Entrenador(4L, "Gary",  10, null),
            new Entrenador(5L, "May",   3,  null),
            new Entrenador(6L, "Dawn",  7,  null)
        );

        List<String> experimentados = entrenadores.stream()
            .filter(e -> e.getMedallas() > 5)
            .map(e -> e.getNombre() + "(" + e.getMedallas() + ")")
            .collect(Collectors.toList());

        System.out.println("Entrenadores con > 5 medallas: " + experimentados);
    }
}