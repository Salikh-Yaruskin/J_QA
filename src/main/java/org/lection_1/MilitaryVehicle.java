package org.lection_1;

import java.util.Arrays;

public class MilitaryVehicle extends CombatVehicle{
    private String manufacturer;
    private String model;
    private int weight ;
    private int ammunition;

    public MilitaryVehicle(String manufacturer, String model, int weight, int ammunition){
        this.manufacturer = manufacturer;
        this.model = model;
        this.weight = weight;
        this.ammunition =  ammunition;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAmmunition(){
        return ammunition;
    }

    public void setAmmunition(int ammunition){
        this.ammunition = ammunition;
    }

    @Override
    public void deploy(){
        int[][] maps = {{0, 0, 0},
                        {0, 0, 0},
                        {0, 0, 0}};
        System.out.println("Развертывание " + model + " на карте произошло успешно!");
    }

    public void fire(MilitaryVehicle modelEnemy){
        System.out.println(model + " открывает огонь");
    }

    public void retreat(){
        System.out.println(model + " отступает");
    }

    public void hit(MilitaryVehicle modelEnemy){
        System.out.println("Поподание по " + model);
    }

    @Override
    public String toString(){
        return "Manufacturer = " + manufacturer + "\n" +
                "Model = " + model + "\n" +
                "Weight = " + weight;
    }
}
