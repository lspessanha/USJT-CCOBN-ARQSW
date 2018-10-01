package br.usjt.arqsw18.pipoca.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw18.pipoca.model.entity.Usuario;

@Repository
public class UsuarioDAO {
	@PersistenceContext
	EntityManager manager;
	
	public boolean validarUsuario(Usuario usuario) throws IOException{
		String jpql = "select u from Usuario u where u.username = :user and u.password = :pass";
		Query query = manager.createQuery(jpql);
		query.setParameter("user", usuario.getUsername());
		query.setParameter("pass", usuario.getPassword());
		List<Usuario> result = query.getResultList();
		return (result != null && result.size() == 1);
		
	}
	
	
}
