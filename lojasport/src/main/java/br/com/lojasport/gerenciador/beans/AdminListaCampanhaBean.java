package br.com.lojasport.gerenciador.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.lojasport.gerenciador.daos.CampanhaDao;
import br.com.lojasport.gerenciador.models.Campanha;

@Model
public class AdminListaCampanhaBean {
	
	private List<Campanha> campanhas = new ArrayList<>();
	
	@Inject
	private CampanhaDao campanhaDao;

	public List<Campanha> getCampanhas() {
		return campanhaDao.listar();
	}
	

}
