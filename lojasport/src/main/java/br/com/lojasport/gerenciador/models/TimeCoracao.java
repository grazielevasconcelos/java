package br.com.lojasport.gerenciador.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class TimeCoracao {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTimeCoracao;
	private String nomeTime;
	
	@OneToMany(mappedBy = "timeCoracao")
	//@JoinColumn(name="timecoracaoId")
	private List<Campanha> campanhas = new ArrayList<>();
	
	public TimeCoracao() {
		super();
	}
	
	public TimeCoracao(String nomeTime) {
		this.nomeTime = nomeTime;
	}
	
	public TimeCoracao(Integer idTimeCoracao) {
		this.idTimeCoracao = idTimeCoracao;
	}
	
	public TimeCoracao(Integer idTimeCoracao, String nomeTime) {
		super();
		this.idTimeCoracao = idTimeCoracao;
		this.nomeTime = nomeTime;
	}

	public Integer getIdTimeCoracao() {
		return idTimeCoracao;
	}

	public void setIdTimeCoracao(Integer idTimeCoracao) {
		this.idTimeCoracao = idTimeCoracao;
	}

	public String getNomeTime() {
		return nomeTime;
	}
	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}

	public List<Campanha> getCampanhas() {
		return campanhas;
	}

	public void setCampanhas(List<Campanha> campanhas) {
		this.campanhas = campanhas;
	}

	@Override
	public String toString() {
		return "TimeCoracao [idTimeCoracao=" + idTimeCoracao + ", nomeTime=" + nomeTime + ", campanhas=" + campanhas
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTimeCoracao == null) ? 0 : idTimeCoracao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeCoracao other = (TimeCoracao) obj;
		if (idTimeCoracao == null) {
			if (other.idTimeCoracao != null)
				return false;
		} else if (!idTimeCoracao.equals(other.idTimeCoracao))
			return false;
		return true;
	}
	
}
