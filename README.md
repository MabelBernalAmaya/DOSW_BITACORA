# SEMANA No 1 – DOSW Manejo de Streams

## Datos personales:
- Nombre: Mabel Bernal
- Código: 1000100629
- Curso: DOSW

---

### Ejercicio 01 – Números Pares mayores a diez

**Enunciado:** Dada una lista de números enteros, obtener solo los pares mayores a diez.

**Código implementado:**

```java
package dosw.semana_1.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio1 {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(3, 8, 10, 12, 15, 18, 20);

        List<Integer> resultado = numeros.stream()
            .filter(n -> n % 2 == 0)
            .filter(n -> n > 10)
            .collect(Collectors.toList());

        System.out.println("Números pares mayores a 10: " + resultado);
    }
}
```

**Captura de ejecución:** ![Ejercicio 1](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-2-mabel/evidencias/S1_ejercicio.png)

**Explicación:** Usé `.stream()` para convertir la lista en un flujo de datos. Después apliqué `.filter()` dos veces: una para quedarme con los números pares y otra para los mayores a 10. Al final `.collect()` junta los resultados en una lista nueva.

---

### Ejercicio 02 – Cantidad de palabras con más de 4 caracteres

**Enunciado:** Dada una lista de palabras, filtrar las que tengan más de 4 caracteres, convertirlas a mayúsculas, ordenarlas alfabéticamente y mostrar la cantidad total.

**Código implementado:**

```java
package dosw.semana_1.streams;

import java.util.List;

public class Ejercicio2 {
    public static void main(String[] args) {
        List<String> palabras = List.of("java", "stream", "api", "functional", "code", "git");

        long cantidad = palabras.stream()
            .filter(p -> p.length() > 4)
            .map(String::toUpperCase)
            .sorted()
            .count();

        System.out.println("Cantidad de palabras resultantes: " + cantidad);
    }
}
```

**Captura de ejecución:** ![Ejercicio 2](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-2-mabel/evidencias/s1_ejercicio2.png)

**Explicación:** Primero filtré las palabras con más de 4 letras, eso dejó fuera "java", "api", "code" y "git". Luego las pasé a mayúsculas con `.map()`, las ordené con `.sorted()` y conté cuántas quedaron con `.count()`. Solo "stream" y "functional" cumplen la condición, así que el resultado es 2.

---

### Ejercicio 03 – Obtener nombres de los Usuarios

**Enunciado:** Dada una lista de usuarios con atributos id, name, age y active, filtrar los activos, obtener sus nombres en mayúscula y ordenarlos alfabéticamente.

**Código implementado:**

```java
package dosw.semana_1.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio3 {

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
            new User(3, "andres", 22, true),
            new User(4, "lucia", 28, true),
            new User(5, "pedro", 19, false)
        );

        List<String> sortedUsers = users.stream()
            .filter(u -> u.active)
            .map(u -> u.name.toUpperCase())
            .sorted()
            .collect(Collectors.toList());

        System.out.println("Usuarios activos: " + sortedUsers);
    }
}
```

**Captura de ejecución:** ![Ejercicio 3](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-2-mabel/evidencias/s1_ejercicio3.png)

**Explicación:** Con `.filter()` me quedé solo con los usuarios que tienen `active = true`. Después `.map()` convierte cada nombre a mayúsculas, `.sorted()` los ordena de A a Z y `.collect()` arma la lista final.

---

### Ejercicio 04 – Personas mayores de edad

**Enunciado:** Dado el mismo listado de usuarios, filtrar las personas mayores de edad (18+) y obtener sus nombres.

**Código implementado:**

```java
package dosw.semana_1.streams;

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
```

**Captura de ejecución:** ![Ejercicio 4](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-2-mabel/evidencias/s1_ejercicio4.png)

**Explicación:** Usé `.filter()` para comparar la edad de cada usuario con 18. Los que pasan el filtro se les extrae el nombre con `.map()` y al final `.collect()` los agrupa en una lista.

---

### Ejercicio 05 – Transacciones Bancarias

**Enunciado:** Dada una lista de transacciones con id, amount y approved, usar `peek()` para ver cada transacción procesada y verificar si existe alguna no aprobada con `anyMatch()`.

**Código implementado:**

```java
package dosw.semana_1.streams;

import java.util.Arrays;
import java.util.List;

public class Ejercicio5 {

    static class Transaction {
        String id;
        double amount;
        boolean approved;

        Transaction(String id, double amount, boolean approved) {
            this.id = id;
            this.amount = amount;
            this.approved = approved;
        }

        public String toString() {
            return "Transaction{id=" + id + ", amount=" + amount + ", approved=" + approved + "}";
        }
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("T001", 150.0, true),
            new Transaction("T002", 320.5, false),
            new Transaction("T003", 80.0, true),
            new Transaction("T004", 500.0, true)
        );

        boolean hayNoAprobada = transactions.stream()
            .peek(t -> System.out.println("Procesando: " + t))
            .anyMatch(t -> !t.approved);

        System.out.println("¿Lote válido (sin transacciones no aprobadas)? " + !hayNoAprobada);
    }
}
```

**Captura de ejecución:** ![Ejercicio 5](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-2-mabel/evidencias/s1_ejercicio5.png)

**Explicación:** `.peek()` me sirvió para ver por consola cada transacción mientras el Stream la procesa, sin cambiar nada. Después `.anyMatch()` revisa si hay alguna con `approved = false`. Si encuentra una, el lote no es válido, por eso imprimo el negado `!hayNoAprobada`.

---

# SEMANA No 2 – Bitácora Pokémon

## Datos de Entrenador:
- Nombre: Mabel Bernal
- Código: 1000100629
- Curso: DOSW

