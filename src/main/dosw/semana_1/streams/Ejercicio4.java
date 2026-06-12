package main.dosw.semana_1.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio4 {

    static class User {
        int id;
        String name;
        int age;
        boolean active;

        User(int id, String name, int age, boolean active) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.active = active;
        }
    }

    public static void main(String[] args) {
        List<User> users = Arrays.asList(
            new User(1, "carlos", 25, true),
            new User(2, "diana", 30, false),
            new User(3, "andres", 17, true),
            new User(4, "lucia", 28, true),
            new User(5, "pedro", 15, false)
        );

        List<String> mayores = users.stream()
            .filter(u -> u.age >= 18)
            .map(u -> u.name)
            .collect(Collectors.toList());

        System.out.println("Personas mayores de edad: " + mayores);
    }
}
