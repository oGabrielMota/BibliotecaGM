package br.com.aceleragep.BibliotecaGM.dto.inputs;


import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AutorInput {
	@NotEmpty(message="Nome é obrigatório!")
	@Length(min = 3, message="Nome curto demais, minimo 3 Caracteres")
	@Length(max = 100 , message="Nome grande demais, maximo 100 Caracteres")
	private String nome;
	
	@NotEmpty(message="Biografia é obrigatória!")
	@Length(max = 1000 , message="Biografia muito grande, maximo 1000 Caracteres")
	private String biografia;
}
