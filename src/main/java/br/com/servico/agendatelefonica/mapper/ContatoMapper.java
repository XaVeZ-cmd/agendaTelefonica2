package br.com.servico.agendatelefonica.mapper;

import br.com.servico.agendatelefonica.models.dto.ContatoDTO;
import br.com.servico.agendatelefonica.models.entities.Contato;
import org.springframework.stereotype.Component;

@Component
public class ContatoMapper {

    public Contato toEntity(ContatoDTO contatoDTO){
        Contato contato = new Contato();
        contato.setNome(contatoDTO.getNome());
        contato.setEmail(contatoDTO.getEmail());
        contato.setTelefone(contatoDTO.getTelefone());
        return contato;
    }

    public ContatoDTO toDTO(Contato contato){
        ContatoDTO contatoDTO = new ContatoDTO();
        contatoDTO.setNome(contato.getNome());
        contatoDTO.setEmail(contato.getEmail());
        contatoDTO.setTelefone(contatoDTO.getTelefone());
        return contatoDTO;
    }
}
