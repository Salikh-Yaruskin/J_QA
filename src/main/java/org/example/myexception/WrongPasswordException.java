package org.example.myexception;

public class WrongPasswordException extends Exception{
    public WrongPasswordException(){}

    public WrongPasswordException(String message){
        super(message);
    }
}