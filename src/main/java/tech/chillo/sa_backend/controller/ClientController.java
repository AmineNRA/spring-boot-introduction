package tech.chillo.sa_backend.controller;

import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import tech.chillo.sa_backend.dto.ClientDTO;
import tech.chillo.sa_backend.model.Client;
import tech.chillo.sa_backend.service.ClientService;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/client")
public class ClientController {

    private final ClientService clientService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void creer(@Valid @RequestBody ClientDTO clientDTO) {
        clientService.creer(clientDTO);
    }

    @GetMapping
    public Stream<ClientDTO> getAllCLient() {
        return clientService.getAllClients();
    }

    @GetMapping(path = "/{id}")
    public Client getCLient(@PathVariable Integer id) {
        return clientService.getClient(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "{id}")
    public void modifier(@Valid @PathVariable Integer id, @RequestBody ClientDTO clientDTO) {
        clientService.modifier(id, clientDTO);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void supprimer(@PathVariable Integer id) {
        clientService.deleteClient(id);
    }
}
