package com.smu.demo.exceptions;

public class SaveNotesError  extends Exception{
    public SaveNotesError(String errorMessage){
        super(errorMessage);
    }
}
