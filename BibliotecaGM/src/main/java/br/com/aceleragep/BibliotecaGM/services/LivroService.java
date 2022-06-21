package br.com.aceleragep.BibliotecaGM.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aceleragep.BibliotecaGM.entities.LivroEntity;
import br.com.aceleragep.BibliotecaGM.entities.LivroImagemEntity;
import br.com.aceleragep.BibliotecaGM.exeptions.NotFoundBussinessException;
import br.com.aceleragep.BibliotecaGM.repository.LivroImagemRepository;
import br.com.aceleragep.BibliotecaGM.repository.LivroRepository;



@Service
public class LivroService {
	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private LivroImagemRepository livroImagemRepository;

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

	public LivroImagemEntity inseriImagem(LivroImagemEntity livroImagemEntity) {
		return livroImagemRepository.save(livroImagemEntity);
	}

	public LivroImagemEntity buscaImagem(LivroEntity livroLocalizado, Long imagemId) {
		LivroImagemEntity imagem = livroImagemRepository.findById(imagemId)
				.orElseThrow(() -> new NotFoundBussinessException(String.format("Imagem %d não encontrada", imagemId)));
		if (!imagem.getLivro().getId().equals(livroLocalizado.getId())) {
			throw new NotFoundBussinessException("Imagem não pertence ao livro.");
		}
		return imagem;
	}

	public void removeImagem(LivroImagemEntity imagemLocalizada) {
		livroImagemRepository.delete(imagemLocalizada);
	}

	public List<LivroImagemEntity> listaImagensPeloLivro(LivroEntity livroLocalizado) {
		return livroImagemRepository.findAllByLivro(livroLocalizado);
	}
}
