package com.cliente.controller;

import com.cliente.controller.dto.ClienteCreateDTO;
import com.cliente.controller.dto.ClienteDTO;
import com.cliente.controller.mapper.ClienteMapper;
import com.cliente.model.Cliente;
import com.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteMapper clienteMapper;

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteCreateDTO dto) {
        var clienteCreate = clienteMapper.toClienteCreate(dto);
        var cliente = clienteService.create(clienteCreate);
        var result = clienteMapper.toClienteDTO(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping()
    public ResponseEntity<List<ClienteDTO>>findAll(){
        List<Cliente> clienteList = clienteService.findAll();
        List<ClienteDTO> result = clienteMapper.toClienteDTOList(clienteList);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable long id) {
        Cliente cliente = clienteService.findById(id);
        ClienteDTO result = clienteMapper.toClienteDTO(cliente);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable long id, @RequestBody ClienteCreateDTO clienteCreateDTO) {
        Cliente clienteUpdate = clienteMapper.toClienteCreate(clienteCreateDTO);
        Cliente cliente = clienteService.update(id,clienteUpdate);
        return ResponseEntity.ok(clienteMapper.toClienteDTO(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deletar(@PathVariable long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
