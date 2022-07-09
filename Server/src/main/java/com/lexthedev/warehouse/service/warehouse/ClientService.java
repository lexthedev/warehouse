package com.lexthedev.warehouse.service.warehouse;

import com.lexthedev.warehouse.entity.warehouse.ClientEntity;
import com.lexthedev.warehouse.exceptions.NotFoundException;
import com.lexthedev.warehouse.model.warehouse.Client;
import com.lexthedev.warehouse.repository.warehouse.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepo clientRepo;

    public Client getOne(Long id) throws NotFoundException {
        ClientEntity client = clientRepo.findById(id).get();
        if (client == null) {
            throw new NotFoundException("product not found");
        } else {
            return Client.toModel(client);
        }
    }

    public List<Client> getAll() {
        Iterable<ClientEntity> clients = clientRepo.findAll();
        List<Client> result = new ArrayList<Client>();
        clients.forEach(elem -> result.add(Client.toModel(elem)));

        return result;
    }

    public ClientEntity create(ClientEntity client) {
        return clientRepo.save(client);
    }

    public ClientEntity edit(ClientEntity client) throws NotFoundException {
        Long id = client.getId();
        if (clientRepo.findById(id).isEmpty()) {
            throw new NotFoundException("client not found");
        }
        return clientRepo.save(client);
    }

    public String delete(Long id) throws NotFoundException {
        if (clientRepo.findById(id).isEmpty()) {
            throw new NotFoundException("product not found");
        }
        clientRepo.delete(clientRepo.findById(id).get());
        return "element with id " + id + "successfully deleted";
    }
}
