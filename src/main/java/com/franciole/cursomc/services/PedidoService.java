package com.franciole.cursomc.services;

import com.franciole.cursomc.domain.Pedido;
import com.franciole.cursomc.repositories.PedidoRepository;
import com.franciole.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido find(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id:" + id +
                        " - Tipo: " + Pedido.class.getName()));
    }
}
