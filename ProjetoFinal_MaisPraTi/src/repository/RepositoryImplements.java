package repository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import model.Pessoa;
import repository.Repository;
	
	public class RepositoryImplements<I, T> implements Repository<I, T> {

		Map<I, T> repository = new TreeMap<>();

		@Override
		public List<T> buscarTodos() {
			return repository.values().stream().collect(Collectors.toList()); 
		}
		
		@Override
		public T buscarPorId(I id) {
			return repository.get(id);
		}
		
		// CRIAR - SALVAR
		@Override
		public void salvar(I chave, T objeto) {
			repository.put(chave, objeto);
		}
		
		// ATUALIZAR - SALVAR
		@Override
		public void atualizar(I chave, T objeto) {
			repository.put(chave, objeto);
		}
		
		@Override
		public void excluir(I id) {
			repository.remove(id);
		}

	
	}
