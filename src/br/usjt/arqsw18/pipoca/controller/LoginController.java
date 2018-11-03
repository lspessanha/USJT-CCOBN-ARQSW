package br.usjt.arqsw18.pipoca.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw18.pipoca.model.entity.Usuario;
import br.usjt.arqsw18.pipoca.model.service.UsuarioService;

@Controller
public class LoginController {
	UsuarioService service;
	
	@Autowired
	public LoginController(UsuarioService srv){
		this.service = srv;
	}
	
	@RequestMapping("loginForm")
	public String loginForm(){
		return "login";
	}
	
	@RequestMapping("fazer_login")
	public String fazerLogin(Usuario usuario, HttpSession session){
		try {
			if(service.validarUsuario(usuario)){
				session.setAttribute(Usuario.LOGADO, usuario);
				session.setAttribute("username", usuario.getUsername());
				return "index";
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
		return "redirect:loginForm";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.setAttribute(Usuario.LOGADO, null);
		session.setAttribute("username", null);
		return "redirect:loginForm";
	}
	
	
}
