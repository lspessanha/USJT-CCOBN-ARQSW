package br.usjt.arqsw18.pipoca.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Usuario implements Serializable{
	public static final String LOGADO = "logado";
	
	@Id
	private String username;
	
	@NotNull
	@Size(max=100)
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Usuario [username=" + username + ", password=" + password + "]";
	}
}
