package tech.chillo.sa_backend.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import tech.chillo.sa_backend.model.Client;
import tech.chillo.sa_backend.repository.ClientRepository;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public void creer(Client client) {
        if (clientRepository.existsByEmail(client.getEmail())) {
            throw new RuntimeException("Cet email est déjà utilisé");
        }
        clientRepository.save(client);

    }

    public Iterable<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClient(Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        return optionalClient.orElseThrow(() -> new EntityNotFoundException("Client introuvable avec l'id " + id));
    }

    public Client readOrCreate(Client client) {
        Client clientDansLaBDD = clientRepository.findByEmail(client.getEmail());
        return (clientDansLaBDD != null) ? clientDansLaBDD : client;
    }

    public void modifier(Integer id, Client client) {
        Client clientDansLaBDD = getClient(id);
        if (clientDansLaBDD.getId() == client.getId()) {
            clientDansLaBDD.setEmail(client.getEmail());
            clientDansLaBDD.setTelephone(client.getTelephone());
            clientRepository.save(clientDansLaBDD);
        }
    }
}
