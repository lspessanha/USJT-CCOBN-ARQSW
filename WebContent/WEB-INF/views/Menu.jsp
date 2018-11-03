<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index">Hora da Pipoca</a>
            </div>
            <c:if test="${not empty sessionScope.logado}">
	            <div id="navbar" class="navbar-collapse collapse">
	                <ul class="nav navbar-nav">
	                    <li><a href="listar_filmes">Filmes</a></li>
	                    <li><a href="listar_filmes_tmdb">Filmes - TMDb</a></li>
	                    <li class="nav-item dropdown">
	                    	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Catálogo</a>
	                   		<ul class="dropdown-menu">
	  						  	<li><a class="dropdown-item" href="/pipoca/catalogo/genero">por Gênero</a></li>
							  	<li><a class="dropdown-item" href="/pipoca/catalogo/popularidade">por Popularidade</a></li>
								<li><a class="dropdown-item" href="/pipoca/catalogo/lancamento">Lançamentos</a></li>
							</ul>
	                    </li>
	                </ul>
	                <ul class="nav navbar-nav navbar-right">
						<li class="nav-item dropdown">
	                    	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Usuário: <span class="text-capitalize">${sessionScope.username}</span></a>
	                   		<ul class="dropdown-menu">
	  						  	<li><a class="dropdown-item" href="logout">Sair</a></li>
							</ul>
	                    </li>
					</ul>
	            </div>
			</c:if>
        </div>
    </nav>