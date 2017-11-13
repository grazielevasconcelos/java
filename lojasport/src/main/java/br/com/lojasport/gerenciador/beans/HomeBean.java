package br.com.lojasport.gerenciador.beans;

import javax.enterprise.inject.Model;

@Model
public class HomeBean {
	public String cadastrarCampanha(){
		return "/torcedor/campanha?faces-redirect=true";
	}
	public String listarCampanha(){
		return "/torcedor/listacampanha?faces-redirect=true";
	}
}
