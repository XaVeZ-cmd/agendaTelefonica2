package br.com.servico.agendatelefonica.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ContatoDTO {

	private Long id;

	@NotEmpty
	@Size(min = 3, max = 20)
	private String nome;

	@NotEmpty
	@Size(min = 10, max = 100)
	private String email;

	@NotEmpty
	@Size(min = 13, max = 15)
	private String telefone;
}
