package br.com.aceleragep.BibliotecaGM.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.aceleragep.BibliotecaGM.entities.AutorEntity;
import br.com.aceleragep.BibliotecaGM.exeptions.NotFoundBussinessException;
import br.com.aceleragep.BibliotecaGM.repository.AutorRepository;


@Service
public class AutoresService {
	@Autowired
	private AutorRepository autorRepository;

	public AutorEntity cria(AutorEntity autorEntity) {
		return autorRepository.save(autorEntity);
	}

	public AutorEntity atualiza(AutorEntity autorEntity) {
		return autorRepository.save(autorEntity);
	}

	public AutorEntity buscaPeloId(Long id) {
		Optional<AutorEntity> encontrou = autorRepository.findById(id);
		if (encontrou.isPresent()) {
			return encontrou.get();
		} else {
			throw new NotFoundBussinessException("Autor " + id + " não encontrado");
		}
	}

	public Page<AutorEntity> listaTodos(Pageable paginacao){
		Page<AutorEntity> encontrou = autorRepository.findAll(paginacao);
		return encontrou;
	}


}
