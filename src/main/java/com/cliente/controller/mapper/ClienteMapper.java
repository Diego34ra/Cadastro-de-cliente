package com.cliente.controller.mapper;

import com.cliente.controller.dto.ClienteCreateDTO;
import com.cliente.controller.dto.ClienteDTO;
import com.cliente.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ClienteDTO toClienteDTO(Cliente cliente) {
        return MODEL_MAPPER.map(cliente, ClienteDTO.class);
    }

    public List<ClienteDTO> toClienteDTOList(List<Cliente> clienteList) {
        return clienteList.stream().map(this::toClienteDTO).collect(Collectors.toList());
    }

    public Cliente toCliente(ClienteDTO dto) {
        return MODEL_MAPPER.map(dto,Cliente.class);
    }

    public Cliente toClienteCreate(ClienteCreateDTO dto) {
        return MODEL_MAPPER.map(dto,Cliente.class);
    }
}
