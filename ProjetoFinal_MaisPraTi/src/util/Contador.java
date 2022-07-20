package util;

public abstract class Contador {
	
	public static int VALOR = 0;
	public static int VALOR1 = 0;
	
	public static Integer proximoId() {
		VALOR++;
		return VALOR;
	}
	
	public static Integer proximoIdPessoa() {
		VALOR++;
		return VALOR;
	}
}