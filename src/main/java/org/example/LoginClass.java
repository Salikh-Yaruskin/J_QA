package org.example;

import org.example.myexception.WrongLoginException;
import org.example.myexception.WrongPasswordException;

import java.util.regex.Pattern;

public class LoginClass {
    public static void main(String[] args){
        boolean result = logIn("user_login", "Password123_", "Password123_");
        System.out.println("Результата проверки входа: " + result);
    }

    public static boolean logIn(String login, String password, String confirmPassword){
        String pattern = "^[a-zA-Z0-9_]{1,20}$";
        try{
            if(!Pattern.matches(pattern, login))
                throw new WrongLoginException("Неверный логин");

            if (!Pattern.matches(pattern, password))
                throw new WrongPasswordException("Неверный пароль");

            if (!password.equals(confirmPassword))
                throw new WrongPasswordException("Пароли не совпадают");

            return true;
        } catch(WrongLoginException | WrongPasswordException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
