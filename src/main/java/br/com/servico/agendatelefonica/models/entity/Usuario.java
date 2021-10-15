package br.com.servico.agendatelefonica.models.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "login", nullable = false)
	private String login;
	
	@Column(name = "senha", nullable = false)
	private String senha;
	
	@ManyToMany
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario", referencedColumnName = "login"), 
				inverseJoinColumns = @JoinColumn(name = "role", referencedColumnName = "nome_role"))
	private List<Role> roles;	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.login;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
