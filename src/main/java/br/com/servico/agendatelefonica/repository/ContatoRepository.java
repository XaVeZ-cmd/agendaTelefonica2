package br.com.servico.agendatelefonica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.servico.agendatelefonica.models.entity.Contato;

import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
    Optional<Contato> findByEmail(String email);
}
