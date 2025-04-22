package controllers;

import models.Person;

public class MetodosOrdenamiento {
    // Burbuja
    public static void sortByNameWithBubble(Person[] persons, int count , boolean isDes) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                int comparison = persons[j].getName().compareToIgnoreCase(persons[j + 1].getName());
                if (isDes) comparison *= -1;
                if (comparison > 0) swap(persons, j, j + 1);
            }
        }
    }

    public static void sortByAgeWithBubble(Person[] persons, int count, boolean isDes) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                int comparison = Integer.compare(persons[j].getAge(), persons[j + 1].getAge());
                if (isDes) comparison *= -1;
                if (comparison > 0) swap(persons, j, j + 1);
            }
        }
    }

    // Selección
    public static void sortByNameWithSelection(Person[] persons, int count, boolean isDes) {
        for (int i = 0; i < count - 1; i++) {
            int targetIndex = i;
            for (int j = i + 1; j < count; j++) {
                int comparison = persons[j].getName().compareToIgnoreCase(persons[targetIndex].getName());
                if (isDes) comparison *= -1;
                if (comparison < 0) targetIndex = j;
            }
            swap(persons, i, targetIndex);
        }
    }

    public static void sortByAgeWithSelection(Person[] persons, int count, boolean isDes) {
        for (int i = 0; i < count - 1; i++) {
            int targetIndex = i;
            for (int j = i + 1; j < count; j++) {
                int comparison = Integer.compare(persons[j].getAge(), persons[targetIndex].getAge());
                if (isDes) comparison *= -1;
                if (comparison < 0) targetIndex = j;
            }
            swap(persons, i, targetIndex);
        }
    }

    // Inserción
    public static void sortByAgeWithInsertion(Person[] persons, int count, boolean isDes) {
        for (int i = 1; i < count; i++) {
            Person key = persons[i];
            int j = i - 1;
            while (j >= 0 && (isDes 
                    ? (persons[j].getAge() < key.getAge()) 
                    : (persons[j].getAge() > key.getAge()))) {
                persons[j + 1] = persons[j];
                j--;
            }
            persons[j + 1] = key;
        }
    }

    public static void sortByNameWithInsertion(Person[] persons, int count, boolean isDes) {
        for (int i = 1; i < count; i++) {
            Person key = persons[i];
            int j = i - 1;
            while (j >= 0 && (isDes 
                    ? (persons[j].getName().compareToIgnoreCase(key.getName()) < 0) 
                    : (persons[j].getName().compareToIgnoreCase(key.getName()) > 0))) {
                persons[j + 1] = persons[j];
                j--;
            }
            persons[j + 1] = key;
        }
    }

    private static void swap(Person[] persons, int i, int j) {
        Person temp = persons[i];
        persons[i] = persons[j];
        persons[j] = temp;
    }
}