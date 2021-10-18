package br.com.servico.agendatelefonica.models.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoEmail {
    
	PESSOAL("pessoal"),
	COMERCIAL("comercial"),
	ALTERNATIVO("alternativo");
	
	private final String tipo;
}
