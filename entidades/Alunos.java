package entidades;

public class Alunos {
	


	
	private int ra;
	private String nome;
	private String curso;
	private String email;
	
	public Alunos(int ra, String nome, String curso, String email) {
		this.ra = ra;
		this.nome = nome;
		this.curso = curso;
		this.email = email;
	}
	
	
	
	public int getRa() {
		return ra;
	}



	public void setRa(int ra) {
		this.ra = ra;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCurso() {
		return curso;
	}



	public void setCurso(String curso) {
		this.curso = curso;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	


	public String toString() {
		return "RA: "+ra+", Nome: "+nome+", Curso: "+curso+", Email: "+email;
		
	}



	


	
}

