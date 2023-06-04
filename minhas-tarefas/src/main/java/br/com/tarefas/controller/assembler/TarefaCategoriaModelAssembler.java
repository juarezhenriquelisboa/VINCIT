package br.com.tarefas.controller.assembler;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import br.com.tarefas.controller.TarefaCategoriaController;
import br.com.tarefas.controller.response.TarefaCategoriaResponse;
import br.com.tarefas.model.TarefaCategoria;

public class TarefaCategoriaModelAssembler implements 
	RepresentationModelAssembler<TarefaCategoria, EntityModel<TarefaCategoriaResponse>>{

	@Autowired
	private ModelMapper mapper;
	
	@Override
	public EntityModel<TarefaCategoriaResponse> toModel(TarefaCategoria categoria){
		
		TarefaCategoriaResponse categoriaResp = mapper.map(categoria, TarefaCategoriaResponse.class);

		EntityModel<TarefaCategoriaResponse> tarefaModel = EntityModel.of(categoriaResp,
				WebMvcLinkBuilder.linkTo(
						WebMvcLinkBuilder.methodOn(TarefaCategoriaController.class).
						umaCategoria(categoriaResp.getId())).withSelfRel(),
				WebMvcLinkBuilder.linkTo(
						WebMvcLinkBuilder.methodOn(TarefaCategoriaController.class).
						umaCategoria(categoriaResp.getId())).withRel("categoria"));
	
		
		return tarefaModel;
	}
}
