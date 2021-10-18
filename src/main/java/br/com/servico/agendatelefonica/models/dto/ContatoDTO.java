package br.com.servico.agendatelefonica.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.util.List;

@Data
@NoArgsConstructor
public class ContatoDTO {

	private Long idContatoDTO;

	@NotEmpty
	@Size(min = 3, message = "O minimo de caracteres é 3")
	private String nomeDTO;

	@NotEmpty
	@Valid
	private List<EmailDTO> emails;

	@Valid
	@NotEmpty
	private List<TelefoneDTO> telefones;
}
