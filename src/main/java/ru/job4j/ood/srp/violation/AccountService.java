package ru.job4j.ood.srp.violation;

/**
 * Нарушение srp: класс создает аккаунт и отвечает за авторизацию
 */
public class AccountService {

    public void createAccount(String login, String password) {
        System.out.println("Account created: " + login);
    }

    public boolean login(String login, String password) {
        return "admin".equals(login) && "123".equals(password);
    }

}
