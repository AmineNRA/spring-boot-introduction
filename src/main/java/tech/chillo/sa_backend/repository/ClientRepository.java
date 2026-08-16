package tech.chillo.sa_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.chillo.sa_backend.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    boolean existsByEmail(String email);

    Client findByEmail(String email);
}
