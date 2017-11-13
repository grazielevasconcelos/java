package br.com.lojasport.gerenciador.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.lojasport.gerenciador.models.Campanha;

public class CampanhaDao {
	@PersistenceContext
	private EntityManager manager;

	public void incluir(Campanha campanha) {
		manager.persist(campanha);
	}

	public List<Campanha> listar() {
		return manager.createQuery("select a from Campanha a join fetch a.timeCoracao", Campanha.class).getResultList();
	}

	public Campanha buscarById(Integer idCampanha) {
		return manager
				.createQuery("select a from Campanha a join fetch a.timeCoracao where a.idCampanha = :idCampanha ",
						Campanha.class)
				.setParameter("idCampanha", idCampanha).getSingleResult();
	}

	public void remover(Integer idCampanha) {
		manager.createQuery("delete from Campanha c where c.idCampanha = :idCampanha")
				.setParameter("idCampanha", idCampanha).executeUpdate();
	}
}