---

### Ejercicio 01 – Pokémon Tipo Fuego

**Enunciado:** Dada una lista de Pokémon con nombre y tipo, obtener únicamente aquellos cuyo tipo sea Fuego.

**Código implementado:**

```java
package dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio1 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon(1L, "Pikachu",    "Electrico", 45, 320, "Kanto", false, false),
            new Pokemon(2L, "Charmander", "Fuego",     30, 310, "Kanto", false, true),
            new Pokemon(3L, "Squirtle",   "Agua",      28, 280, "Kanto", false, true),
            new Pokemon(4L, "Vulpix",     "Fuego",     22, 260, "Kanto", false, true),
            new Pokemon(5L, "Bulbasaur",  "Planta",    25, 270, "Kanto", false, true),
            new Pokemon(6L, "Flareon",    "Fuego",     50, 440, "Kanto", false, false)
        );

        List<String> tipoFuego = pokemones.stream()
            .filter(p -> p.getTipo().equals("Fuego"))
            .map(p -> p.getNombre())
            .collect(Collectors.toList());

        System.out.println("Pokemon tipo Fuego: " + tipoFuego);
    }
}
```

**Captura de ejecución:** ![Ejercicio 1](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-2-mabel/evidencias/s2_ejercicio1.png)

**Explicación:** Con `.filter()` comparo el tipo de cada Pokémon contra "Fuego" y descarto los demás. Luego `.map()` saca solo el nombre y `.collect()` arma la lista final.

---

### Ejercicio 02 – Pokédex Gritona

**Enunciado:** Transformar todos los nombres de Pokémon a mayúsculas.

**Código implementado:**

```java
package dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio2 {
    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Pikachu", "Charmander", "Squirtle", "Bulbasaur");

        List<String> enMayusculas = nombres.stream()
            .map(n -> n.toUpperCase())
            .collect(Collectors.toList());

        System.out.println("Pokedex Gritona: " + enMayusculas);
    }
}
```

**Captura de ejecución:** ![Ejercicio 2](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-2-mabel/evidencias/s2_ejercicio2.png)

**Explicación:** Solo usé `.map()` para aplicarle `toUpperCase()` a cada nombre. Es el ejercicio más directo de todos, no necesita filtrar nada.

---

### Ejercicio 03 – Poder Total del Equipo

**Enunciado:** Dada una lista de niveles de Pokémon, calcular la suma total de niveles del equipo.

**Código implementado:**

```java
package dosw.semana_2.pokemon;

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
```

**Captura de ejecución:** ![Ejercicio 3](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-2-mabel/evidencias/s2_ejercicio3.png)

**Explicación:** Usé `.reduce()` que va acumulando la suma de a un número por vez, empezando desde 0. Al recorrer toda la lista termina con el total, que en este caso es 300.

---

### Ejercicio 04 – Pokémon Alfa

**Enunciado:** Encontrar el Pokémon con el nivel más alto dentro del equipo.

**Código implementado:**

```java
package dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Ejercicio4 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon(1L, "Pikachu",    "Electrico", 45, 320, "Kanto", false, false),
            new Pokemon(2L, "Charmander", "Fuego",     30, 310, "Kanto", false, true),
            new Pokemon(3L, "Squirtle",   "Agua",      38, 280, "Kanto", false, true),
            new Pokemon(4L, "Snorlax",    "Normal",    90, 680, "Kanto", false, false),
            new Pokemon(5L, "Mewtwo",     "Psiquico",  88, 660, "Kanto", true,  false)
        );

        Optional<Pokemon> alfa = pokemones.stream()
            .max(Comparator.comparingInt(p -> p.getNivel()));

        if (alfa.isPresent()) {
            System.out.println("Pokemon Alfa: " + alfa.get().getNombre()
                + " (nivel " + alfa.get().getNivel() + ")");
        }
    }
}
```

**Captura de ejecución:** ![Ejercicio 4](evidencias/s2_ejercicio4.png)

**Explicación:** `.max()` recorre la lista y se queda con el Pokémon que tenga el nivel más alto según el `Comparator`. Devuelve un `Optional` por si la lista estuviera vacía, así que antes de imprimir verifico con `.isPresent()`.

---

### Ejercicio 05 – Pokémon Legendarios

**Enunciado:** Contar cuántos Pokémon del equipo tienen nivel superior a 80.

**Código implementado:**

```java
package dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio5 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon(1L, "Pikachu",    "Electrico", 45, 320, "Kanto", false, false),
            new Pokemon(2L, "Mewtwo",     "Psiquico",  88, 680, "Kanto", true,  false),
            new Pokemon(3L, "Dragonite",  "Dragon",    82, 530, "Kanto", false, false),
            new Pokemon(4L, "Squirtle",   "Agua",      38, 210, "Kanto", false, true),
            new Pokemon(5L, "Mew",        "Psiquico",  85, 600, "Kanto", true,  false),
            new Pokemon(6L, "Charmander", "Fuego",     62, 400, "Kanto", false, true)
        );

        long cantidad = pokemones.stream()
            .filter(p -> p.getNivel() > 80)
            .count();

        List<String> nombres = pokemones.stream()
            .filter(p -> p.getNivel() > 80)
            .map(p -> p.getNombre())
            .collect(Collectors.toList());

        System.out.println("Pokemon con nivel > 80: " + cantidad);
        System.out.println(nombres);
    }
}
```

**Captura de ejecución:** ![Ejercicio 5](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-2-mabel/evidencias/s2_ejercicio5.png)

**Explicación:** Hice dos Streams sobre la misma lista: uno para contar con `.count()` y otro para sacar los nombres con `.map()`. Los dos aplican el mismo `.filter()` de nivel mayor a 80.

