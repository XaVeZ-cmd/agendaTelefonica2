package br.com.servico.agendatelefonica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.servico.agendatelefonica.models.entity.Telefone;

import java.util.Optional;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, String> {
    Optional<Telefone> findByNumero(String numero);
}
