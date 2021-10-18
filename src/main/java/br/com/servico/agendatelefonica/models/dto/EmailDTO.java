package br.com.servico.agendatelefonica.models.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.servico.agendatelefonica.models.enums.TipoEmail;
import lombok.*;

@Data
@NoArgsConstructor
public class EmailDTO {
    
    private Long idEmailDTO;

	@Enumerated(EnumType.STRING)
	private TipoEmail tipoEmail;

	@NotEmpty
	@Size(min = 10)
	private String emailDTO;
}
