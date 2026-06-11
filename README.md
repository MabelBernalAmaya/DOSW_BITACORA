# SEMANA No 1 – DOSW Manejo de Streams

## Datos personales:
- Nombre: [Mabel Bernal]
- Código: [1000100629]
- Curso: DOSW 

### Ejercicio 01 – Números Pares mayores a diez

Enunciado del Ejercicio
Dada una lista de números enteros, obtener solo los pares mayores a 10.

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

**Captura de ejecucion:**
![Ejercicio 1](evidencias/
ejercicio1.png)


**Explicacion:**. Primero convertimos  la lista en un Stream con .stream().
Luego hacemos .filter() dos veces para que  el primer filtro selecciona los números pares (n % 2 == 0)
y el segundo filtro selecciona los números mayores a 10 (n > 10).
 y por ultimo hacemos . collect(Collectors.toList()) convierte el resultado nuevamente en una lista.