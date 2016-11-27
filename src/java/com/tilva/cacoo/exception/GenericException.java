/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tilva.cacoo.exception;

/**
 *
 * @author mtilva
 */
public class GenericException extends Exception {
    
    private final String  message;
    public GenericException(String msg){
        this.message = msg;
    }
    @Override
    public String getMessage(){
        return message;
    }
    
}
