package br.com.aceleragep.BibliotecaGM.dtos.outputs;



public class ImagemLivroOutput {
	
	private Long id;
	private String imagem;
	private LivroOutput livro;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public LivroOutput getLivro() {
		return livro;
	}
	public void setLivro(LivroOutput livro) {
		this.livro = livro;
	}
	
	
}
