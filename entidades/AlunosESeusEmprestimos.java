package entidades;

public class AlunosESeusEmprestimos {
		
		private int ra;
		private long isbn;
		private String nome;
		private int dia;
		private int mes;
		private int ano;
		private int hora;
		private int minutos;
		private int segundos;
		
		
		public AlunosESeusEmprestimos(int ra, String nome, long isbn, int dia, int mes, int ano, int hora, int minutos,int segundos) {
			
			this.ra = ra;
			this.isbn = isbn;
			this.nome = nome;
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
			this.hora = hora;
			this.minutos = minutos;
			this.segundos = segundos;
		}
		
		
		
		public AlunosESeusEmprestimos() {
			
		}


		public int getRa() {
			return ra;
		}

		public void setRa(int ra) {
			this.ra = ra;
		}

		public long getIsbn() {
			return isbn;
		}

		public void setIsbn(long isbn) {
			this.isbn = isbn;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getDia() {
			return dia;
		}

		public void setDia(int dia) {
			this.dia = dia;
		}

		public int getMes() {
			return mes;
		}

		public void setMes(int mes) {
			this.mes = mes;
		}

		public int getAno() {
			return ano;
		}

		public void setAno(int ano) {
			this.ano = ano;
		}

		public int getHora() {
			return hora;
		}

		public void setHora(int hora) {
			this.hora = hora;
		}

		public int getMinutos() {
			return minutos;
		}

		public void setMinutos(int minutos) {
			this.minutos = minutos;
		}

		public int getSegundos() {
			return segundos;
		}

		public void setSegundos(int segundos) {
			this.segundos = segundos;
		}

		

		
		

		public String toString() {
			return "RA: " + ra + ", ISBN: " + isbn + ", Nome: " + nome + ", Pegou o livro no dia: " + dia + "/" + (mes+1);
		}



		
		
		
		
		
		

	}

	


