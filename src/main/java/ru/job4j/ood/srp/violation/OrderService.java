package ru.job4j.ood.srp.violation;

/**
 * Нарушение srp: класс создает заказ и считает цену
 */
public class OrderService {

    public void createOrder(String item) {
        System.out.println("Order created: " + item);
    }

    public double calculatePrice(double price, double tax) {
        return price + tax;
    }

}
