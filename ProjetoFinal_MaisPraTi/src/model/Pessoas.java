package model;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.Contador;

public class Pessoas {
	protected Integer id;
	protected String nome;
	protected String telefone;
	protected Date dataNascimento;
	protected LocalDateTime dataCadastro;
	protected LocalDateTime dataUltimaAlteracao;

	
	public Pessoas (Integer id, String nome, String telefone, Date dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = LocalDateTime.now();
		this.dataUltimaAlteracao = LocalDateTime.now();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the dataNascimento
	 * @throws ParseException 
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */							

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the dataCadastro
	 */
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	/**
	 * @param dataCadastro the dataCadastro to set
	 */
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * @return the dataUltimaAlteracao
	 */
	public LocalDateTime getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	/**
	 * @param dataUltimaAlteracao the dataUltimaAlteracao to set
	 */
	public void setDataUltimaAlteracao(LocalDateTime dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}
	


	
	@Override
	public String toString() {
		return this.id + " - Nome: " + this.nome + " - Telefone: " + this.telefone 
				//+ " - Data de Nascimento: " + this.dataNascimento
				+ " - Data do Cadastro: " + this.dataCadastro + " - Data Última Atualização: " 
				+ this.dataUltimaAlteracao;
	}
	
}


