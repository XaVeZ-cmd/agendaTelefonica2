package br.com.servico.agendatelefonica.mapper;

import br.com.servico.agendatelefonica.models.dto.ContatoDTO;
import br.com.servico.agendatelefonica.models.entity.Contato;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContatoMapper {

    public Contato toEntity(ContatoDTO contatoDTO) {
        Contato contato = new Contato();
        contato.setIdContato(contatoDTO.getIdContatoDTO());
        contato.setNome(contatoDTO.getNomeDTO());
        return contato;
    }

    public ContatoDTO toDTO(Contato contato) {
        ContatoDTO contatoDTO = new ContatoDTO();
        contatoDTO.setIdContatoDTO(contato.getIdContato());
        contatoDTO.setNomeDTO(contato.getNome());
        return contatoDTO;
    }

    public List<ContatoDTO> toDTO(List<Contato> listContato) {
        return listContato.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
