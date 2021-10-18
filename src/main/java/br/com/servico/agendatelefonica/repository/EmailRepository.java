package br.com.servico.agendatelefonica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.servico.agendatelefonica.models.dto.EmailDTO;
import br.com.servico.agendatelefonica.models.entity.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    Optional<Email> findByEmail(String email);

    EmailDTO deleteById(EmailDTO emailDTO);

    Optional<Email> findByIdEmail(Long idEmail);

    Optional<Email> findByEmailUpdate(Long idEmail);
}