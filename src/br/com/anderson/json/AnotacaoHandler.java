package br.com.anderson.json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.anderson.model.Anotacao;

public class AnotacaoHandler {
	
	private Gson gson;
	
	public AnotacaoHandler() {
		gson = new Gson();
	}
	
	public ArrayList<Anotacao> getTodasAnotacoes() throws FileNotFoundException{
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader("/home/bruno/eclipse-2019‑06-workspace/anotacoes/dados/anotacoes.json"));
		Type type = new TypeToken<ArrayList<Anotacao>>() {}.getType();
		ArrayList<Anotacao> anotacoes = gson.fromJson(bufferedReader, type);
		return anotacoes;
	}

}
