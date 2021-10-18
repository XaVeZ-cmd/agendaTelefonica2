package br.com.servico.agendatelefonica.models.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.servico.agendatelefonica.models.enums.TipoTelefone;
import lombok.*;

@Data
@NoArgsConstructor
public class TelefoneDTO {
    
    private Long idTelefoneDTO;

	@Enumerated(EnumType.STRING)
	private TipoTelefone tipoTelefone;

	@NotEmpty
	@Size(min = 13, max = 15)
	private String numeroDTO;
}
