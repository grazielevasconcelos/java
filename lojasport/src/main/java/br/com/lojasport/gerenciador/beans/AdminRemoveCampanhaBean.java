package br.com.lojasport.gerenciador.beans;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.lojasport.gerenciador.daos.CampanhaDao;
import br.com.lojasport.gerenciador.models.Campanha;

@Model
public class AdminRemoveCampanhaBean {
	@Inject
	private CampanhaDao campanhaDao;
	@Inject
	private Campanha campanha;
	private Integer idCampanha;
	@Inject
	private FacesContext context;
	
	@Transactional
	public String removerCampanhaById() {
		this.campanha = campanhaDao.buscarById(idCampanha);
		campanhaDao.remover(campanha.getIdCampanha());
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Remoção feita com sucesso!"));

		return "/torcedor/listacampanha?faces-redirect=true";
	}
	
	public Campanha getCampanha() {
		return campanha;
	}

	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}

	public Integer getIdCampanha() {
		return idCampanha;
	}

	public void setIdCampanha(Integer idCampanha) {
		this.idCampanha = idCampanha;
	}
	
}
