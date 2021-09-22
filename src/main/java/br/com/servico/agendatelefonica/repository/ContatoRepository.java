package br.com.servico.agendatelefonica.repository;

import br.com.servico.agendatelefonica.models.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
