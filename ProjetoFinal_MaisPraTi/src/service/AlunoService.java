package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import exceptions.AlunoException;
import exceptions.PessoaException;
import menu.Menu;
import model.Aluno;
import model.Pessoa;
import repository.RepositoryImplements;

public class AlunoService {
	
	private static RepositoryImplements<Integer, Aluno> repository = new RepositoryImplements<>();
	static Scanner sc;


	public AlunoService(Scanner sc) {
		this.sc = sc;
	}
	
	
	public Aluno tratarOpcaoAluno(String opcao) throws AlunoException {

		sc.nextLine();
		opcao = opcao.toLowerCase();
		opcao = opcao.replace("ã", "a");
		//System.out.println(opcao);

			if(opcao.equals("nao") || opcao.equals("n")) {	
//				System.out.println("Cadastro de PESSOA !");
//				return (Aluno) PessoaService.cadastrarPessoa();
			}

				System.out.println();
				String nota = opcao;
				boolean continuarLeitura = true;
					
					while(continuarLeitura) {
					//	System.out.println(opcao);
					try {
						Integer notaConvertida = Integer.parseInt(nota);
						continuarLeitura = false;
					
					if(notaConvertida <= 100) {
						System.out.println("Cadastro de ALUNO !");
						return this.cadastrarAluno();
					}
					
					else {
						System.out.println("Digite uma nota válida! Nota MÁXIMA é 100! ");
					}
					
					}catch(NumberFormatException e) {
						System.out.println("Entrada com valor inválido");
						break;
						}
					}
			return null;	
		}


	public static Aluno cadastrarAluno() throws AlunoException {
			sc.nextLine();
			System.out.println("Digite o NOME do ALUNO");
			String nome = sc.nextLine();
			System.out.println("Digite o TELEFONE do ALUNO");
			String telefone = sc.nextLine();
			try {
			System.out.println("Digite a DATA DE NASCIMENTO do ALUNO no Formato 'dd/MM/yyyy'");
			String dataNascimento = sc.nextLine();
			DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
			Date dt = data.parse(dataNascimento);
			System.out.println("Nome Aluno(a): " + nome);
			System.out.println("Telefone de " + nome +": " + telefone);
			System.out.println("Data de Nascimento de " + nome + ": " + dt);
			} catch(Exception ex){
				ex.printStackTrace();
			}		

		
		// VERIFICA SE ALUNO JÁ EXISTE
	List<Aluno> alunos = AlunoService.repository.buscarTodos();
		for(Aluno aluno : alunos) {
			if(aluno.getNome().equals(nome)) {
				throw new AlunoException("Este ALUNO já está cadastrado!"); 
			}
	}

		// SALVANDO ALUNO
	Aluno aluno = new Aluno(nome, telefone, new Date());
		repository.salvar(aluno.getId(), aluno);
		System.out.println();
		System.out.println("Cadastro de Aluno realizado com Sucesso!");
		return aluno;
	}
	
	public static void atualizarAluno(Aluno aluno) {
		AlunoService.repository.atualizar(aluno.getId(), aluno);
		}
	
	public static void mostrarTodosAlunos() {
		List<Aluno> alunos = repository.buscarTodos();
		alunos.forEach(v -> System.out.println(v));
	}
	
	
	public static void excluirAlunoID(Integer id) {
		AlunoService.repository.excluir(id);
		System.out.println();
		System.out.println("Cadastro de Aluno excluído com Sucesso!" + id);
	}
	
	
	public Aluno buscarPorId(Integer id) {
		Aluno aluno = AlunoService.repository.buscarPorId(id);
		if(aluno == null) {
			throw new AlunoException("Aluno não encontrado. ID: " + id);
		}
		return aluno;
	}
	
}



