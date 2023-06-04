package br.com.tarefas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.model.TarefaCategoria;
import br.com.tarefas.repository.TarefaCategoriaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TarefaCategoriaService {

	@Autowired
	private TarefaCategoriaRepository tarefaCategoriaRepositorio;

	public List<TarefaCategoria> getTodasCategorias() {
		return tarefaCategoriaRepositorio.findAll();
	}

	public TarefaCategoria getCategoriaPorId(Integer id) {
		return tarefaCategoriaRepositorio.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	public Object salvar(TarefaCategoria categoria) {
		return tarefaCategoriaRepositorio.save(categoria);
	}

	public void deleteById(Integer id) {
		tarefaCategoriaRepositorio.deleteById(id);		
	}

}
