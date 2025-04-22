package views;

import models.Person;
import java.util.Scanner;

public class Views {
    private Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Ingresar personas");
        System.out.println("2. Ordenar personas");
        System.out.println("3. Buscar persona");
        System.out.println("4. Mostrar todas las personas");
        System.out.println("5. Salir");
        while (true) {
            System.out.print("Seleccione una opción: ");
            String input = sc.nextLine();
            try {
                int opcion = Integer.parseInt(input);
                if (opcion >= 1 && opcion <= 5) {
                    return opcion;
                } else {
                    System.out.println("Opción fuera de rango. Elija entre 1 y 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Solo se permiten números.");
            }
        }
    }

    public Person inputPerson() {
        System.out.println("\n=== INGRESAR PERSONA ===");
        return new Person(inputName(), inputAge());
    }

    public int selectSortingMethod() {
        while (true) {
            System.out.println("\n=== MÉTODOS DE ORDENAMIENTO ===");
            System.out.println("1. Burbuja por nombre (ascendente)");
            System.out.println("2. Burbuja por nombre (descendente)");
            System.out.println("3. Burbuja por edad (ascendente)");
            System.out.println("4. Burbuja por edad (descendente)");
            System.out.println("5. Selección por nombre (ascendente)");
            System.out.println("6. Selección por nombre (descendente)");
            System.out.println("7. Selección por edad (ascendente)");
            System.out.println("8. Selección por edad (descendente)");
            System.out.println("9. Inserción por edad (ascendente)");
            System.out.println("10. Inserción por edad (descendente)");
            System.out.println("11. Inserción por nombre (ascendente)");
            System.out.println("12. Inserción por nombre (descendente)");
            System.out.print("Seleccione un método: ");
            String line = scanner.nextLine().trim();
            try {
                int m = Integer.parseInt(line);
                if (m >= 1 && m <= 12) {
                    return m;
                }
            } catch (NumberFormatException e) { }
            System.out.println("Entrada inválida. Solo se permiten números entre 1 y 12.");
        }
    }

    public int selectSearchCriterion() {
        while (true) {
            System.out.println("\n=== CRITERIOS DE BÚSQUEDA ===");
            System.out.println("1. Buscar por nombre");
            System.out.println("2. Buscar por edad");
            System.out.print("Seleccione un criterio: ");
            String line = scanner.nextLine().trim();
            try {
                int c = Integer.parseInt(line);
                if (c == 1 || c == 2) {
                    return c;
                }
            } catch (NumberFormatException e) { }
            System.out.println("Entrada inválida. Solo se permiten números 1 o 2.");
        }
    }

    public void displayPersons(Person[] persons, int count) {
        if (count == 0) {
            System.out.println("\nNo hay personas registradas.");
            return;
        }
        System.out.println("\n=== LISTA DE PERSONAS ===");
        for (int i = 0; i < count; i++) { 
            System.out.println(persons[i]);
        }
    }

    public void displaySearchResult(Person result) {
        System.out.println("\n=== RESULTADO DE BÚSQUEDA ===");
        System.out.println(result != null ? result : "Persona no encontrada.");
    }

    public int inputAge() {
        while (true) {
            try {
                System.out.print("Ingrese la edad: ");
                int age = Integer.parseInt(scanner.nextLine());
                if (age > 0 && age < 101) return age;
                System.out.println("La edad debe ser entre 1 y 100");
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido");
            }
        }
    }

    public String inputName() {
        String name;
        while (true) {
            System.out.print("Ingrese el nombre: ");
            name = scanner.nextLine().trim();
            if (name.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) return name;
            System.out.println("El nombre solo puede contener letras y espacios");
        }
    }
   
    
}
