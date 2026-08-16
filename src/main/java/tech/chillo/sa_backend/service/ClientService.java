package tech.chillo.sa_backend.service;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import tech.chillo.sa_backend.dto.ClientDTO;
import tech.chillo.sa_backend.mapper.ClientDTOMapper;
import tech.chillo.sa_backend.model.Client;
import tech.chillo.sa_backend.repository.ClientRepository;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientDTOMapper clientDTOMapper;
    private final ClientRepository clientRepository;

    public void creer(ClientDTO clientDTO) {

        if (clientRepository.existsByEmail(clientDTO.email())) {
            throw new RuntimeException("Cet email est déjà utilisé");
        }
        Client client = clientDTOMapper.toEntity(clientDTO);
        clientRepository.save(client);

    }

    public Stream<ClientDTO> getAllClients() {
        return clientRepository.findAll()
                .stream().map(clientDTOMapper::tDto);
    }

    public Client getClient(Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        return optionalClient.orElseThrow(() -> new EntityNotFoundException("Client introuvable avec l'id " + id));
    }

    public Client readOrCreate(Client client) {
        Client clientDansLaBDD = clientRepository.findByEmail(client.getEmail());
        return (clientDansLaBDD != null) ? clientDansLaBDD : client;
    }

    public void modifier(Integer id, ClientDTO clientDTO) {
        Client clientDansLaBDD = getClient(id);
        clientDansLaBDD.setEmail(clientDTO.email());
        clientDansLaBDD.setTelephone(clientDTO.telephone());

        clientRepository.save(clientDansLaBDD);
    }

    public void deleteClient(Integer id) {
        if (!clientRepository.existsById(id)) {
            throw new EntityNotFoundException("Client introuvable avec l'id " + id);
        }
        clientRepository.deleteById(id);
    }
}
