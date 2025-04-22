package controllers;

import models.Person;
import views.Views;
import controllers.MetodosOrdenamiento;
import controllers.MetodosBusqueda;
import java.util.Scanner;

    

public class Controller {
    private Scanner scanner;
    private Views view;
    private Person[] persons;
    private int personCount = 0;

    private boolean lastSortByName;  
    private boolean lastSortIsDes;
    public Controller(Views view) {
        this.view = view;
        this.persons = new Person[100];
        this.scanner =new Scanner(System.in);
    }

    public void start() {
        int option;
        do {
            option = view.showMenu();
            switch (option) {
                case 1 -> inputPersons();
                case 2 -> sortPersons();
                case 3 -> searchPerson();
                case 4 -> view.displayPersons(persons, personCount);
                case 5 -> System.out.println("¡Gracias por usar el sistema!");
                default -> System.out.println("Opción inválida");
            }
        } while (option != 5);
    }

    private void inputPersons() {
        int count;
    while (true) {
        System.out.print("¿Cuántas personas desea ingresar? ");
        String input = scanner.nextLine().trim();
        try {
            count = Integer.parseInt(input);
            if (count > 0) {
                break;  
            } else {
                System.out.println("El número debe ser mayor que cero.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Solo se permiten números.");
        }
    }
        for (int i = 0; i < count; i++) {
            persons[personCount++] = view.inputPerson();
        }
        System.out.println("Personas registradas exitosamente!");
    }

    private void sortPersons() {
        int method = view.selectSortingMethod();
        boolean isDes = method % 2 == 0;
        lastSortIsDes   = isDes;
        lastSortByName  = (method==1||method==2||method==5||method==6||method==11||method==12);


        switch (method) {
            case 1, 2 -> MetodosOrdenamiento.sortByNameWithBubble(persons, personCount, isDes);
            case 3, 4 -> MetodosOrdenamiento.sortByAgeWithBubble(persons, personCount, isDes);
            case 5, 6 -> MetodosOrdenamiento.sortByNameWithSelection(persons, personCount, isDes);
            case 7, 8 -> MetodosOrdenamiento.sortByAgeWithSelection(persons, personCount, isDes);
            case 9, 10 -> MetodosOrdenamiento.sortByAgeWithInsertion(persons, personCount, isDes);
            case 11, 12 -> MetodosOrdenamiento.sortByNameWithInsertion(persons, personCount, isDes);
            default -> System.out.println("Método inválido");
        }
        System.out.println("¡Ordenamiento completado!");
    }

    private void searchPerson() {
        int criterion = view.selectSearchCriterion();
        if ((criterion == 1 && !lastSortByName) ||
            (criterion == 2 &&  lastSortByName)) {
            System.out.printf("Error: para buscar por %s, primero ordena por %s%n",
                (criterion==1?"nombre":"edad"),
                (criterion==1?"nombre":"edad"));
            return;
        };

        boolean isSorted = (criterion == 1)
            ? MetodosBusqueda.isSortedByName(persons, personCount, lastSortIsDes)
            : MetodosBusqueda.isSortedByAge(persons, personCount, lastSortIsDes);

        if (!isSorted) {
            System.out.println("Error: el arreglo no está ordenado correctamente para este criterio");
            return;
        }

        Person result = switch (criterion) {
            case 1 -> MetodosBusqueda.binarySearchByName(persons, personCount,view.inputName(), lastSortIsDes);
            case 2 -> MetodosBusqueda.binarySearchByAge(persons, personCount, view.inputAge(), lastSortIsDes);
            default -> null;
        };

        view.displaySearchResult(result);
    }
}