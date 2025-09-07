package com.franciole.cursomc.services.validation;


import com.franciole.cursomc.domain.Cliente;
import com.franciole.cursomc.domain.enums.TipoCliente;
import com.franciole.cursomc.dto.ClienteDTO;
import com.franciole.cursomc.dto.ClienteNewDTO;
import com.franciole.cursomc.repositories.ClienteRepository;
import com.franciole.cursomc.resources.exception.FieldMessage;
import com.franciole.cursomc.services.validation.utils.BR;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ClienteUpdatetValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ClienteRepository repo;

    @Override
    public void initialize(ClienteUpdate ann) {
    }

    @Override
    public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {

        @SuppressWarnings("unchecked")
        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = Integer.parseInt(map.get("id"));
        List<FieldMessage> list = new ArrayList<>();

        Cliente aux = repo.findByEmail(objDto.getEmail());
        if(aux != null && !aux.getId().equals(uriId)) {
            list.add(new FieldMessage("email", "Email já existente"));
        }
        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldNme()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}