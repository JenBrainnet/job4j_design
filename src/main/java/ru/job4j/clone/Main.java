package ru.job4j.clone;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneByConstr object = new CloneByConstr(5, 10);
        CloneByConstr clone = new CloneByConstr(object);
        clone.setX(15);
        clone.setY(20);
        System.out.println("Original object. X: " + object.getX() + " , Y: " + object.getY());
        System.out.println("Cloned object. X: " + clone.getX() + " , Y: " + clone.getY());
    }

}
