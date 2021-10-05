package aplicacao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import entidades.Alunos;
import entidades.AlunosESeusEmprestimos;
import entidades.Emprestimo;
import entidades.Livros;

public class Biblioteca {
	
	public static int menu (Scanner sc) {
		
		System.out.println("================================");
		System.out.println("        Seja bem vindo!!!        ");
		System.out.println("================================");
		System.out.println("Escolha o que deseja realizar: ");
		System.out.println("1 - Cadastrar Alunos");
		System.out.println("2 - Cadastrar Livros");
		System.out.println("3 - Cadastrar Emprestimo");
		System.out.println("4 - Pesquisar Livro");
		System.out.println("5 - Listar Alunos");
		System.out.println("6 - Listar Livros");
		System.out.println("7 - Listar Emprestimos em atraso");
		System.out.println("8 - Remover Emprestimo");
		System.out.println("9 - Remover Aluno");
		System.out.println("10 - Remover Livro");
		System.out.println("11 - Finalizar o dia");
		
		
		return sc.nextInt();
	}
	
	public static int menu2 (Scanner sc) {
		System.out.println("        PESQUISAR LIVRO       ");
		System.out.println("Escolha o modo de pesquisa: ");
		System.out.println("1 - Pesquisar pelo ISBN");
		System.out.println("2 - Pesquisar pelo Titulo");
		System.out.println("3 - Listar todos os alunos que pegaram um determinado livro");
		System.out.println("4 - Sair");
		
		return sc.nextInt();
	}
	
	
	public static void main(String[] args) {
		
		Calendar hoje = Calendar.getInstance();
		
		Scanner sc = new Scanner (System.in);
		
		List <Alunos> lista = new ArrayList<Alunos>();
		List <Livros> list = new ArrayList<Livros>();
		List <Emprestimo>lista3 = new ArrayList<Emprestimo>();
		List<AlunosESeusEmprestimos>lista4 = new ArrayList<AlunosESeusEmprestimos>();
		
		int tempoDeEmprestimo = 0;
		int menosUmDia =0;
		
		boolean fim = true;
		
		while(fim) {
			int opcoes = menu(sc);
			switch (opcoes) {
				
				case 1:
					System.out.print("Quantos alunos registrar?: ");
					int contador = sc.nextInt();
					for(int i=1;i<=contador;i++) {
						
						System.out.println();
						System.out.print("RA: ");
						int ra = sc.nextInt();
						
						while(temRA(lista,ra )) {
							System.out.println("Erro: o RA informado já está cadastrado! Tente novamente.");
							System.out.print("RA: ");
							ra = sc.nextInt();
						}
					
						System.out.print("Nome: ");
						String nome = sc.next()+sc.nextLine();
						System.out.print("Email: ");
						String email = sc.next();
						System.out.print("Curso: ");
						String curso = sc.next()+sc.nextLine();
						Alunos alunos = new Alunos(ra, nome, curso, email);
						lista.add(alunos);
					}
					break;
					
				case 2:
					System.out.print("Quantos Livros Cadastrar?: ");
					contador = sc.nextInt();
					for(int i=1;i<=contador;i++) {
						System.out.println();
						
						System.out.println();
						System.out.print("ISBN: ");
						long isbn = sc.nextLong();
						while (temISBN(list, isbn)) {
							System.out.println("Erro: O ISBN informado já está cadastrado! Tente novamente.");
							isbn =sc.nextLong();
						}
						System.out.print("Titulo: ");
						String titulo = sc.next()+sc.nextLine();
						System.out.print("Editora: ");
						String editora = sc.next()+sc.nextLine();
						
						System.out.print("Ano: ");
						int ano = sc.nextInt();
						Livros livros = new Livros(isbn, titulo, editora, ano);
						list.add(livros);
						
						
					}
					break;
					
				case 3:
					int fim3 = 0;
					System.out.println("Cadastramento de emprestimo: ");
					System.out.println();
					
					System.out.print("RA do aluno: ");
					int ra = sc.nextInt();
					for(Emprestimo emprestimos:lista3) {
						
						while(emprestimos.getTempoDoEmprestimo()<0 && emprestimos.getRa()==ra && fim3 !=1) {
							
							System.out.println("ERRO: O aluno possui emprestimos em atraso!");
							
							System.out.println("Informe outro RA: ");
							ra=sc.nextInt();
							
							while(verificarCadastroAluno(lista, ra)) {
								System.out.println("Erro: Aluno não cadastrado! Informe outro RA ou faça o cadastro do mesmo.");
								System.out.print("RA do aluno: ");
								ra = sc.nextInt();
							}
							
						}
						
					}
					
					while(verificarCadastroAluno(lista, ra)) {
						System.out.println("Erro: Aluno não cadastrado! Informe outro RA ou faça o cadastro do mesmo.");
						System.out.print("RA do aluno: ");
						ra = sc.nextInt();
					}
					
					System.out.print("Nome: ");
					String nome = sc.next()+sc.nextLine();
					
					System.out.print("ISBN do livro: ");
					long isbn = sc.nextLong();
					for(Emprestimo disponivel:lista3) {
						
						while(disponivel.getIsbn()==isbn) {
							System.out.println("No momento não temos exemplares disponiveis, informe outro livro");
							System.out.println();
							System.out.println("ISBN do livro: ");
							isbn = sc.nextLong();
						}
					}
					while(verificarCadastroLivro(list,isbn)) {
						System.out.println("ERRO: Livro não cadastrado! Informe outro ISBN ou faça o cadastro do mesmo.");
						System.out.print("ISBN do livro: ");
						isbn = sc.nextLong();
					}
					
					System.out.print("Emprestar por quantos dias?: ");
					 tempoDeEmprestimo = sc.nextInt();
					
					int dia = hoje.get(Calendar.DAY_OF_MONTH);
					int mes = hoje.get(Calendar.MONTH);
					int ano = hoje.get(Calendar.YEAR);
					int hora = hoje.get(Calendar.HOUR_OF_DAY);
					int minutos = hoje.get(Calendar.MINUTE);
					int segundos = hoje.get(Calendar.SECOND);
					
					Emprestimo emprestimo = new Emprestimo(ra, nome, isbn, dia, mes, ano, hora, minutos, segundos, tempoDeEmprestimo);
					lista3.add(emprestimo);
					
					AlunosESeusEmprestimos determinadoLivro = new AlunosESeusEmprestimos(ra, nome, isbn, dia, mes, ano, hora, minutos, segundos);
					lista4.add(determinadoLivro);
					
					break;
					
				case 4:
					
					boolean fim2 = true;
					while(fim2) {
						int opcao2 = menu2(sc);
						if(opcao2 == 1) {
							System.out.print("Informe o ISBN do livro: ");
							isbn = sc.nextLong();
							System.out.println(pesquisarLivro(list,isbn));
							System.out.println();
							
						}else if (opcao2 == 2) {
							System.out.print("Informe o Titulo do livro: ");
							String titulo = sc.next()+sc.nextLine();
							System.out.println(pesquisarLivro2(list,titulo));
							System.out.println();
						}else if (opcao2 == 3) {
							
							System.out.print("Informe o ISBN do livro: ");
							isbn = sc.nextLong();
							for (AlunosESeusEmprestimos listaAluno:lista4) {
								
								if(listaAluno.getIsbn()==isbn) {
									System.out.println(listaAluno);
									System.out.println();
								}
							}
							
						}else if(opcao2 == 4) {
							fim2 = false;
						}
					}
					
					break;
				case 5:
					System.out.println();
					System.out.println("Lista de alunos cadastrados: ");
					for(Alunos alunos: lista ) {
						
						System.out.println(alunos);
					}
					
					break;
					
				case 6:
					System.out.println();
					System.out.println("Lista de livros cadastrados: ");
					for(Livros livros: list) {
						
						System.out.println(livros);
					}
					break;
				
				case 7:
					System.out.println();
					System.out.println("Lista de emprestimos em atraso:");
					for(Emprestimo emprestimos:lista3) {
						
						if(emprestimos.getTempoDoEmprestimo()<0) {
							
							
							System.out.println(emprestimos);
							
							
						}	
						
					}
					System.out.println();
					break;
					
				case 8:
					System.out.println("REMOÇÃO DE EMPRESTIMO");
					System.out.println();
					System.out.print("Informe ISBN do livro: ");
					isbn = sc.nextLong();
					
					if(removerEmprestimo(lista3,isbn)) {
						System.out.println("Emprestimo removido com sucesso!");
					}else {
						System.out.println("ERRO: O livro informado não foi emprestado!");
					}
					
					
					break;
					
				case 9:
					System.out.print("Informe o RA do aluno que deseja remover: ");
					ra =sc.nextInt();
					
					if(removerAluno(lista,ra)) {
						System.out.println("Aluno removido com sucesso");
					}else {
						System.out.println("ERRO: Aluno não cadastrado!");
					}
					
				
					
					
					break;
					
				case 10:
					System.out.print("Informe o ISBN do livro que deseja remover: ");
					isbn = sc.nextLong();
					
					if(removerLivros(list,isbn)) {
						System.out.println("Livro removido com sucesso!");
					}else {
						System.out.println("ERRO: Livro não cadastrado!");
					}
					break;
					
				case 11:
					menosUmDia--;
					System.out.println(passagemDeDia(lista3,menosUmDia));
					
					break;
			}//Fim switch
			
			
			
			
		
		}

		
		sc.close();
	}
	



