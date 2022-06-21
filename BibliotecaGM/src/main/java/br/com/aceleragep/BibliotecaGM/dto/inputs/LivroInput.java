package br.com.aceleragep.BibliotecaGM.dto.inputs;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
	@Length(max = 100 , message="Livro com nome Muito Grande, maximo 200 Caracteres")
	private String titulo;

	@NotNull(message = "Ano do Lançamento é obrigatório!")
	@Min(value= 1900, message="Indique um ano valido")
	@Max(value= 2023, message="Indique um ano valido")
	private Integer anoLancamento;
	

	@NotEmpty(message = "Deve ter pelo menos 1 autor!")
	private List<Long> Autores;
	
	
}
