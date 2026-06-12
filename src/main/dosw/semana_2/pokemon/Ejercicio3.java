package main.dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;

public class Ejercicio3 {
    public static void main(String[] args) {
        List<Integer> niveles = Arrays.asList(45, 62, 38, 71, 55, 29);

        int total = niveles.stream()
            .reduce(0, (a, b) -> a + b);

        System.out.println("Suma total de niveles: " + total);
    }
}