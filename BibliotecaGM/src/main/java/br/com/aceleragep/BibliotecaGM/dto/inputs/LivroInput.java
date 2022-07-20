package br.com.aceleragep.BibliotecaGM.dto.inputs;

import java.util.List;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LivroInput {
	
	@NotNull(message = "Titulo é obrigatório!")
	@Length(min = 3, message="Livro com nome Muito Curto, minimo 3 Caracteres")
	@Length(max = 200 , message="Livro com nome Muito Grande, maximo 200 Caracteres")
	private String titulo;

	@DecimalMin("1000")
	@DecimalMax("9999")
	@NotNull(message = "Ano lançamento é obrigatório!")
	private Integer anoLancamento;
	

	@NotEmpty(message = "Deve ter pelo menos 1 autor!")
	private List<Long> Autores;
	
	
}
