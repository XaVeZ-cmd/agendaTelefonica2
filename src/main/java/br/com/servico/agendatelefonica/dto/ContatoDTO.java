package br.com.servico.agendatelefonica.dto;

import lombok.Data;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@Data
public class ContatoDTO {

    private Long id;

    private String nome;

    private String email;

    private String telefone;
}