---

### Ejercicio 06 – Pokédex Sin Duplicados

**Enunciado:** Dada una lista con Pokémon repetidos, generar una colección donde cada uno aparezca una sola vez.

**Código implementado:**

```java
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
```

**Captura de ejecución:** ![Ejercicio 6](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-2-mabel/evidencias/s2_ejercicio6.png)

**Explicación:** `.distinct()` se encarga solo de eliminar los duplicados, conserva la primera aparición de cada elemento y descarta las repetidas.

---

### Ejercicio 07 – Orden del Profesor Oak

**Enunciado:** Ordenar alfabéticamente los nombres de los Pokémon.

**Código implementado:**

```java
package dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio7 {
    public static void main(String[] args) {
        List<String> pokemones = Arrays.asList(
            "Squirtle", "Pikachu", "Mewtwo",
            "Bulbasaur", "Charmander", "Abra"
        );

        List<String> ordenados = pokemones.stream()
            .sorted()
            .collect(Collectors.toList());

        System.out.println("Pokedex ordenada: " + ordenados);
    }
}
```

**Captura de ejecución:** ![Ejercicio 7](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-2-mabel/evidencias/s2_ejercicio7.png)

**Explicación:** `.sorted()` sin argumentos ordena los String de forma alfabética natural. La lista queda de Abra hasta Squirtle.

---

### Ejercicio 08 – Evoluciones Preparadas

**Enunciado:** Dada una lista de Pokémon con el atributo `puedeEvolucionar`, obtener únicamente los que están listos.

**Código implementado:**

```java
package dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio8 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon(1L, "Pikachu",    "Electrico", 45, 320, "Kanto", false, true),
            new Pokemon(2L, "Raichu",     "Electrico", 60, 485, "Kanto", false, false),
            new Pokemon(3L, "Charmander", "Fuego",     30, 310, "Kanto", false, true),
            new Pokemon(4L, "Charizard",  "Fuego",     78, 600, "Kanto", false, false),
            new Pokemon(5L, "Squirtle",   "Agua",      28, 280, "Kanto", false, true),
            new Pokemon(6L, "Blastoise",  "Agua",      65, 530, "Kanto", false, false)
        );

        List<String> listosParaEvolucionar = pokemones.stream()
            .filter(p -> p.isPuedeEvolucionar())
            .map(p -> p.getNombre())
            .collect(Collectors.toList());

        System.out.println("Listos para evolucionar: " + listosParaEvolucionar);
    }
}
```

**Captura de ejecución:** ![Ejercicio 8](evidencias/s2_ejercicio8.png)

**Explicación:** `.filter()` revisa el atributo `puedeEvolucionar` de cada Pokémon. Los que tienen `true` pasan, los demás no. Luego `.map()` extrae solo el nombre de cada uno.

---

### Ejercicio 09 – Equipo Élite

**Enunciado:** Mostrar únicamente los Pokémon cuyo `poderCombate` sea superior a 500.

**Código implementado:**

```java
package dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio9 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon(1L, "Pikachu",   "Electrico", 45, 320, "Kanto", false, false),
            new Pokemon(2L, "Mewtwo",    "Psiquico",  88, 680, "Kanto", true,  false),
            new Pokemon(3L, "Dragonite", "Dragon",    82, 530, "Kanto", false, false),
            new Pokemon(4L, "Squirtle",  "Agua",      38, 210, "Kanto", false, true),
            new Pokemon(5L, "Gengar",    "Fantasma",  65, 495, "Kanto", false, false),
            new Pokemon(6L, "Charizard", "Fuego",     78, 610, "Kanto", false, false)
        );

        List<Pokemon> equipoElite = pokemones.stream()
            .filter(p -> p.getPoderCombate() > 500)
            .collect(Collectors.toList());

        System.out.println("Equipo Elite (PC > 500): " + equipoElite);
    }
}
```

**Captura de ejecución:** ![Ejercicio 9](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-2-mabel/evidencias/s2_ejercicio9.png)

**Explicación:** Filtré por `poderCombate > 500` y los que pasan quedan en la lista. Mewtwo con 680, Charizard con 610 y Dragonite con 530 son los únicos que superan ese umbral.

---

### Ejercicio 10 – Pokédex Compacta

**Enunciado:** Generar una lista que contenga únicamente los nombres de todos los Pokémon del equipo.

**Código implementado:**

```java
package dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio10 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon(1L, "Pikachu",   "Electrico", 45, 320, "Kanto", false, false),
            new Pokemon(2L, "Mewtwo",    "Psiquico",  88, 680, "Kanto", true,  false),
            new Pokemon(3L, "Dragonite", "Dragon",    82, 530, "Kanto", false, false),
            new Pokemon(4L, "Squirtle",  "Agua",      38, 210, "Kanto", false, true),
            new Pokemon(5L, "Gengar",    "Fantasma",  65, 495, "Kanto", false, false),
            new Pokemon(6L, "Charizard", "Fuego",     78, 610, "Kanto", false, false)
        );

        List<String> nombres = pokemones.stream()
            .map(p -> p.getNombre())
            .collect(Collectors.toList());

        System.out.println("Nombres del equipo: " + nombres);
    }
}
```

**Captura de ejecución:** ![Ejercicio 10](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-2-mabel/evidencias/s2_ejercicio10.png)

**Explicación:** Solo usé `.map()` para transformar cada objeto `Pokemon` en su nombre. No hace falta filtrar nada porque quiero todos.

---

### Ejercicio 11 – Poder Promedio

**Enunciado:** Calcular el promedio de `poderCombate` de todos los Pokémon del equipo.

