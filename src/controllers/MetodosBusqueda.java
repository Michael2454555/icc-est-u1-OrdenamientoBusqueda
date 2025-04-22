package controllers;

import models.Person;

public class MetodosBusqueda {
    public static Person binarySearchByAge(Person[] persons, int count, int targetAge, boolean isDes) {
        int abajo = 0, alto = count - 1;
        while (abajo <= alto) {
            int medio = abajo + (alto - abajo) / 2;
            int val = persons[medio].getAge();
            if (persons[medio].getAge() == targetAge) return persons[medio];
            if ((!isDes && val < targetAge) || (isDes && val > targetAge)) abajo = medio + 1;
            else alto = medio - 1;
        }
        return null;
    }

    public static Person binarySearchByName(Person[] persons, int count, String targetName, boolean isDes           ) {
        int abajo = 0, alto = count - 1;
        while (abajo <= alto) {
            int medio = abajo + (alto - abajo) / 2;
            int comparison = persons[medio].getName().compareToIgnoreCase(targetName);
            if (comparison == 0) return persons[medio];
            if ((!isDes && comparison < 0) || (isDes && comparison > 0)) abajo = medio + 1;
            else alto = medio - 1;
        }
        return null;
    }

    public static boolean isSortedByAge(Person[] persons, int count, boolean isDes) {
        for (int i = 0; i < count - 1; i++) {
            if ((!isDes && persons[i].getAge() > persons[i + 1].getAge())
             || (isDes  && persons[i].getAge() < persons[i + 1].getAge())) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSortedByName(Person[] persons, int count, boolean isDes) {
        for (int i = 0; i < count - 1; i++) {
            int cmp = persons[i].getName().compareToIgnoreCase(persons[i + 1].getName());
            if ((!isDes && cmp > 0) || (isDes && cmp < 0)) {
                return false;
            }
        }
        return true;
    }
}