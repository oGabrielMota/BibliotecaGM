package br.com.aceleragep.BibliotecaGM.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.aceleragep.BibliotecaGM.configs.URLConfig;
import br.com.aceleragep.BibliotecaGM.converts.LivroConvert;
import br.com.aceleragep.BibliotecaGM.dto.inputs.ImagemLivroInput;
import br.com.aceleragep.BibliotecaGM.dto.inputs.LivroInput;
import br.com.aceleragep.BibliotecaGM.dtos.outputs.ImagemLivroOutput;
import br.com.aceleragep.BibliotecaGM.dtos.outputs.LivroOutput;
import br.com.aceleragep.BibliotecaGM.entities.LivroEntity;
import br.com.aceleragep.BibliotecaGM.entities.LivroImagemEntity;
import br.com.aceleragep.BibliotecaGM.services.LivroService;



@RestController
@RequestMapping(URLConfig.URL_BASE + "/livros")

public class LivroController {
	
	@Autowired
	private LivroConvert livroConvert;

	@Autowired
	private LivroService livroService;

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public LivroOutput cria(@RequestBody @Valid LivroInput livroInput) {
		LivroEntity livroEntity = livroConvert.inputToNewEntity(livroInput);
		LivroEntity livroCriado = livroService.cria(livroEntity);
		return livroConvert.entityToOutput(livroCriado);
	}

	@PutMapping("/{id}")
	public LivroOutput alterar(@PathVariable Long id, @RequestBody @Valid LivroInput livroInput) {
		LivroEntity livroLocalizado = livroService.buscaLivroPeloId(id);
		livroConvert.copyInputToEntity(livroLocalizado, livroInput);
		LivroEntity livroAlterado = livroService.altera(livroLocalizado);
		return livroConvert.entityToOutput(livroAlterado);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long id) {
		LivroEntity livroLocalizado = livroService.buscaLivroPeloId(id);
		livroService.remove(livroLocalizado);
	}

	@GetMapping("/{id}")
	public LivroOutput buscarPeloId(@PathVariable Long id) {
		LivroEntity livroLocalizado = livroService.buscaLivroPeloId(id);
		return livroConvert.entityToOutput(livroLocalizado);
	}

	@GetMapping()
	public List<LivroOutput> listaTodos() {
		List<LivroEntity> livrosLocalizados = livroService.listaTodos();
		return livroConvert.entityToOutput(livrosLocalizados);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/{id}/imagem")
	public ImagemLivroOutput imagem(@RequestBody @Valid ImagemLivroInput livroImagemInput, @PathVariable Long id) {
		LivroEntity livroLocalizado = livroService.buscaLivroPeloId(id);
		LivroImagemEntity livroImagemEntity = new LivroImagemEntity(null, livroImagemInput.getImagem(),
				livroLocalizado);
		LivroImagemEntity imagemInserida = livroService.inseriImagem(livroImagemEntity);
		return livroConvert.imagemEntityToOutput(imagemInserida);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}/imagem/{imagemId}")
	public void removeImagem(@PathVariable Long id, @PathVariable Long imagemId) {
		LivroEntity livroLocalizado = livroService.buscaLivroPeloId(id);
		LivroImagemEntity imagemLocalizada = livroService.buscaImagem(livroLocalizado, imagemId);
		livroService.removeImagem(imagemLocalizada);
	}

	@GetMapping("/{id}/imagem/{imagemId}")
	public ImagemLivroOutput buscaImagem(@PathVariable Long id, @PathVariable Long imagemId) {
		LivroEntity livroLocalizado = livroService.buscaLivroPeloId(id);
		LivroImagemEntity imagemLocalizada = livroService.buscaImagem(livroLocalizado, imagemId);
		return livroConvert.imagemEntityToOutput(imagemLocalizada);
	}

	@GetMapping("/{id}/imagem")
	public List<ImagemLivroOutput> listaTodasImagens(@PathVariable Long id) {
		LivroEntity livroLocalizado = livroService.buscaLivroPeloId(id);
		List<LivroImagemEntity> imagemLocalizada = livroService.listaImagensPeloLivro(livroLocalizado);
		return livroConvert.imagemEntityToOutput(imagemLocalizada);
	}

}
