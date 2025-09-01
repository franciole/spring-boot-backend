package com.franciole.cursomc.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandError {
    public static final long serialVersionUID = 1l;

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
    }

    public List<FieldMessage> getErros() {
        return erros;
    }

    public void addError(String fieldName, String messagem) {
        erros.add(new FieldMessage(fieldName, messagem));
    }
}
