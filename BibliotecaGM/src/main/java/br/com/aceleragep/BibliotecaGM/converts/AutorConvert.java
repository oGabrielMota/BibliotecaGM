package br.com.aceleragep.BibliotecaGM.converts;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

	public List<AutorOutput> entityToOutput(List<AutorEntity> autores) {
		return autores.stream().map(autorEntity -> {
			return entityToOutput(autorEntity);
		}).collect(Collectors.toList());
	}

	public void copyInputToEntity(AutorEntity autorEntity, AutorInput autorInput) {
		modelMapper.map(autorInput, autorEntity);
	}

}