	public static boolean temRA(List<Alunos> lista,int ra) { // Metodo para bloquear repetição de RA
		Alunos alunos = lista.stream().filter(list -> list.getRa() == ra).findFirst().orElse(null); 
		return alunos !=null;
	}
	
	public static boolean temISBN (List<Livros> list, long isbn) { // Metodo para bloquear repetição de ISBN
		Livros livros = list.stream().filter(lista -> lista.getIsbn() == isbn).findFirst().orElse(null);
		return livros !=null;
	}
	
	public static boolean verificarCadastroAluno(List<Alunos> lista,int ra) { //verifica se o aluno já foi cadastrado antes do emprestimo
		Alunos alunos = lista.stream().filter(list->list.getRa() == ra).findFirst().orElse(null);
		return alunos == null;
	}
	
	public static boolean verificarCadastroLivro(List<Livros> list,long isbn) { //verifica se o Livro já foi cadastrado antes do emprestimo
		Livros livros = list.stream().filter(lista->lista.getIsbn() == isbn).findFirst().orElse(null);
		return livros == null;
	}
	
	public static boolean removerAluno(List<Alunos> lista,int ra) { // Metodo para remover alunos
		Alunos alunos = lista.stream().filter(list -> list.getRa() == ra).findFirst().orElse(null); 
		return lista.remove(alunos);
	}
	
