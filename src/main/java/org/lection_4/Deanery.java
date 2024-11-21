package org.lection_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Deanery {
    public static void main(String[] args) {
        ArrayList<Students> hall = new ArrayList<>();

        hall.add(new Students("Ivan", 21, 3, genRaring()));
        hall.add(new Students("Larisa", 21, 3, genRaring()));
        hall.add(new Students("Misha", 21, 3, genRaring()));
        hall.add(new Students("Lena", 31, 2, genRaring()));
        hall.add(new Students("Sasha", 31, 2, genRaring()));
        hall.add(new Students("Kuzma", 31, 2, genRaring()));

        hall = removeLessThree(hall);

        printStudents(hall, 3);
        printStudents(hall, 4);
    }

    // метод для генерации оценок, чтобы не заполнять в ручную
    public static HashMap<String, Integer> genRaring() {
        HashMap<String, Integer> subject = new HashMap<>();
        subject.put("Выш мат", generation());
        subject.put("РиАТ", generation());
        subject.put("Алгоритмы и СД", generation());
        subject.put("Разработка МП", generation());
        subject.put("Теория автоматов", generation());
        subject.put("Мат логика", generation());
        subject.put("Разработка сайтов", generation());

        return subject;
    }

    public static int generation() {
        Random random = new Random();
        return random.nextInt(2, 6);
    }

    // удаляме студентов со средним баллом меньше 3
    public static ArrayList<Students> removeLessThree(ArrayList<Students> array) {
        ArrayList<Students> newArray = array
                .stream()
                .filter(x -> {
                    if (x.calculateAverage() >= 3) {
                        x.setCourse(x.getCourse() + 1);
                        return true;
                    }
                    return false;
                })
                .collect(Collectors.toCollection(ArrayList::new));

        return newArray;
    }

    public static void printStudents(ArrayList<Students> students, int course) {
        List<Students> printList = students
                .stream()
                .filter(x -> x.getCourse() == course)
                .toList();

        printList.forEach(System.out::println);
    }
}
