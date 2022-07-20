import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import exceptions.AlunoException;
import model.Aluno;
import model.Pessoa;
import repository.RepositoryImplements;
import service.AlunoService;
import service.PessoaService;
import menu.Menu;;

public class Principal {
	
	public static void main (String[] args) throws InterruptedException  {
	
	Scanner sc = new Scanner(System.in);
			
	AlunoService alunoService = new AlunoService(sc);
	PessoaService pessoaService = new PessoaService(sc);
			
		boolean continua = true;
			
			do {
				
				try {
			
				Menu.bemVindo();
				
				Menu.cadastramento();
				int identificacao = sc.nextInt();
				
					if(identificacao == 1) {
						Menu.menuCondicao();
					
						String condicao = sc.next();
						Pessoa pessoa = pessoaService.tratarOpcao(condicao);
						Aluno aluno = alunoService.tratarOpcaoAluno(condicao);
					}

				if(identificacao == 2) {
					Menu.menuListasCadastros();
					int menuListasCadastros = sc.nextInt();
				
					if (menuListasCadastros == 1) {
						System.out.println("Lista de TODOS os Cadastros de Alunos");
						alunoService.mostrarTodosAlunos();
					}
					
					if (menuListasCadastros == 2) {
						System.out.println("Lista de TODOS os Cadastros de Pessoas");
						pessoaService.mostrarTodasPessoas();
					}
					
					if (menuListasCadastros == 3) {
						System.out.println("3 - Atualizar cadastro"); // Aluno ou Pessoa
						//veiculoService.atualizarVeiculo(veiculos);
						
						System.out.println();
						System.out.println("Escolha qual cadastro desejas ATUALIZAR: ");

						Menu.atualizarCadastros();
						int atualizarCadastros = sc.nextInt();
						
						// ATUALIZAR CADASTRO DE ALUNO
							if (atualizarCadastros == 1) {
								alunoService.mostrarTodosAlunos();
								int opcaoAluno = sc.nextInt();
								Aluno aluno = alunoService.buscarPorId(opcaoAluno);
								AlunoService.excluirAlunoID(aluno.getId());
								AlunoService.cadastrarAluno();
							}
							
							// ATUALIZAR CADASTRO DE PESSOA
							if (atualizarCadastros == 2) {
								pessoaService.mostrarTodasPessoas();
								int opcaoPessoa = sc.nextInt();
								Pessoa pessoa = pessoaService.buscarPorId(opcaoPessoa);
								//pessoaService.atualizarPessoa(pessoa);
								pessoaService.excluirPessoaID(pessoa.getId());
								pessoaService.cadastrarPessoa();
							}		
					}
					
					if (menuListasCadastros == 4) {
						System.out.println("4 - Excluir cadastro"); // Aluno ou Pessoa
						
						System.out.println("Digite a opção que desejas EXCLUIR: ");
						
						Menu.excluirCadastros();
						int excluirCadastros = sc.nextInt();
						
							// EXCLUIR CADASTRO DE ALUNO
							if (excluirCadastros == 1) {
								alunoService.mostrarTodosAlunos();
								int opcaoAluno = sc.nextInt();
								Aluno aluno = alunoService.buscarPorId(opcaoAluno);
								//aluno.getAlunos().remove(aluno);
								alunoService.excluirAlunoID(aluno.getId());
							}
							
							// EXCLUIR CADASTRO DE PESSOA
							if (excluirCadastros == 2) {
								pessoaService.mostrarTodasPessoas();
								int opcaoPessoa = sc.nextInt();
								Pessoa pessoa = pessoaService.buscarPorId(opcaoPessoa);
								//pessoa.getPessoas().remove(pessoa);
								pessoaService.excluirPessoaID(pessoa.getId());
							}
					}
					
					if (identificacao == 0) {
						System.out.println("0 - Sair do Sistema!");
						continua = false;
					}	
				}
				

				}catch(InputMismatchException e) {
					System.out.println("Opção inválida!");
					System.out.println("Tente novamente! ");
					sc.nextLine();
				}
				
				catch(AlunoException e) {
					System.out.println(e.getMessage());
				}

				finally {
					Thread.sleep(1000);
					sc.nextLine();
				}
				
				}while (continua);
	}
}

	

		
