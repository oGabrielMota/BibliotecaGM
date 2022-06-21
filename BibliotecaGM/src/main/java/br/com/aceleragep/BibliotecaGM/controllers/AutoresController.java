package br.com.aceleragep.BibliotecaGM.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aceleragep.BibliotecaGM.configs.URLConfig;
import br.com.aceleragep.BibliotecaGM.converts.AutorConvert;
import br.com.aceleragep.BibliotecaGM.converts.LivroConvert;
import br.com.aceleragep.BibliotecaGM.dto.inputs.AutorInput;
import br.com.aceleragep.BibliotecaGM.dtos.outputs.AutorOutput;
import br.com.aceleragep.BibliotecaGM.dtos.outputs.LivroSemAutorOutput;
import br.com.aceleragep.BibliotecaGM.entities.AutorEntity;
import br.com.aceleragep.BibliotecaGM.entities.LivroEntity;
import br.com.aceleragep.BibliotecaGM.services.AutoresService;
import br.com.aceleragep.BibliotecaGM.services.LivroService;




@RestController
@RequestMapping(URLConfig.URL_BASE + "/autores")

public class AutoresController {
	
	@Autowired
	private AutoresService autorService;

	@Autowired
	private LivroService livroService;

	@Autowired
	private AutorConvert autorConvert;

	@Autowired
	private LivroConvert livroConvert;

	@PostMapping
	public AutorOutput cria(@RequestBody AutorInput autorInput) {
		AutorEntity autorEntity = autorConvert.inputToNewEntity(autorInput);
		AutorEntity autorCriado = autorService.cria(autorEntity);
		return autorConvert.entityToOutput(autorCriado);
	}

	@PutMapping("/{id}")
	public AutorOutput atualiza(@PathVariable Long id, @RequestBody @Valid AutorInput autorInput) {
		AutorEntity autorEncontrado = autorService.buscaPeloId(id);
		autorConvert.copyInputToEntity(autorEncontrado, autorInput);
		AutorEntity autorAtualizado = autorService.atualiza(autorEncontrado);
		return autorConvert.entityToOutput(autorAtualizado);
	}

	@GetMapping("/{id}")
	public AutorOutput buscaPorId(@PathVariable Long id) {
		AutorEntity autorEncontrado = autorService.buscaPeloId(id);
		return autorConvert.entityToOutput(autorEncontrado);
	}

	@GetMapping
	public List<AutorOutput> listaTodos() {
		List<AutorEntity> listaTodos = autorService.listaTodos();
		return autorConvert.entityToOutput(listaTodos);
	}

	@GetMapping("/{id}/livros")
	public List<LivroSemAutorOutput> buscaLivroPeloIdDoAutor(@PathVariable Long id) {
		autorService.buscaPeloId(id);
		List<LivroEntity> livros = livroService.buscaLivrosPeloIdAutor(id);
		return livroConvert.entityToSemAutorOutput(livros);
	}

	
	
}
