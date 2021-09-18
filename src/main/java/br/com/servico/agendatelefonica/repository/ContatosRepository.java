package br.com.servico.agendatelefonica.repository;

import br.com.servico.agendatelefonica.models.Contatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatosRepository extends JpaRepository<Contatos, Long> {
}
