package br.com.anderson.main;

import java.io.IOException;

import br.com.anderson.json.AnotacaoHandler;
import br.com.anderson.model.Anotacao;

public class AnotacaoApp {

	public static void main(String[] args) throws IOException {
		AnotacaoHandler anotacaoHandler = new AnotacaoHandler();
		
		Anotacao anotacao = new Anotacao("meu título 4", "corpo 3");
		anotacaoHandler.adicionarAnotacao(anotacao);
		
		//testar aqui o método removerAnotacao
		
		System.out.println(anotacaoHandler.getTodasAnotacoes());
	}

}
