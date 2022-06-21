package br.com.aceleragep.BibliotecaGM.dto.inputs;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LivroInput {
	
	@NotNull(message = "Titulo é obrigatório!")
	private String titulo;

	@NotNull(message = "Ano do Lançamento é obrigatório!")
	private Integer anoLancamento;

	@NotEmpty(message = "Deve ter pelo menos 1 autor!")
	private List<Long> Autores;
	
	
}
