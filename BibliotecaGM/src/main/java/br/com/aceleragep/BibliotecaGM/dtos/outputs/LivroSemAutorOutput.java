package br.com.aceleragep.BibliotecaGM.dtos.outputs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroSemAutorOutput {

	private Long id;
	private String titulo;
	private String anoLancamento;
}
