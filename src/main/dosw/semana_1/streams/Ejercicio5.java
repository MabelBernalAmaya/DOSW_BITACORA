package main.dosw.semana_1.streams;

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

