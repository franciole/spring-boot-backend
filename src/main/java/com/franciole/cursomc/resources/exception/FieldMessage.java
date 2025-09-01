package com.franciole.cursomc.resources.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {
    public static final long serialVersionUID = 1l;

    private String fieldNme;
    private String message;

    public FieldMessage() {
    }

    public FieldMessage(String fieldNme, String message) {
        this.fieldNme = fieldNme;
        this.message = message;
    }

    public String getFieldNme() {
        return fieldNme;
    }

    public void setFieldNme(String fieldNme) {
        this.fieldNme = fieldNme;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
