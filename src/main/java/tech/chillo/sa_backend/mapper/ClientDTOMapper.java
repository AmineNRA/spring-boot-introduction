package tech.chillo.sa_backend.mapper;

import org.mapstruct.Mapper;

import tech.chillo.sa_backend.dto.ClientDTO;
import tech.chillo.sa_backend.model.Client;

@Mapper(componentModel = "spring")
public interface ClientDTOMapper {
    ClientDTO tDto(Client client);

    Client toEntity(ClientDTO clientDTO);

}
