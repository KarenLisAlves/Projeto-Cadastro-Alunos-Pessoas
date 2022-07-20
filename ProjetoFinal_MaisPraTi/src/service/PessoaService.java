package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import exceptions.PessoaException;
import model.Aluno;
import model.Pessoa;
import repository.RepositoryImplements;

public class PessoaService {
	
	private static RepositoryImplements<Integer, Pessoa> repository = new RepositoryImplements<>();
	static Scanner sc;
	
	public PessoaService(Scanner sc) {
		PessoaService.sc = sc;
	}

	public Pessoa tratarOpcao(String opcao) throws PessoaException {
		
		sc.nextLine();
		opcao = opcao.toLowerCase();
		opcao = opcao.replace("ã", "a");
		System.out.println("Sua resposta foi: " + opcao);
	
			if(opcao.equals("nao") || opcao.equals("n")) {	
				System.out.println("Cadastro de PESSOA !");
				return PessoaService.cadastrarPessoa();
			}

//				System.out.println();
//				String nota = opcao;
//				boolean continuarLeitura = true;
//					
//					while(continuarLeitura) {
//					//	System.out.println(opcao);
//					try {
//						Integer notaConvertida = Integer.parseInt(nota);
//						continuarLeitura = false;
//					
//					if(notaConvertida <= 100) {
//						System.out.println("Cadastro de ALUNO !");
//						return AlunoService.cadastrarAluno();
//					}
//					else {
//						System.out.println("Digite uma nota válida! Nota MÁXIMA é 100! ");
//					}
//					
//					}catch(NumberFormatException e) {
//						System.out.println("Entrada com valor inválido");
//						break;
//						}
//					}
			return null;	
	}
	
	
	public static Pessoa cadastrarPessoa() throws PessoaException {
		sc.nextLine();
		System.out.println("Digite o NOME da PESSOA");
		String nome = sc.nextLine();
		System.out.println("Digite o TELEFONE da PESSOA");
		String telefone = sc.nextLine();
		try {
			System.out.println("Digite a DATA DE NASCIMENTO da PESSOA no Formato 'dd/MM/yyyy'");
			String dataNascimento = sc.nextLine();
			DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
			Date dt = data.parse(dataNascimento);
			System.out.println("Nome: " + nome);
			System.out.println("Telefone de " + nome +": " + telefone);
			System.out.println("Data de Nascimento de " + nome + ": " + dt);
			} catch(Exception ex){
				ex.printStackTrace();
			}		
		
		// VERIFICA SE A PESSOA JÁ EXISTE
	List<Pessoa> pessoas = PessoaService.repository.buscarTodos();
		for(Pessoa pessoa : pessoas) {
			if(pessoa.getNome().equals(nome)) {
				System.out.println("Esta PESSOA já está cadastrada!");
			}
		}
		
		// SALVA PESSOA
		Pessoa pessoa = new Pessoa(nome, telefone, new Date());
		PessoaService.repository.salvar(pessoa.getId(), pessoa);
		System.out.println();
		System.out.println("Cadastro de Pessoa realizado com Sucesso!");
		return pessoa;
	}
	
	public  Pessoa atualizarPessoa(Pessoa pessoa) {
		sc.nextLine();
		System.out.println("Confirme o NOME da PESSOA");
		String nome = sc.nextLine();
		System.out.println("Confirme o TELEFONE da PESSOA");
		String telefone = sc.nextLine();
		try {
			System.out.println("Confirme a DATA DE NASCIMENTO da PESSOA no Formato 'dd/MM/yyyy'");
			String dataNascimento = sc.nextLine();
			DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
			Date dt = data.parse(dataNascimento);
			System.out.println("Nome: " + nome);
			System.out.println("Telefone de " + nome +": " + telefone);
			System.out.println("Data de Nascimento de " + nome + ": " + dt);
			} catch(Exception ex){
				ex.printStackTrace();
			}	
		Pessoa pessoa1 = new Pessoa(nome, telefone, new Date());
		this.repository.atualizar(pessoa1.getId(), pessoa1);
		return pessoa1;
	}

	public void mostrarTodasPessoas() {
		List<Pessoa> pessoas = repository.buscarTodos();
		pessoas.forEach(v -> System.out.println(v));
	}
	
	public void excluirPessoaID(Integer Id) {
		this.repository.excluir(Id);
		System.out.println();
		System.out.println("Cadastro de Pessoa excluído com Sucesso!" + Id);
	}
	
	public Pessoa buscarPorId(Integer Id) {
		Pessoa pessoa = this.repository.buscarPorId(Id);
		if(pessoa == null) {
			throw new PessoaException("Pessoa não encontrado. ID: " + Id);
		}
		return pessoa;
	}
	
}
