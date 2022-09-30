package com.cliente.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteCreateDTO {

    private String nomeCliente;

    private String telefone;

    private String email;

    private String cidade;
}