**Código implementado:**

```java
package dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Ejercicio11 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon(1L, "Pikachu",   "Electrico", 45, 320, "Kanto", false, false),
            new Pokemon(2L, "Mewtwo",    "Psiquico",  88, 680, "Kanto", true,  false),
            new Pokemon(3L, "Dragonite", "Dragon",    82, 530, "Kanto", false, false),
            new Pokemon(4L, "Squirtle",  "Agua",      38, 210, "Kanto", false, true),
            new Pokemon(5L, "Gengar",    "Fantasma",  65, 495, "Kanto", false, false),
            new Pokemon(6L, "Charizard", "Fuego",     78, 610, "Kanto", false, false)
        );

        OptionalDouble promedio = pokemones.stream()
            .mapToDouble(p -> p.getPoderCombate())
            .average();

        if (promedio.isPresent()) {
            System.out.printf("Poder de combate promedio: %.2f%n", promedio.getAsDouble());
        }
    }
}
```

**Captura de ejecución:** ![Ejercicio 11](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-2-mabel/evidencias/s2_ejercicio11.png)

**Explicación:** `.mapToDouble()` convierte el Stream de objetos en un stream de números decimales con los valores de `poderCombate`. Luego `.average()` calcula el promedio y lo retorna como `OptionalDouble` por si la lista estuviera vacía.

---

### Ejercicio 12 – Campeón Regional

**Enunciado:** Obtener el Pokémon con mayor `poderCombate` de toda la lista.

**Código implementado:**

```java
package dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Ejercicio12 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon(1L, "Pikachu",   "Electrico", 45, 320, "Kanto", false, false),
            new Pokemon(2L, "Mewtwo",    "Psiquico",  88, 680, "Kanto", true,  false),
            new Pokemon(3L, "Dragonite", "Dragon",    82, 530, "Kanto", false, false),
            new Pokemon(4L, "Charizard", "Fuego",     78, 610, "Kanto", false, false)
        );

        Optional<Pokemon> campeon = pokemones.stream()
            .max(Comparator.comparingDouble(p -> p.getPoderCombate()));

        if (campeon.isPresent()) {
            System.out.println("Campeon: " + campeon.get().getNombre()
                + " con PC: " + (int)campeon.get().getPoderCombate());
        }
    }
}
```

**Captura de ejecución:** ![Ejercicio 12](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-2-mabel/evidencias/s2_ejercicio12.png)

**Explicación:** `.max()` con `Comparator.comparingDouble()` recorre la lista comparando el `poderCombate` de cada Pokémon y se queda con el más alto. El resultado es Mewtwo con 680.

---

### Ejercicio 13 – Organizar por Tipo

**Enunciado:** Agrupar todos los Pokémon por su tipo y mostrar el listado por grupo.

**Código implementado:**

```java
package dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio13 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon(1L, "Squirtle",   "Agua",   28, 280, "Kanto", false, true),
            new Pokemon(2L, "Psyduck",    "Agua",   30, 270, "Kanto", false, true),
            new Pokemon(3L, "Charmander", "Fuego",  30, 310, "Kanto", false, true),
            new Pokemon(4L, "Vulpix",     "Fuego",  22, 260, "Kanto", false, true),
            new Pokemon(5L, "Bulbasaur",  "Planta", 25, 270, "Kanto", false, true)
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
```

**Captura de ejecución:** ![Ejercicio 13](evidencias/s2_ejercicio13.png)

**Explicación:** `groupingBy()` agrupa los Pokémon usando el tipo como clave del mapa. Dentro uso `Collectors.mapping()` para que en cada grupo solo queden los nombres y no los objetos completos.

---

### Ejercicio 14 – Organizar por Región

**Enunciado:** Agrupar los Pokémon según su región de origen.

**Código implementado:**

```java
package dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio14 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon(1L, "Pikachu",    "Electrico", 45, 320, "Kanto",  false, false),
            new Pokemon(2L, "Chikorita",  "Planta",    25, 250, "Johto",  false, true),
            new Pokemon(3L, "Torchic",    "Fuego",     22, 240, "Hoenn",  false, true),
            new Pokemon(4L, "Piplup",     "Agua",      20, 235, "Sinnoh", false, true),
            new Pokemon(5L, "Charmander", "Fuego",     30, 310, "Kanto",  false, true),
            new Pokemon(6L, "Totodile",   "Agua",      23, 245, "Johto",  false, true)
        );

        Map<String, List<String>> porRegion = pokemones.stream()
            .collect(Collectors.groupingBy(
                p -> p.getRegion(),
                Collectors.mapping(p -> p.getNombre(), Collectors.toList())
            ));

        porRegion.forEach((region, lista) ->
            System.out.println(region + ": " + lista)
        );
    }
}
```

**Captura de ejecución:** ![Ejercicio 14](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-2-mabel/evidencias/s2_ejercicio15.png)

**Explicación:** Es igual al ejercicio 13 pero agrupando por región en vez de tipo. Cada clave del mapa es una región y el valor es la lista de Pokémon que pertenecen a ella.

---

### Ejercicio 15 – Maestro de Gimnasios

**Enunciado:** Dado un listado de entrenadores con sus medallas, encontrar el entrenador con más medallas.

**Código implementado:**

```java
package dosw.semana_2.pokemon;

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
```

**Captura de ejecución:** ![Ejercicio 15](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-2-mabel/evidencias/s2_ejercicio15.png)

**Explicación:** `.max()` compara los entrenadores por número de medallas y devuelve el que tenga más. Gary gana con 10 medallas.

---

### Ejercicio 16 – Entrenadores Experimentados

