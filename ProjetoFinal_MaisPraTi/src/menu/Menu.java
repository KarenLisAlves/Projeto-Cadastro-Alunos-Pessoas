package menu;

import model.Pessoa;

public class Menu {
	
	public static void bemVindo() {
		System.out.println("============================================");
		System.out.println("Bem Vindo ao sistema de cadastramento de Alunos e Pessoas");
		System.out.println("============================================");
	}
	
	public static void cadastramento() {
		System.out.println("1 - Cadastramento");
		System.out.println("2 - Verificar Cadastros gerais ");
		System.out.println("0 - Sair do Sistema");
	}
	
	public static void menuCondicao() {
		System.out.println("Digite a NOTA FINAL do curso! NOTA MÁXIMA: 100");
		System.out.println("Caso não tiveres nota final, digite a palavra 'NÃO'");	
	}
	
	public static void menuListasCadastros() {
		System.out.println();
		System.out.println("1 - Listar Cadastros de Alunos");
		System.out.println("2 - Listar Cadastros de Pessoas");
		System.out.println("3 - Atualizar cadastro"); // Aluno ou Pessoa
		System.out.println("4 - Excluir cadastro"); // Aluno ou Pessoa
		System.out.println("0 - Sair do Sistema");
	}
	
	public static void excluirCadastros() {	
		System.out.println();
		System.out.println("1 - EXCLUIR ALUNOS");
		System.out.println("2 - EXCLUIR PESSOAS");
	}
	
	public static void atualizarCadastros() {
		System.out.println();
		System.out.println("1 - ATUALIZAR CADASTROS ALUNOS");
		System.out.println("2 - ATUALIZAR CADASTROS PESSOAS");
	}

}
