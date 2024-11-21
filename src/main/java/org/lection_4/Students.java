package org.lection_4;

import java.util.HashMap;

public class Students {
    private String name;
    private int group;
    private int course;
    private HashMap<String, Integer> ratings;

    public Students(String name, int group, int course, HashMap<String, Integer> ratings){
        this.name = name;
        this.group = group;
        this.course = course;
        this.ratings = ratings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public HashMap<String, Integer> getRatings() {
        return ratings;
    }

    public void setRatings(HashMap<String, Integer> ratings) {
        this.ratings = ratings;
    }

    public double calculateAverage(){
        return ratings.values()
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    @Override
    public String toString(){
        return "Имя = " + name + ", "
                + "Группа = " + group+ ", "
                + "Курс = " + course + ", "
                + "Оценки = " + ratings + ", ";
    }
}
