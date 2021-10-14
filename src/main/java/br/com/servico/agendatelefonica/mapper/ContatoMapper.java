package br.com.servico.agendatelefonica.mapper;

import br.com.servico.agendatelefonica.models.dto.ContatoDTO;
import br.com.servico.agendatelefonica.models.entity.Contato;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContatoMapper {

    public Contato toEntity(ContatoDTO contatoDTO){
        Contato contato = new Contato();
        contato.setId(contatoDTO.getId());
        contato.setNome(contatoDTO.getNome());
        contato.setEmail(contatoDTO.getEmail());
        contato.setTelefone(contatoDTO.getTelefone());
        return contato;
    }

    public ContatoDTO toDTO(Contato contato){
        ContatoDTO contatoDTO = new ContatoDTO();
        contatoDTO.setId(contato.getId());
        contatoDTO.setNome(contato.getNome());
        contatoDTO.setEmail(contato.getEmail());
        contatoDTO.setTelefone(contato.getTelefone());
        return contatoDTO;
    }

    public List<ContatoDTO> toDTO(List<Contato> listContato){
        return listContato.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
