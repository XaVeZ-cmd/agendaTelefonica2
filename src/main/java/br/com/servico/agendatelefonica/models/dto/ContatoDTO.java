package br.com.servico.agendatelefonica.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ContatoDTO {

	private Long id;

	private String nome;

	private String email;

	private String telefone;
}
