package br.com.servico.agendatelefonica.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.servico.agendatelefonica.models.enums.TipoEmail;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Email {
    
    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmail;

    @Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoEmail tipoEmail;

	@Id
	@Column(nullable = false)
	private String emailContato;

}

