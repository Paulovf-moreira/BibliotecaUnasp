package entidades;

public class Livros {

	private long isbn;
	private String titulo;
	private String editora;
	private int ano;
	
	
	public Livros(long isbn, String titulo, String editora, int ano) {
		
		this.isbn = isbn;
		this.titulo = titulo;
		this.editora = editora;
		this.ano = ano;
	}


	public long getIsbn() {
		return isbn;
	}


	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getEditora() {
		return editora;
	}


	public void setEditora(String editora) {
		this.editora = editora;
	}


	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String toString() {
		
		return "ISBN: "+isbn+", Titulo: "+titulo+", Editora: "+editora+", Ano de publicação: "+ano;
	}
	
}
