package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import util.Contador;

public class Aluno extends Pessoas {
	
	public List<Aluno> alunos = new ArrayList<>();
	
	public Aluno(String nome, String telefone, Date dataNascimento) {
		super(Contador.proximoId(), nome, telefone, dataNascimento);
	}
	
	
	/**
	 * @return the aluno
	 */
	public List<Aluno> getAlunos() {
		return alunos;
	}

	/**
	 * @param veiculos the aluno to set
	 */
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	
	
//	private Double[] notasAluno = new Double[3];
//
//	/**
//	 * @return the notasAluno
//	 */
//	public double getNotasAluno() {
//		
//		double total = 0;
//		
//		for (int i = 0; i < this.notasAluno.length; i++) {	
//			total += this.notasAluno[i];
//		}
//		
//		return total;
//	}
//		
//
//	/**
//	 * @param notasAluno the notasAluno to set
//	 */
//	public void setNotasAluno(Double[] notasAluno) {
//		this.notasAluno = notasAluno;
//	}
//	
//
//	public void setNota(double nota) {
//		
//		double total = 0;
//		
//		for (int i = 0; i < this.notasAluno.length; i++) {
//			
//			if(this.notasAluno[i] != null)	{
//			total+= this.notasAluno[i];
//			}
//			
//			
//			if (total + nota > 100) {
//				System.out.println("Atenção, somatório maior que 100");			
//			} 
//			
//			else {
//				if (this.notasAluno[i] == null) {
//					this.notasAluno[i] = nota;
//					break;
//				}
//			}
//		}
//	}




	
	
	
}	
	
	
		// Nota final do curso - Se tiver nota final do curso ele é um aluno, senão é uma pessoa
		// Classes e heranças para tratar se é aluno ou pessoa
		
	
	


