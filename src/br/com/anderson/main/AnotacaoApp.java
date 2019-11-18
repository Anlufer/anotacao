package br.com.anderson.main;

import java.io.IOException;

import br.com.anderson.json.AnotacaoHandler;
import br.com.anderson.menu.Menu;
import br.com.anderson.model.Anotacao;

public class AnotacaoApp {

	public static void main(String[] args) throws IOException {
		/*AnotacaoHandler anotacaoHandler = new AnotacaoHandler();
		
		Anotacao anotacao = new Anotacao("nova anotacao", "meu corpo novo");
		anotacaoHandler.adicionarAnotacao(anotacao);
		
		anotacaoHandler.removerAnotacao("xpto");
		
		anotacaoHandler.alterarAnotacao("anotacao-arquivo-1", "kajflajflkajflka");
		//descomentar linha acima quando criar esse método na classe AnotacaoHandler. Aqui eh somente a chamada.
		
		anotacaoHandler.listarAnotacao();
		
		System.out.println(anotacaoHandler.getTodasAnotacoes());*/
		
		Menu menu = new Menu();
		menu.mostrarMenu();
	}

}
