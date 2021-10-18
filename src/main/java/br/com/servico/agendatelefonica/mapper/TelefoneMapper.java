package br.com.servico.agendatelefonica.mapper;

import br.com.servico.agendatelefonica.models.dto.TelefoneDTO;
import br.com.servico.agendatelefonica.models.entity.Telefone;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TelefoneMapper {
    
    public Telefone toEntity(TelefoneDTO telefoneDTO) {
        Telefone telefone = new Telefone();
        telefone.setNumero(telefoneDTO.getNumeroDTO());
        return telefone;
    }

    public TelefoneDTO toDTO(Telefone telefone) {
        TelefoneDTO telefoneDTO = new TelefoneDTO();
        telefoneDTO.setNumeroDTO(telefone.getNumero());
        return telefoneDTO;
    }

    public List<TelefoneDTO> toDTO(List<Telefone> listTelefone) {
        return listTelefone.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
