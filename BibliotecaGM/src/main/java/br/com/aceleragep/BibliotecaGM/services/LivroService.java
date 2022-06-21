package br.com.aceleragep.BibliotecaGM.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aceleragep.BibliotecaGM.entities.LivroEntity;
import br.com.aceleragep.BibliotecaGM.exeptions.NotFoundBussinessException;
import br.com.aceleragep.BibliotecaGM.repository.LivroRepository;



@Service
public class LivroService {
	@Autowired
	private LivroRepository livroRepository;


	public LivroEntity cria(LivroEntity livroEntity) {
		return livroRepository.save(livroEntity);
	}

	public List<LivroEntity> buscaLivrosPeloIdAutor(Long id) {

		return livroRepository.findAllByAutoresId(id);
	}

	public LivroEntity buscaLivroPeloId(Long id) {
		return livroRepository.findById(id)
				.orElseThrow(() -> new NotFoundBussinessException(String.format("Livro %d não encontrado", id)));
	}

	public List<LivroEntity> listaTodos() {
		return livroRepository.findAll();
	}

	public void remove(LivroEntity livroLocalizado) {
		livroRepository.delete(livroLocalizado);
	}

	public LivroEntity altera(LivroEntity livroEntity) {
		return livroRepository.save(livroEntity);
	}

}
