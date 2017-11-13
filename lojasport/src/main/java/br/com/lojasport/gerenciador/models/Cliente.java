package br.com.lojasport.gerenciador.models;

import java.time.LocalDate;

public class Cliente {
	private Integer idCliente;
	private String nomeCliente;
	private String email;
	private LocalDate dataNascimento;
	private TimeCoracao time;
	
	public Cliente() {
		super();
	}
	public Cliente(String nomeCliente, String email, LocalDate dataNascimento, TimeCoracao time) {
		this.nomeCliente = nomeCliente;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.time = time;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", email=" + email
				+ ", dataNascimento=" + dataNascimento + ", time=" + time + "]";
	}

	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public TimeCoracao getTime() {
		return time;
	}
	public void setTime(TimeCoracao time) {
		this.time = time;
	}
	
}
