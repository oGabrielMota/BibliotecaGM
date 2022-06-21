package br.com.aceleragep.BibliotecaGM.dtos.outputs;

public class LivroSemAutorOutput {

	private Long id;

	private String titulo;

	private Integer anoLancamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Integer anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	
	
	
}
