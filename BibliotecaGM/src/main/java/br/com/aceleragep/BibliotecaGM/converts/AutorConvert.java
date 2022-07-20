package br.com.aceleragep.BibliotecaGM.converts;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.aceleragep.BibliotecaGM.dto.inputs.AutorInput;
import br.com.aceleragep.BibliotecaGM.dtos.outputs.AutorOutput;
import br.com.aceleragep.BibliotecaGM.entities.AutorEntity;



@Component
public class AutorConvert {

	@Autowired
	private ModelMapper modelMapper;

	public AutorEntity inputToNewEntity(AutorInput autorInput) {
		return modelMapper.map(autorInput, AutorEntity.class);
	}

	public AutorOutput entityToOutput(AutorEntity autorEntity) {
		return modelMapper.map(autorEntity, AutorOutput.class);
	}

	public void copyInputToEntity(AutorEntity  autorEncontrado, @Valid AutorInput autorInput) {
		modelMapper.map(autorInput, autorEncontrado);
	}
	
	public Page<AutorOutput> entityToOutput(Page<AutorEntity> autores, Pageable paginacao) {
		return new PageImpl<>(autores.stream().map(autorEntity -> {
			return entityToOutput(autorEntity);
		}).collect(Collectors.toList()));
	}
	
	public Page<AutorOutput> listPageEntityToListPageOutput(Page<AutorEntity> livros){
		return livros.map(this::entityToOutput);
	}

}
