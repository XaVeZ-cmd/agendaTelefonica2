package br.com.servico.agendatelefonica.service;

import br.com.servico.agendatelefonica.models.entities.Contato;
import br.com.servico.agendatelefonica.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {
    ContatoRepository contatoRepository;

    @Autowired
    ContatoService(ContatoRepository contatoRepository){
        this.contatoRepository = contatoRepository;
    }

    public List<Contato> findAll() {
        return contatoRepository.findAll();
    }

    public Optional<Contato> getById(Long id) {
        return contatoRepository.findById(id);
    }

    public Contato saveContato(Contato contato){
        return contatoRepository.save(contato);
    }

    public ResponseEntity<Contato> updateContato(Contato contato) {
        return contatoRepository.findById(contato.getId())
                .map(gravar -> {
                    gravar.setNome(contato.getNome());
                    gravar.setEmail(contato.getEmail());
                    gravar.setTelefone(contato.getTelefone());
                    Contato updateContato = contatoRepository.save(gravar);
                    return ResponseEntity.ok().body(updateContato);
                }).orElse(ResponseEntity.notFound().build());
    }

    public void deleteContato(Long id) {
        contatoRepository.deleteById(id);
    }
}