**Enunciado:** Mostrar únicamente los entrenadores que posean más de 5 medallas.

**Código implementado:**

```java
package dosw.semana_2.pokemon;

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
```

**Captura de ejecución:** ![Ejercicio 16](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-2-mabel/evidencias/s2_ejercicio16.png)

**Explicación:** `.filter()` descarta a Misty (5), May (3) porque no superan el umbral. Los que pasan se formatean con `.map()` mostrando nombre y medallas juntos.

---

### Ejercicio 17 – Equipo Más Poderoso

**Enunciado:** Calcular cuál entrenador tiene la suma total de `poderCombate` más alta entre todos sus Pokémon.

**Código implementado:**

```java
package dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Ejercicio17 {
    public static void main(String[] args) {
        List<Pokemon> equipoAsh = Arrays.asList(
            new Pokemon(1L, "Pikachu",   "Electrico", 45, 320, "Kanto", false, false),
            new Pokemon(2L, "Charizard", "Fuego",     78, 610, "Kanto", false, false),
            new Pokemon(3L, "Snorlax",   "Normal",    60, 500, "Kanto", false, false),
            new Pokemon(4L, "Gengar",    "Fantasma",  65, 420, "Kanto", false, false)
        );

        List<Pokemon> equipoGary = Arrays.asList(
            new Pokemon(5L, "Mewtwo",    "Psiquico",  88, 680, "Kanto", true,  false),
            new Pokemon(6L, "Dragonite", "Dragon",    82, 530, "Kanto", false, false),
            new Pokemon(7L, "Arcanine",  "Fuego",     70, 560, "Kanto", false, false),
            new Pokemon(8L, "Alakazam",  "Psiquico",  75, 570, "Kanto", false, false)
        );

        List<Pokemon> equipoBrock = Arrays.asList(
            new Pokemon(9L,  "Onix",     "Roca", 50, 390, "Kanto", false, false),
            new Pokemon(10L, "Geodude",  "Roca", 40, 310, "Kanto", false, true),
            new Pokemon(11L, "Graveler", "Roca", 55, 440, "Kanto", false, true),
            new Pokemon(12L, "Golem",    "Roca", 65, 530, "Kanto", false, false)
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
```

**Captura de ejecución:** ![Ejercicio 17](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-2-mabel/evidencias/s2_ejercicio17.png)

**Explicación:** Dentro del `.max()` uso un Stream anidado que suma el `poderCombate` del equipo de cada entrenador. El `.max()` externo compara esas sumas y devuelve al entrenador con el total más alto.

---

### Ejercicio 18 – Top 5 Pokémon Más Fuertes

**Enunciado:** Generar un ranking de los cinco Pokémon con mayor `poderCombate` de toda la Pokédex.

**Código implementado:**

```java
package dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Ejercicio18 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon(1L, "Pikachu",   "Electrico", 45, 320, "Kanto", false, false),
            new Pokemon(2L, "Mewtwo",    "Psiquico",  88, 680, "Kanto", true,  false),
            new Pokemon(3L, "Dragonite", "Dragon",    82, 530, "Kanto", false, false),
            new Pokemon(4L, "Squirtle",  "Agua",      38, 210, "Kanto", false, true),
            new Pokemon(5L, "Gengar",    "Fantasma",  65, 495, "Kanto", false, false),
            new Pokemon(6L, "Charizard", "Fuego",     78, 610, "Kanto", false, false),
            new Pokemon(7L, "Alakazam",  "Psiquico",  75, 570, "Kanto", false, false)
        );

        List<Pokemon> top5 = pokemones.stream()
            .sorted(Comparator.comparingDouble(p -> -p.getPoderCombate()))
            .limit(5)
            .collect(Collectors.toList());

        AtomicInteger posicion = new AtomicInteger(1);
        top5.forEach(p ->
            System.out.println("#" + posicion.getAndIncrement()
                + " " + p.getNombre() + " - PC: " + (int)p.getPoderCombate())
        );
    }
}
```

**Captura de ejecución:** ![Ejercicio 18](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-2-mabel/evidencias/s2_ejercicio18.png)

**Explicación:** Le puse negativo al `poderCombate` en el `.sorted()` para que ordene de mayor a menor. Luego `.limit(5)` corta los primeros cinco. Usé `AtomicInteger` para el número de posición porque dentro de un lambda no puedo usar una variable normal que cambie.

---

### Ejercicio 19 – Top 3 Entrenadores

**Enunciado:** Generar un ranking de los 3 mejores entrenadores considerando: primero más medallas, segundo mayor poder acumulado, tercero orden alfabético como desempate.

**Código implementado:**

```java
package dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Ejercicio19 {
    public static void main(String[] args) {
        List<Pokemon> equipoGary = Arrays.asList(
            new Pokemon(1L, "Mewtwo",    "Psiquico", 88, 680, "Kanto", true,  false),
            new Pokemon(2L, "Dragonite", "Dragon",   82, 530, "Kanto", false, false),
            new Pokemon(3L, "Arcanine",  "Fuego",    70, 560, "Kanto", false, false),
            new Pokemon(4L, "Alakazam",  "Psiquico", 75, 570, "Kanto", false, false)
        );

        List<Pokemon> equipoAsh = Arrays.asList(
            new Pokemon(5L, "Pikachu",   "Electrico", 45, 320, "Kanto", false, false),
            new Pokemon(6L, "Charizard", "Fuego",     78, 610, "Kanto", false, false),
            new Pokemon(7L, "Snorlax",   "Normal",    60, 500, "Kanto", false, false),
            new Pokemon(8L, "Gengar",    "Fantasma",  65, 420, "Kanto", false, false)
        );

        List<Pokemon> equipoDawn = Arrays.asList(
            new Pokemon(9L,  "Piplup",    "Agua",  20, 235, "Sinnoh", false, true),
            new Pokemon(10L, "Togekiss",  "Hada",  70, 560, "Sinnoh", false, false),
            new Pokemon(11L, "Mamoswine", "Hielo", 65, 530, "Sinnoh", false, false),
            new Pokemon(12L, "Empoleon",  "Agua",  75, 775, "Sinnoh", false, false)
        );

        List<Pokemon> equipoBrock = Arrays.asList(
            new Pokemon(13L, "Onix",     "Roca", 50, 390, "Kanto", false, false),
            new Pokemon(14L, "Golem",    "Roca", 65, 530, "Kanto", false, false),
            new Pokemon(15L, "Geodude",  "Roca", 40, 310, "Kanto", false, true),
            new Pokemon(16L, "Graveler", "Roca", 55, 440, "Kanto", false, true)
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
```

