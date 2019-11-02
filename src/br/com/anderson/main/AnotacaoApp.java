package br.com.anderson.main;

import java.io.FileNotFoundException;

import br.com.anderson.json.AnotacaoHandler;

public class AnotacaoApp {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(new AnotacaoHandler().getTodasAnotacoes());
	}

}
