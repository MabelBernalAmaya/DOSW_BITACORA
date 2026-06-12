package dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio6 {
    public static void main(String[] args) {
        List<String> pokemones = Arrays.asList(
            "Pikachu", "Charmander", "Pikachu",
            "Squirtle", "Charmander", "Mewtwo"
        );

        List<String> sinDuplicados = pokemones.stream()
            .distinct()
            .collect(Collectors.toList());

        System.out.println("Pokedex sin duplicados: " + sinDuplicados);
    }
}