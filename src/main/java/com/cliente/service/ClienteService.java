package com.cliente.service;

import com.cliente.model.Cliente;
import com.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private final ClienteRepository clienteRepository;
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public Cliente create(Cliente cliente) {
        clienteRepository.save(cliente);
        return cliente;
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente findById(long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    public Cliente update(long id, Cliente clienteCreate) {
        Cliente cliente = findById(id);
        cliente.setNomeCliente(clienteCreate.getNomeCliente());
        cliente.setCidade(clienteCreate.getCidade());
        cliente.setEmail(clienteCreate.getEmail());
        cliente.setTelefone(clienteCreate.getTelefone());
        clienteRepository.save(cliente);
        return cliente;
    }

    public void delete(long id){
        clienteRepository.deleteById(id);
    }


}