**Captura de ejecución:** ![Ejercicio 19](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-2-mabel/evidencias/s2_ejercicio19.png)

**Explicación:** Encadené tres criterios en el `.sorted()`: primero ordeno por medallas de mayor a menor, luego por poder acumulado de mayor a menor y por último alfabéticamente como desempate. `.limit(3)` corta los tres primeros.

---

### Ejercicio 20 – Pokédex Analítica

**Enunciado:** Construir una estructura que muestre cantidad de Pokémon por tipo, por región, cantidad de legendarios, promedio de nivel y el Pokémon más fuerte. Todo usando únicamente Streams.

**Código implementado:**

```java
package dosw.semana_2.pokemon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Ejercicio20 {
    public static void main(String[] args) {
        List<Pokemon> pokemones = Arrays.asList(
            new Pokemon(1L,  "Pikachu",   "Electrico", 45, 320, "Kanto", false, false),
            new Pokemon(2L,  "Mewtwo",    "Psiquico",  88, 680, "Kanto", true,  false),
            new Pokemon(3L,  "Dragonite", "Dragon",    82, 530, "Kanto", false, false),
            new Pokemon(4L,  "Squirtle",  "Agua",      38, 210, "Kanto", false, true),
            new Pokemon(5L,  "Gengar",    "Fantasma",  65, 495, "Kanto", false, false),
            new Pokemon(6L,  "Charizard", "Fuego",     78, 610, "Kanto", false, false),
            new Pokemon(7L,  "Chikorita", "Planta",    25, 250, "Johto", false, true),
            new Pokemon(8L,  "Totodile",  "Agua",      23, 245, "Johto", false, true),
            new Pokemon(9L,  "Lugia",     "Psiquico",  90, 700, "Johto", true,  false),
            new Pokemon(10L, "Torchic",   "Fuego",     22, 240, "Hoenn", false, true)
        );

        Map<String, Long> porTipo = pokemones.stream()
            .collect(Collectors.groupingBy(p -> p.getTipo(), Collectors.counting()));

        Map<String, Long> porRegion = pokemones.stream()
            .collect(Collectors.groupingBy(p -> p.getRegion(), Collectors.counting()));

        long legendarios = pokemones.stream()
            .filter(p -> p.isLegendario())
            .count();

        OptionalDouble promedioNivel = pokemones.stream()
            .mapToInt(p -> p.getNivel())
            .average();

        Optional<Pokemon> masFuerte = pokemones.stream()
            .max(Comparator.comparingDouble(p -> p.getPoderCombate()));

        System.out.println("Por tipo:    " + porTipo);
        System.out.println("Por region:  " + porRegion);
        System.out.println("Legendarios: " + legendarios);
        if (promedioNivel.isPresent()) {
            System.out.printf("Promedio niv: %.1f%n", promedioNivel.getAsDouble());
        }
        if (masFuerte.isPresent()) {
            System.out.println("Mas fuerte:  " + masFuerte.get().getNombre()
                + " (PC: " + (int)masFuerte.get().getPoderCombate() + ")");
        }
    }
}
```

**Captura de ejecución:** ![Ejercicio 20](evidencias/s2_ejercicio20.png)

**Explicación:** Este ejercicio usa cinco Streams sobre la misma lista para sacar diferentes estadísticas: `groupingBy` con `counting()` para contar por tipo y región, `filter` + `count` para los legendarios, `mapToInt` + `average` para el promedio de nivel y `max` para encontrar el más fuerte.

---

## Semana 3

### Ejercicio 1 - Diagrama de Clases
intento de Diagrama de clases  Pokémon y las visitas al Centro Pokémon.
![ Pokemon](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-3-mabel-ejercicio1-diagrama/evidencias/pokemon.jpg)
![Diagrama de Clases Pokemon](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-3-mabel-ejercicio1-diagrama/evidencias/Diagrama%20de%20clases%20Ejercicio%20Pokemon.png)

# Taller de Refuerzo Patrones - Semana 3 DOSW

Ejercicios de Refuerzo — Patrones de Diseño Combinado

## Ejercicio 1: Plataforma de pagos inteligentes
### 1. ANALISIS DE PROBLEMA PLANTEADO
Es una plataforma que tiene diferentes métodos de pago como tarjeta PSE Nequi PayPal entre otras, y dependiendo del usuario y su nacionalidad se usan métodos diferentes para hacer el pago.
Sin aplicar ningún patron el código estaría lleno de IF y ELSE ya que si el tipo de pago es igual a PSE procesa el pago si no es pse si no nequi procesa diferente el pago y pasa lo mismo con los usuarios, y hasta ahí funcionaria bien, pero si llegaran a crear mas formas de pago y mas nacionalidades de usuarios tendríamos que pasar a modificar el código teniendo más IF y ELSE.
Así violaría el principio Open/Closed el cual nos dice que el código debe estar abierto a extensión y cerrado a modificación ya que así cada vez que agreguemos métodos o nacionalidades nuevas nos obliga a modificar código ya existente.

