package repository;

import java.util.List;

// GENERICS													
public interface Repository<I, T> {

	public List<T> buscarTodos();
	
	public T buscarPorId(I id);
	
	public void salvar(I chave, T objeto);
	
	public void atualizar (I chave, T objeto);
	
	public void excluir(I id);
	
}