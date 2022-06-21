package br.com.aceleragep.BibliotecaGM.converts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aceleragep.BibliotecaGM.dto.inputs.LivroInput;
import br.com.aceleragep.BibliotecaGM.dtos.outputs.ImagemLivroOutput;
import br.com.aceleragep.BibliotecaGM.dtos.outputs.LivroOutput;
import br.com.aceleragep.BibliotecaGM.dtos.outputs.LivroSemAutorOutput;
import br.com.aceleragep.BibliotecaGM.entities.AutorEntity;
import br.com.aceleragep.BibliotecaGM.entities.LivroEntity;
import br.com.aceleragep.BibliotecaGM.entities.LivroImagemEntity;
import br.com.aceleragep.BibliotecaGM.services.AutoresService;


@Component

public class LivroConvert {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AutoresService autorService;

	public LivroEntity inputToNewEntity(LivroInput livroInput) {
		LivroEntity livroEntity = modelMapper.map(livroInput, LivroEntity.class);
		converteIdsAutorParaAutores(livroInput, livroEntity);
		return livroEntity;
	}

	public void copyInputToEntity(LivroEntity livroEntity, LivroInput livroInput) {
		modelMapper.map(livroInput, livroEntity);
		converteIdsAutorParaAutores(livroInput, livroEntity);
	}

	public LivroOutput entityToOutput(LivroEntity livroEntity) {
		return modelMapper.map(livroEntity, LivroOutput.class);
	}

	public List<LivroOutput> entityToOutput(List<LivroEntity> livros) {
		return livros.stream().map(livroEntity -> {
			return entityToOutput(livroEntity);
		}).collect(Collectors.toList());
	}

	public LivroSemAutorOutput entityToSemAutorOutput(LivroEntity livroEntity) {
		return modelMapper.map(livroEntity, LivroSemAutorOutput.class);
	}

	public List<LivroSemAutorOutput> entityToSemAutorOutput(List<LivroEntity> livros) {
		return livros.stream().map(livroEntity -> {
			return entityToSemAutorOutput(livroEntity);
		}).collect(Collectors.toList());
	}

	private void converteIdsAutorParaAutores(LivroInput livroInput, LivroEntity livroEntity) {
		List<AutorEntity> autores = new ArrayList<>();
		for (Long idAutor : livroInput.getAutores()) {
			AutorEntity autor = autorService.buscaPeloId(idAutor);
			autores.add(autor);
		}
		livroEntity.setAutores(autores);
	}

	public ImagemLivroOutput imagemEntityToOutput(LivroImagemEntity imagemInserida) {
		return modelMapper.map(imagemInserida, ImagemLivroOutput.class);
	}

	public List<ImagemLivroOutput> imagemEntityToOutput(List<LivroImagemEntity> imagemLocalizada) {
		return imagemLocalizada.stream().map(livroEntity -> {
			return imagemEntityToOutput(livroEntity);
		}).collect(Collectors.toList());
	}
	
}
