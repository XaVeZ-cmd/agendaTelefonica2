package br.com.servico.agendatelefonica.mapper;

import br.com.servico.agendatelefonica.dto.ContatoDTO;
import br.com.servico.agendatelefonica.models.Contato;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
        contatoDTO.setEmail(contatoDTO.getEmail());
        contatoDTO.setTelefone(contato.getTelefone());
        return contatoDTO;
    }

    public List<ContatoDTO> toDTO(List<Contato> listContato){
        return listContato.stream().map(this::toDTO).collect(Collectors.toList());
    }
}