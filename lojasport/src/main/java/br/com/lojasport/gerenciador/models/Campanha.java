package br.com.lojasport.gerenciador.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.google.gson.Gson;

@Entity
public class Campanha {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCampanha;
	private String nomeCampanha;
	private LocalDate dtVigenciaInicial;
	private LocalDate dtVigenciaFinal;
	private LocalDateTime dtVigenciaAtualizacao;
	@ManyToOne
	@JoinColumn(name="timecoracaoId")
	private TimeCoracao timeCoracao;
	
	public Campanha() {
		super();
	}
	
	public Campanha(String nomeCampanha, LocalDate dtVigenciaInicial, LocalDate dtVigenciaFinal,
			LocalDateTime dtVigenciaAtualizacao) {
		super();
		this.nomeCampanha = nomeCampanha;
		this.dtVigenciaInicial = dtVigenciaInicial;
		this.dtVigenciaFinal = dtVigenciaFinal;
		this.dtVigenciaAtualizacao = dtVigenciaAtualizacao;
	}

	public Integer getIdCampanha() {
		return idCampanha;
	}

	public void setIdCampanha(Integer idCampanha) {
		this.idCampanha = idCampanha;
	}

	public String getNomeCampanha() {
		return nomeCampanha;
	}
	public void setNomeCampanha(String nomeCampanha) {
		this.nomeCampanha = nomeCampanha;
	}
	public LocalDate getDtVigenciaInicial() {
		return dtVigenciaInicial;
	}
	public void setDtVigenciaInicial(LocalDate dtVigenciaInicial) {
		this.dtVigenciaInicial = dtVigenciaInicial;
	}
	public LocalDate getDtVigenciaFinal() {
		return dtVigenciaFinal;
	}
	public void setDtVigenciaFinal(LocalDate dtVigenciaFinal) {
		this.dtVigenciaFinal = dtVigenciaFinal;
	}
	public LocalDateTime getDtVigenciaAtualizacao() {
		return dtVigenciaAtualizacao;
	}
	public void setDtVigenciaAtualizacao(LocalDateTime dtVigenciaAtualizacao) {
		this.dtVigenciaAtualizacao = dtVigenciaAtualizacao;
	}


	public TimeCoracao getTimeCoracao() {
		return timeCoracao;
	}

	public void setTimeCoracao(TimeCoracao timeCoracao) {
		this.timeCoracao = timeCoracao;
	}

	@Override
	public String toString() {
		return "Campanha [idCampanha=" + idCampanha + ", nomeCampanha=" + nomeCampanha + ", dtVigenciaInicial="
				+ dtVigenciaInicial + ", dtVigenciaFinal=" + dtVigenciaFinal + ", dtVigenciaAtualizacao="
				+ dtVigenciaAtualizacao + ", timeCoracao=" + timeCoracao + "]";
	}
	
	public String toJson() {
		return new Gson().toJson(this);
	}
	
}
