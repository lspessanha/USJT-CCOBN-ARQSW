package br.usjt.arqsw18.pipoca.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.arqsw18.pipoca.model.entity.Filme;
import br.usjt.arqsw18.pipoca.model.entity.Genero;
import br.usjt.arqsw18.pipoca.model.service.FilmeService;
import br.usjt.arqsw18.pipoca.model.service.GeneroService;

@Transactional
@Controller
public class ManterFilmesController {
	@Autowired
	private FilmeService fService;
	@Autowired
	private GeneroService gService;
	@Autowired
	private ServletContext servletContext;

	@RequestMapping("index")
	public String iniciar() {
		return "index";
	}

	@RequestMapping("/novo_filme")
	public String novo(Model model, HttpSession session) {
		try {
			List<Genero> generos = gService.listarGeneros();
			session.setAttribute("generos", generos);
			return "CriarFilme";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}

	@RequestMapping("/criar_filme")
	public String criarFilme(Filme filme, BindingResult erros, Model model, 
			@RequestParam("posterPath") MultipartFile file) {
		try {
			Genero genero = new Genero();
			genero.setId(filme.getGenero().getId());
			genero.setNome(gService.buscarGenero(genero.getId()).getNome());
			filme.setGenero(genero);

			model.addAttribute("filme", filme);
			filme = fService.inserirFilme(filme);
			fService.gravarImagem(servletContext, filme, file);
			return "VisualizarFilme";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}

	@RequestMapping("/reiniciar_lista")
	public String reiniciarLista(HttpSession session) {
		session.setAttribute("lista", null);
		return "ListarFilmes";
	}

	@RequestMapping("/listar_filmes")
	public String listarFilmes(HttpSession session, Model model, String chave) {
		try {
			// HttpSession session = ((HttpServletRequest) model).getSession();

			List<Filme> lista;
			if (chave != null && chave.length() > 0) {
				lista = fService.listarFilmes(chave);
			} else {
				lista = fService.listarFilmes();
			}
			session.setAttribute("lista", lista);
			return "ListarFilmes";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}

	@RequestMapping("/visualizar_filme")
	public String visualizarFilme(Filme filme, Model model) {
		try {
			filme = fService.buscarFilme(filme.getId());
			model.addAttribute("filme", filme);
			return "VisualizarFilme";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}
	
	@RequestMapping("/excluir_filme")
	public String excluirFilme(Filme filme, HttpSession session, Model model) {
		try {
			fService.excluirFilme(filme);
			List<Filme> filmes = (List<Filme>) session.getAttribute("lista");
			session.setAttribute("lista", removerDaLista(filme, filmes));
			return "ListarFilmes";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}
	
	private List<Filme> removerDaLista(Filme filme, List<Filme> filmes){
		for(int i = 0; i < filmes.size(); i++) {
			if(filme.getId() == filmes.get(i).getId()) {
				filmes.remove(i);
				break;
			}
		}
		return filmes;
	}
	
	private List<Filme> atualizarDaLista(Filme filme, List<Filme> filmes){
		for(int i = 0; i < filmes.size(); i++) {
			if(filme.getId() == filmes.get(i).getId()) {
				filmes.remove(i);
				filmes.add(i, filme);
				break;
			}
		}
		return filmes;
	}
	
	@RequestMapping("/alterar_filme")
	public String atualizar(Filme filme, Model model, HttpSession session) {
		try {
			List<Genero> generos = gService.listarGeneros();
			session.setAttribute("generos", generos);
			filme = fService.buscarFilme(filme.getId());
			model.addAttribute("filme", filme);
			return "AtualizarFilme";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}

	@RequestMapping("/atualizar_filme")
	public String gravarAtualizacaoFilme(@Valid Filme filme, BindingResult erros, Model model, HttpSession session, 
			@RequestParam("posterPath") MultipartFile file) {
		try {
			if (!erros.hasErrors()) {
				Genero genero = new Genero();
				genero.setId(filme.getGenero().getId());
				genero.setNome(gService.buscarGenero(genero.getId()).getNome());
				filme.setGenero(genero);

				fService.atualizarFilme(filme);
				fService.gravarImagem(servletContext, filme, file);

				model.addAttribute("filme", filme);
				List<Filme> filmes = (List<Filme>) session.getAttribute("lista");
				session.setAttribute("lista", atualizarDaLista(filme, filmes));

				return "VisualizarFilme";
			} else {
				return "AtualizarFilme";
			}
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}

	@RequestMapping("/catalogo/genero")
	public ModelAndView porGeneros(Model model) throws IOException {
		ModelAndView andView = new ModelAndView("CatalogoGenero");
		List <Genero> porGeneros = gService.listaGenFilmes();
		andView.addObject("porGeneros",porGeneros);
		return andView;
	}
	
	@RequestMapping("/catalogo/lancamento")
	public ModelAndView porDtLancamento(Model model) throws IOException {
		ModelAndView andView = new ModelAndView("CatalogoDataLancamento");
		List<Filme> filmesAno = fService.porData("ano",1);
		
		List<Filme> filmesPenultimo = fService.porData("ano",2);
		List<Filme> filmesMes = fService.porData("mes",1);
		andView.addObject("filmesAno",filmesAno);
		andView.addObject("filmesMes",filmesMes);
		andView.addObject("filmesPenultimo",filmesPenultimo);
		return andView;
	}
	
	@RequestMapping("/catalogo/popularidade")
	public ModelAndView porPopularidade(Model model) throws IOException {
		ModelAndView andView = new ModelAndView("CatalogoPopularidade");
		List<Filme> filmes1 = fService.listarPopulares(0,40);
		List<Filme> filmes2 = fService.listarPopulares(21,50);
		List<Filme> filmes3 = fService.listarPopulares(51,60);
		List<Filme> filmes4 = fService.listarPopulares(41,80);
		List<Filme> filmes5 = fService.listarPopulares(71,100);
		andView.addObject("filmes1",filmes1);
		andView.addObject("filmes2",filmes2);
		andView.addObject("filmes3",filmes3);
		andView.addObject("filmes4",filmes4);
		andView.addObject("filmes5",filmes5);
		return andView;
	}
	/*
	@RequestMapping("/criar_filme")
	public String inclusao(@Valid Filme filme, BindingResult result, Model model,
			@RequestParam("file") MultipartFile file) {
		try {
			if (result.hasErrors()) {
				List<Filme> filmes = fService.listarFilmes();
				model.addAttribute("filmes", filmes);
				return "local/localcriar";
			}
			fService.inserirFilme(filme);
			fService.gravarImagem(servletContext, filme, file);
			return "redirect:listar_filmes";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}

	@RequestMapping("/atualizar_filme")
	public String atualizar(Filme filme, Model model, @RequestParam("file") MultipartFile file) {
		try {
			fService.atualizarFilme(filme);
			fService.gravarImagem(servletContext, filme, file);
			return "redirect:listar_filmes";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
		}
		return "erro";
	}
	*/

}
