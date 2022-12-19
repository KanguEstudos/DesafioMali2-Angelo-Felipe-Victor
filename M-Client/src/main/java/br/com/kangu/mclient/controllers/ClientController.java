package br.com.kangu.mclient.controllers;

import br.com.kangu.mclient.entities.Client;
import br.com.kangu.mclient.repositories.ClientRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientRespository clientRespository;

    @GetMapping
    public List<Client> findAll() {
        return clientRespository.findAll();
    }

    @PostMapping()
    public Client insertCategory(@RequestBody Client client){
        return clientRespository.save(client);
    }

}
