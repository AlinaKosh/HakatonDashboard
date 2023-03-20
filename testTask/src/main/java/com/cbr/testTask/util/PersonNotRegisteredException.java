package com.cbr.testTask.util;

public class PersonNotRegisteredException extends RuntimeException{
    public PersonNotRegisteredException(String msg){
        super(msg);
    }
}
