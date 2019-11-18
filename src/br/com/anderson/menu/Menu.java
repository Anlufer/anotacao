package br.com.anderson.menu;

import java.io.IOException;
import java.util.Scanner;

import br.com.anderson.json.AnotacaoHandler;
import br.com.anderson.model.Anotacao;

public class Menu {
	
	AnotacaoHandler anotacaoHandler = new AnotacaoHandler();
	Scanner scanner = new Scanner(System.in);
		
	public void mostrarMenu() throws IOException {

		int opcao = 0;
		
		while(opcao != 6) {
			limparTela();
			System.out.println("1-Adicionar usu�rio");
			System.out.println("2-Remover usu�rio");
			System.out.println("3-Alterar usu�rio");
			System.out.println("4-Listar usu�rio");
			System.out.println("5-Buscar usu�rio");
			System.out.println("6-Sair");
			
			opcao = scanner.nextInt();
			
			//Na classe AnotacaoHandler implementar m�todo listarAnotacoes que lista todas anota��es no seguinte formato: t�tulo: xpto, corpo: xpto
			//implementar outros cases para as op��es: editar, remover e listar anota��es
			switch (opcao) {
			case 1:
				limparTela();
				adicionarAnotacao();
				scanner.nextLine();
				break;
			case 2:
				limparTela();
				removerAnotacao();
				scanner.nextLine();
				break;
			case 3:
				limparTela();
				alterarAnotacao();
				scanner.nextLine();
				break;
			case 4:
				limparTela();
				listaAnotacao();
				scanner.nextLine();
				break;
			case 5:
				buscarAnotacao();
				listaAnotacao();
				scanner.nextLine();
				break;
			case 6:
				System.exit(-1);
				break;
			default:
				System.out.println("Op��o inv�lida");
				break;
			}
		}
	}

	
	private void buscarAnotacao() throws IOException {
		scanner.nextLine();		
		System.out.println("Digite o t�tulo: ");
		String titulo = scanner.nextLine();
		anotacaoHandler.buscaPorNome(titulo);		
	}


	private void listaAnotacao() throws IOException {
		scanner.nextLine();
		anotacaoHandler.listarAnotacao();
	}

	private void alterarAnotacao() throws IOException {
        scanner.nextLine();		
		System.out.println("Digite o t�tulo: ");
		String titulo = scanner.nextLine();
		System.out.println("Digite o corpo: ");
		String corpo = scanner.nextLine();	
		anotacaoHandler.alterarAnotacao(titulo, corpo);	
	}


	private void removerAnotacao() throws IOException {
		scanner.nextLine();		
		System.out.println("Digite o t�tulo: ");
		String titulo = scanner.nextLine();
		anotacaoHandler.removerAnotacao(titulo);
	}


	private void adicionarAnotacao() throws IOException {		
		scanner.nextLine();		
		System.out.println("Digite o t�tulo: ");
		String titulo = scanner.nextLine();
		System.out.println("Digite o corpo: ");
		String corpo = scanner.nextLine();
		
		Anotacao anotacao = new Anotacao(titulo, corpo);
		anotacaoHandler.adicionarAnotacao(anotacao);		
	}
	
	private void limparTela() throws IOException {		
		//Runtime.exec("cls");
		for (int i = 0; i < 50; ++i) {			
			System.out.println();
		}
	}

}
