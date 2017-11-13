package br.com.lojasport.gerenciador.gateway;

import java.io.Serializable;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;

import br.com.lojasport.gerenciador.models.Campanha;

public class CampanhaGateway implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public String cadastrarService(Campanha campanha) {
		Client client = ClientBuilder.newClient();
		Entity<Campanha> json = Entity.json(campanha);
		WebTarget wt = client.target("target");
		Builder request = wt.request();
		return request.post(json, String.class);
	}
	
}
