package br.com.anderson.json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.anderson.model.Anotacao;

public class AnotacaoHandler {
	
	private Gson gson;
	private String caminhoArquivoJson = "/home/bruno/eclipse-2019‑06-workspace/anotacoes/dados/anotacoes.json";
	
	public AnotacaoHandler() {
		gson = new Gson();
	}
	
	public void adicionarAnotacao(Anotacao anotacao) throws IOException {
		
		ArrayList<Anotacao> anotacoes = getTodasAnotacoes();
		boolean achou = false;
		
		for(Anotacao a : anotacoes) {
			if(a.getTitulo().equals(anotacao.getTitulo())) {
				achou = true;
				break;
			}
		}
		
		if(achou == true) {
			System.out.println("Titulo ja existente");
		}else {			
			anotacoes.add(anotacao);
			gravarAnotacoes(anotacoes);
			System.out.println("Anotacao adicionada com sucesso");
		}
		
	}
	
	public void removerAnotacao(String titulo) {
		//1-iterar usando for na lista de todas anotações(usa o método getTodasAnotacoes para pegar a lista)
		//2-verificar se algum item da lista tem esse titulo passado como argumento e remover ele da lista
		//3-se o título não existir exibe mensagem de que não existe
		//4-grava a lista atualizada sem o item removido no arquivo json
	}
	
	public void gravarAnotacoes(ArrayList<Anotacao> anotacoes) throws IOException {
		FileWriter fileWriter = new FileWriter(caminhoArquivoJson);
		gson.toJson(anotacoes, fileWriter);
		fileWriter.flush();
		fileWriter.close();
	}
	
	public ArrayList<Anotacao> getTodasAnotacoes() throws FileNotFoundException{
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(caminhoArquivoJson));
		Type type = new TypeToken<ArrayList<Anotacao>>() {}.getType();
		ArrayList<Anotacao> anotacoes = gson.fromJson(bufferedReader, type);
		return anotacoes;
	}

}
