package org.example.myexception;

public class WrongLoginException extends Exception{
    public WrongLoginException(){}

    public WrongLoginException(String message){
        super(message);
    }
}