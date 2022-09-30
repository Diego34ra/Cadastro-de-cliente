package com.cliente.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ClienteDTO {

    private long id;

    private String nomeCliente;

    private String telefone;

    private String email;

    private String cidade;
}
