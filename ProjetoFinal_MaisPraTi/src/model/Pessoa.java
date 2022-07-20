package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.Contador;

public class Pessoa extends Pessoas {
		
	public List<Pessoa> pessoas = new ArrayList<>();
	
	public Pessoa(String nome, String telefone, Date dataNascimento) {
		super(Contador.proximoIdPessoa(), nome, telefone, dataNascimento);
	}
	
	/**
	 * @return the aluno
	 */
	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	/**
	 * @param veiculos the aluno to set
	 */
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}


}
