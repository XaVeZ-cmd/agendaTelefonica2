package br.com.servico.agendatelefonica.models.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Entity
@Data
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String nomeRole;
	
	@ManyToMany
	private List<Usuario> usuarios;
	
	@Override
	public String getAuthority() {
		return this.nomeRole;
	}

}
