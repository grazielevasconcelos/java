package br.com.lojasport.gerenciador.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.lojasport.gerenciador.models.TimeCoracao;

public class TimeCoracaoDao {
	@PersistenceContext
	private EntityManager manager;

	public List<TimeCoracao> listar() {
		return manager.createQuery("select a from TimeCoracao a", TimeCoracao.class).getResultList();
	}

	public TimeCoracao consultarById(Integer idTimeCoracao) {
		return manager
				.createQuery("select a from TimeCoracao a where a.idTimeCoracao = :idTimeCoracao", TimeCoracao.class)
				.setParameter("idTimeCoracao", idTimeCoracao).getSingleResult();
	}
}
