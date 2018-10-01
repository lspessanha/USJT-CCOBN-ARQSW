package br.usjt.arqsw18.pipoca.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

import br.usjt.arqsw18.pipoca.model.entity.Usuario;
import br.usjt.arqsw18.pipoca.model.dao.UsuarioDAO;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioDAO dao;
	
	public UsuarioService() {
		this.dao = new UsuarioDAO();
	}
	
	public Usuario autenticar(Usuario usuario) throws IOException {
		usuario =  dao.autenticar(usuario);
		return usuario;
	}
	
}
