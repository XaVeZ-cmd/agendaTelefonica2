package br.com.servico.agendatelefonica.models.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Entity
@Data
@Table(name = "role")
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "nome_role")
	private String nomeRole;
	
	@ManyToMany
	private List<Usuario> usuarios;
	
	@Override
	public String getAuthority() {
		return this.nomeRole;
	}

}
