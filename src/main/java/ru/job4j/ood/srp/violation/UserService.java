package ru.job4j.ood.srp.violation;

/**
 * Нарушение srp: класс сохраняет пользователя и отвечает за отправку email
 */
public class UserService {

    public void saveUser(String name) {
        System.out.println("User saved: " + name);
    }

    public void sendEmail(String name) {
        System.out.println("Sending email to: " + name);
    }

}
