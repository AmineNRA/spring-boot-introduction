package tech.chillo.sa_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tech.chillo.sa_backend.model.Client;
import tech.chillo.sa_backend.service.ClientService;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/client")
public class ClientController {

    private final ClientService clientService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void creer(@RequestBody Client client) {
        clientService.creer(client);
    }

    @GetMapping
    public Iterable<Client> getAllCLient() {
        return clientService.getAllClients();
    }

    @GetMapping(path = "/{id}")
    public Client getCLient(@PathVariable Integer id) {
        return clientService.getClient(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "{id}")
    public void modifier(@PathVariable Integer id, @RequestBody Client client) {
        clientService.modifier(id, client);
    }
}