### 2. DISEÑOS PRESENTES
PATRONES USADOS
* **Strategy:** nos permite saber como se realiza el pago dependiendo de cada método de pago elegido.
  Ejemplo:
    * TARJETA: Valida la tarjeta – Cobra el total – Confirma el pago
    * PSE: Conecta con el banco solicitado – Autoriza – Confirma el pago
      Como podemos ver son algoritmos distintos para cada pago, pero son independientes.
* **Factory Method:** Es el que crea los objetos o la plantilla para que strategy lo pueda usar, entonces si el cliente es colombiano no se crea un nuevo método para cada colombiano si no que se usa la plantilla para cliente colombiano y procesa el pago.

### 3. QUE PATRONES PODRIAN APLICARSE
También podemos usar Abstract Factory porque en cada método por país hay varias formas de pago por ejemplo en Colombia podemos pagar por PSE o por nequi, y podemos verlo como una familia de productos.

### 4. JUSTIFICACION DE PATRON SELECCIONADO
Abstract Factory nos ayuda a gupar los métodos de pago que están relacionados en este caso los de la misma nacionalidad lo que hace que sea escalable cuando existen varios métodos de pago en el mismo país. Pero el patron de method es suficiente ya que solo se necesita crear la estrategia de pago y no varias estrategias con pago facturación y así.

### 5. EJECUCION DEL CODIGO
![ Ejercicio 1 ](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-3-mabel/evidencias/ejecucion%20ejercicio%201%20.png)

---

## Ejercicio 2. Sistema de Notificaciones Multicanal
### 1. ANALISIS DEL PROBLEMA PLANTEADO
Es una empresa la cual envía notificaciones por medio de diferentes canales ya sea por Wpp. SMS, Push Notification entonces cuando se genera un evento importante los canales deben recibir el aviso cuando se cambie el estado. Inicialmente podríamos usar if en todo el código para que se envie a correo otro if para que se envie en sms y otro para enviar wpp, pero entonces cuando se quiera agregar mas plataformas para enviar la notificación toca modificar el código y se va a ver desordenado.
Entonces si en grupo alguien escribe que hay reunión mañana no le envía la notificación a cada persona si no que simplemente la publica y todos reciben la información por eso se usa el patrón Observer.

### 2. DISEÑOS PRESENTES
PATRONES USADOS
* **Observer:** Es el que permite que varios objetos se modifiquen cuando ocurre un evento, puede ser cuando cambia el estado de un pedido a confirmado y se modifican todas.
* **Factory Method:** Es la que crea cada método de los canales de notificación.

### 3. QUE PATRONES PODRIAN APLICARSE Y JUSTIFICACION
Se podría usar strategy para crear el algoritmo a cada clase de correo wpp y de más, porque Factory solo crea los objetos, pero no avisa automáticamente, y Observer se crea la automatización ero igual toca hacerlo manualmente por eso ese solo patron no sirve.

### 4. EJECUCION CODIGO

![ Ejercicio 2 ](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-3-mabel/evidencias/ejecucion%20ejercicio%202%20.png
)

## Ejercicio 3: Reportes empresariales
### 1. ANALISIS DEL PROBLEMA PLANTEADO
La empresa genera reportes, pero usa diferentes formatos como PDF, Exel CVS, cada reporte sigue el mismo proceso lo que cambia es el formato que se elija sin patrones el código estaría lleno de if para hacer el proceso lo que hace que hallan duplicados y demás permite reutilizar pasos comunes

### 2. DISEÑOS PRESENTES
* **Template Method:** es el que le da los pasos a seguir al algoritmo para que funcione en orden. Teniendo en cuenta que los pasos que se hacen es 1 obtener los datos para el reporte 2 procesar los datos-3 aplicar formato y 4 exportar. Los pasos 1 y 2 se repiten en todos los formatos, pero ya el 3 y 4 no.
* **Factory Method:** ese patron es el que crea las clases de reportepdf, reporte exel y reporte cvs para que no se cree un método nuevo si no que se implemente ya el que esta cuando se necesite.

### 3. PATRONES QUE PODRIAN USARSE y JUSTIFICACION
Builder se podría usar si cada reporte tuviera más características como el logo graficas tablas y demás, pero el ejercicio solo menciona un flujo común con pasos ya fijos, también se podría usar strategy ya que así reemplaza el algoritmo según se requiera, pero en este caso témplate define ya una plantilla fija para usar en el algoritmo.

### 4. CODIGO EJECUTANDO
![ Ejercicio 3 ](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-3-mabel/evidencias/ejecucion%20ejercicio%203%20.png)

## Ejercicio 4: videojuego de Personajes
### 1. ANALISIS DE PROBLEMA PLANTEADO
Cada tipo de jugador en el juego tiene la capacidad de mejorar conforme va pasando el juego, si no usamos patrones podríamos crear clases para cada tipo de mejora de el jugador.
* Si es guerrero habría, GuerreroConEspada, GuerreroConEscudo, GuerreroConEspadaYEscudo lo mismo con el jugador de Mago esto nos va a generar demasiadas clases por cada personaje y mejora.

### 2. DISEÑOS PRESENTES
* **Builder:** nos ayuda a construir el personaje paso a paso, para evitar construcciones pesadas de personajes y así crearlos más fácilmente.
* **Decorator:** nos permite agregar habilidades o mejoras sin modificar la clase original por eso sirve para el jugador si quiere agregar espada o escudo y así sin tener que modificar la clase base del jugador.

