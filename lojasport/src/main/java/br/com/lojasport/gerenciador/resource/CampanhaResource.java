package br.com.lojasport.gerenciador.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.lojasport.gerenciador.daos.CampanhaDao;
import br.com.lojasport.gerenciador.models.Campanha;

@Path("campanha")
public class CampanhaResource {
	
	@Inject
	private CampanhaDao campanhaDao;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String busca() {
		Campanha campanha = campanhaDao.buscarById(1);
		return campanha.toJson();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void incluir(Campanha campanha) {
		campanhaDao.incluir(campanha);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void remover(Integer id) {
		campanhaDao.remover(id);
	}
}
