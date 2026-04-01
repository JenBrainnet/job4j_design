package ru.job4j.clone;

public class ShallowCopyDemo implements Cloneable {

    int num;

    @Override
    protected ShallowCopyDemo clone() throws CloneNotSupportedException {
        return (ShallowCopyDemo) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ShallowCopyDemo object1 = new ShallowCopyDemo();
        object1.num = 5;
        ShallowCopyDemo object2 = object1.clone();
        object2.num = 10;
        System.out.println(object1.num);
        System.out.println(object2.num);
    }

}
