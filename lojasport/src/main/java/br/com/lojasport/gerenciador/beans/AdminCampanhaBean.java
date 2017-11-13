package br.com.lojasport.gerenciador.beans;

import java.time.LocalDateTime;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

import br.com.lojasport.gerenciador.daos.CampanhaDao;
import br.com.lojasport.gerenciador.daos.TimeCoracaoDao;
import br.com.lojasport.gerenciador.gateway.CampanhaGateway;
import br.com.lojasport.gerenciador.models.Campanha;
import br.com.lojasport.gerenciador.models.TimeCoracao;
import br.com.lojasport.gerenciador.resource.CampanhaResource;

@Model
public class AdminCampanhaBean {

	private Campanha campanha = new Campanha();
	@Inject
	private CampanhaDao campanhaDao;
	@Inject
	private TimeCoracaoDao timeDao;
	private List<TimeCoracao> times;
	@Inject
	private FacesContext context;
	
	@Inject
	private CampanhaGateway campanhaGateway;
	
	@Transactional
	public String incluir() {
		campanha.setDtVigenciaAtualizacao(LocalDateTime.now());
		campanhaDao.incluir(campanha);
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Campanha cadastrada com sucesso!"));

		//Nao implementado - inicio
		Client client = ClientBuilder.newClient();
		Entity<Campanha> json = Entity.json(campanha);
		CampanhaResource resource = new CampanhaResource();
		resource.incluir(campanha);
		//Nao implementado - fim
		return "/torcedor/listacampanha?faces-redirect=true";
	}

	public Campanha getCampanha() {
		return campanha;
	}

	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}

	public CampanhaDao getCampanhaDao() {
		return campanhaDao;
	}

	public void setCampanhaDao(CampanhaDao campanhaDao) {
		this.campanhaDao = campanhaDao;
	}

	public List<TimeCoracao> getTimes() {
		return timeDao.listar();
	}

	public void setTimes(List<TimeCoracao> times) {
		this.times = times;
	}

}
