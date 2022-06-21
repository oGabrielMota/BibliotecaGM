package br.com.aceleragep.BibliotecaGM.erros;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FieldsExceptionOutput {
	
	private String name;
	private String message;
	
}
