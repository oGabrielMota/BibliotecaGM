package br.com.aceleragep.BibliotecaGM.dto.inputs;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImagemLivroInput {
	
	@NotNull
	private String imagem;

	@AssertTrue(message = "Apenas Imagem séra aceito")
	public boolean isImagem() {
		return imagem.startsWith("data:image/");
	}

		
}

