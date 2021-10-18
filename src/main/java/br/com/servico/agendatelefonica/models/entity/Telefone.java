package br.com.servico.agendatelefonica.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.servico.agendatelefonica.models.enums.TipoTelefone;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Telefone {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTelefone;

    @Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoTelefone tipoTelefone;

	@Id
	@Column(nullable = false)
	private String numero;
}
