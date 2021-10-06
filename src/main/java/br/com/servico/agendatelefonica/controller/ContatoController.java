package br.com.servico.agendatelefonica.controller;

import br.com.servico.agendatelefonica.dto.ContatoDTO;
import br.com.servico.agendatelefonica.models.Contato;
import br.com.servico.agendatelefonica.service.ContatoService;
import br.com.servico.agendatelefonica.utils.Endpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({Endpoints.REQUEST_CONTATOS})
public class ContatoController {

    @Autowired
    ContatoService contatoService;

    @GetMapping //OK
    public ResponseEntity<List<ContatoDTO>> findAll(){
        return ResponseEntity.ok(contatoService.findAll());
    }

    @GetMapping(path = Endpoints.REQUEST_CONTATOS_FIND_GET_BY_ID) //OK
    public ResponseEntity<ContatoDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(contatoService.getById(id));
    }

    @PostMapping //OK
    public ResponseEntity<ContatoDTO> save(@RequestBody ContatoDTO contatoDTO){
        return ResponseEntity.ok(contatoService.save(contatoDTO));
    }

    @PutMapping(value = Endpoints.REQUEST_CONTATOS_FIND_GET_BY_ID) //OK
    public ResponseEntity<ContatoDTO> update(@RequestBody ContatoDTO contatoDTO){
       return ResponseEntity.ok(contatoService.update(contatoDTO));
    }

    @DeleteMapping(Endpoints.REQUEST_CONTATOS_FIND_GET_BY_ID)
    public ResponseEntity<ContatoDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(contatoService.delete(id));
    }

}