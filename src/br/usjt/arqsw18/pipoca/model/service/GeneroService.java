package br.usjt.arqsw18.pipoca.model.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw18.pipoca.model.dao.GeneroDAO;
import br.usjt.arqsw18.pipoca.model.entity.Genero;

@Service
public class GeneroService {
	private GeneroDAO dao;
	
	@Autowired
	public GeneroService(GeneroDAO dao) {
		this.dao = dao;
	}
	
	public Genero buscarGenero(int id) throws IOException {
		return dao.buscarGenero(id);
	}
	
	public List<Genero> listarGeneros() throws IOException{
		return dao.listarGeneros();
	}
	
	public ArrayList<Genero> listaGenFilmes() throws IOException {

		ArrayList<Genero> generos = (ArrayList<Genero>) dao.listarGeneros();

		for (int i = 0; i < generos.size(); i++) {
			generos.get(i).setFilmes(dao.listarFilmes(generos.get(i)));
		}

		return generos;
	}

}