	public static boolean removerLivros (List<Livros> list, long isbn) { // Metodo para remover livro
		Livros livros = list.stream().filter(lista -> lista.getIsbn() == isbn).findFirst().orElse(null);
		return list.remove(livros);
	}
	
	public static boolean removerEmprestimo  (List<Emprestimo> lista3, long isbn) { // Metodo para remover emprestimo
		Emprestimo emprestimo = lista3.stream().filter(lista -> lista.getIsbn() == isbn).findFirst().orElse(null);
		return lista3.remove(emprestimo);
	}
	
	public static Livros pesquisarLivro(List<Livros> list,long isbn) { //Pesquisar livro pelo ISBN
		Livros livros = list.stream().filter(lista ->lista.getIsbn() == isbn).findFirst().orElse(null);
		
		return livros;
	}
	
	public static Livros pesquisarLivro2(List<Livros> list,String titulo) { //Pesquisar livro pelo Titulo
		Livros livros = list.stream().filter(lista ->lista.getTitulo().equals(titulo)).findFirst().orElse(null);
		return livros;
	}
	
	
	public static Emprestimo passagemDeDia(List<Emprestimo> lista3, int menosUmDia) { //Metodo para finalização do dia. Criado para cumprir o requisito de listar emprestimos em atraso.
		for (int i =0;i<lista3.size();i++) {
			lista3.get(i).setMenosUmDia(menosUmDia);
			
			
			
		}
		System.out.println("Até Breve!");
		return null;
	}

	
	}