### 3. QUE PATRON PODRIA USARSE Y JUSTIFICACION
Composite se podría usar ya que crearíamos personajes a partir de otros componentes que estén organizados de forma jerárquica o que están encapsulados en clases generales por ejemplo espada escudo y armadura pertenecen a una clase general llamada equipamiento y así, entonces podemos usar tanto grupos completos como elementos. Pero como el juego no es tanto árbol si no ir agregando a medida que se necesite con Decorative estaría bien.

### 4. CODIGO EJECUTANDO

![ Ejercicio 4 ](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-3-mabel/evidencias/ejecucion%20ejercicio%204%20.png)

## Ejercicio 5: Sistema Bancario Antiguo
### 1. ANALISIS DE PROBLEMA PLANTEADO
Es un banco que tiene un sistema moderno que quiere trabajar con un sistema antiguo, pero tienen un problema y esque hablan en idiomas diferentes o palabras diferentes para cada método lo que hace que el sistema moderno espere una cosa y el antiguo este ofreciendo otra haciendo que no sean compatibles.
Si no usamos patrones se tendría que modificar el sistema antiguo para que el moderno entienda, llenándolo de traducciones y eso no es nada eficaz.

### 2. DISEÑOS PRESENTES
* **Adapter:** para poder hacer compatible dos interfaces diferentes las conecta reutilizando y traduciendo las interfaces.
* **Facade:** va a simplificar el acceso a un sistema complejo eliminando pasos o validaciones que son innecesarias y así se pueden reducir dependencias y un código más fácil de usar.

### 3. PATRONES QUE SE PODRIAN USAR
se podría utilizar el patrón Bridge, ya que también ayuda a separar las funcionalidades principales de la forma en que se implementan, pero en este ejercicio el problema principal es conectar un sistema bancario antiguo con uno moderno sin tener que modificar el sistema existente. Por eso Adapter resulta más adecuado, ya que es como un intermediario entre ambos sistemas y Facade ayuda a simplificar el uso del sistema ofreciendo una interfaz más sencilla para el usuario.

### 4. CODIGO EJECUTANDO

![ Ejercicio 5 ](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-3-mabel/evidencias/ejecucion%20ejercicio%205.png)

## Ejercicio 6 Motor de Recomendaciones
### 1. ANALISIS DE PROBLEMA PLANTEADO
Es una plataforma que se encarga de recomendar contenido dependiendo de las condiciones por género o historial popularidad o similitud, con la capacidad de que el usuario puede cambiar las preferencias cada que quiera el problema esque si no usamos patrones tendiramos que actualizar el código cada que el usuario cambie de preferencias.

### 2. DISEÑOS PRESENTES:
El patron de strategy crea cada algoritmo para poder recomendar el contenido de una forma diferente sin tocar el resto del sistema, el patron observer permite que cada clase sepa cuando enterarse si cambian las preferencias, entonces cuando cambia las preferencias Observer le avisa a todos. Como funcionan es digamos en la popularidad e historial del usuario strategy cambia el algoritmo y observer detecta el cambio y lo notifica   y cargan la nueva información para el usuario.

### 3. ¿QUE OTROS PATRONES PODEMOS USAR?
Se podría usar el Patron de Chain of Responsability porque para poder dar una recomendación el algoritmo pasa por genero popularidad historial y así sucesivamente y pasa al resultado siguiente pero esta solución no es la mejor porque el usuario selecciona un único tipo de recomendación según las preferencias que tenga, así que son independientes los algoritmos y así se valide uno el resultado no afecta al otro

### 4. CODIGO EJECUTANDO

![ Ejercicio 6 ](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-3-mabel/evidencias/ejecucion%20ejercicio%206%20.png)

## Ejercicio 7 Flujo de aprobación de documentos
### 1. ANALISIS DEL PROBLEMA PLANTEADO
La empresa tiene documentos que tiene que pasar por varias validaciones para poder aprobarse, pero no todos documentos pasan por todas las validaciones ya que no pertenecen a su área, sin patrones al agregar una nueva validación o área se tendría que modificar el código todo el tiempo permitiendo que hallan más errores.
cada patron aporta muchas cosas por ejemplo el patron Chain of Responsability en donde están cada una de las validaciones y quien debe revisar el documento , en cada validador va a decidir si lo va a procesar o si lo envía al siguiente validador evitando así tener varios if y else que son innecesarios , ahora el patron de State con el que podemos saber en qué estado está el documento ya sea en revisión aprobado o rechazado, dependiendo del estado donde este va a saber que hacer y dar una respuesta a su estado ,para evitar cambiar manualmente el estado cada que modifiquemos el código

### 2. ¿QUE PATRON PODEMOS USAR?
se podría utilizar Strategy para manejar diferentes formas de aprobación según el tipo de documento ya que algunos si debieran revisar o pasar por todas las áreas, pero el problema principal no consiste en cambiar algoritmos de validación sino en permitir que se valide el documento de forma secuencial y que este cambie de estado según el resultado de cada revisión.

### 3. CODIGO EJECUTANDO

![ Ejercicio 7 ](https://github.com/MabelBernalAmaya/DOSW_BITACORA/blob/feature/semana-3-mabel/evidencias/ejecucion%20ejercicio%207%20.png)

# MANUAL IDENTIDAD- EJERCICIO EN CLASE 
explicacion de la idea: Restaurante con tematica de regueton,con diferentes tipos de saclhipapas con nombres de artistas de regueton, tiene una maquina transportadora para recibir la comida ala mesa, contiene tipografia, paleta de colores, publico dirigido 