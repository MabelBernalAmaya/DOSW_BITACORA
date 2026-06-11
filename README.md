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

**Captura de ejecución:** ![Ejercicio 1](../../evidencias/ejercicio1.png)

**Explicación:** Se convierte la lista en un Stream con `.stream()`. Luego se aplican dos `.filter()`: el primero selecciona los números pares (`n % 2 == 0`) y el segundo los mayores a 10 (`n > 10`). Finalmente `.collect(Collectors.toList())` convierte el resultado en una lista.

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

**Captura de ejecución:** ![Ejercicio 2](../../evidencias/s1_ejercicio2.png)

**Explicación:** Se filtra con `.filter()` para quedarse solo con palabras de más de 4 letras (descarta "java", "api", "code", "git"). Luego `.map(String::toUpperCase)` las pasa a mayúsculas, `.sorted()` las ordena alfabéticamente y `.count()` cuenta cuántas quedaron. El resultado es 2 porque solo "stream" y "functional" cumplen la condición.

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

**Captura de ejecución:** ![Ejercicio 3](../../evidencias/s1_ejercicio3.png)

**Explicación:** Se usa `.filter()` para quedar solo con usuarios activos. Luego `.map()` convierte cada nombre a mayúsculas, `.sorted()` los ordena alfabéticamente y `.collect()` los agrupa en una lista.

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

**Captura de ejecución:** ![Ejercicio 4](../../evidencias/s1_ejercicio4.png)

**Explicación:** Se filtra con `.filter()` comparando la edad con 18. Los que pasan el filtro se transforman con `.map()` para extraer solo el nombre, y `.collect()` los junta en una lista.

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

**Captura de ejecución:** ![Ejercicio 5](../../evidencias/s1_ejercicio5.png)

**Explicación:** `.peek()` imprime cada transacción a medida que el Stream la procesa, sin modificarla. Luego `.anyMatch()` revisa si al menos una transacción tiene `approved = false`. Si la hay, el lote no es válido, por eso se imprime `!hayNoAprobada`.