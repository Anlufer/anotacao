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
	private String caminhoArquivoJson = "C:\\Users\\anderfer\\Desktop\\Pessoais\\Projetos Eclipse\\anotacao-master\\dados\\anotacoes.json";

	public AnotacaoHandler() {
		gson = new Gson();
	}

	public void adicionarAnotacao(Anotacao anotacao) throws IOException {

		ArrayList<Anotacao> anotacoes = getTodasAnotacoes();
		boolean achou = false;

		for (Anotacao a : anotacoes) {
			if (a.getTitulo().equals(anotacao.getTitulo())) {
				achou = true;
				break;
			}
		}

		if (achou == true) {
			System.out.println("Titulo ja existente");
		} else {
			anotacoes.add(anotacao);
			gravarAnotacoes(anotacoes);
			System.out.println("Anotacao adicionada com sucesso");
		}

	}

	public void removerAnotacao(String titulo) throws IOException {

		ArrayList<Anotacao> anotacoes = getTodasAnotacoes();
//		boolean achou = false;		
		int tamanho = anotacoes.size();

		for (int i = 0; i < anotacoes.size(); i++) {
			Anotacao a = anotacoes.get(i);

			if (a.getTitulo().equals(titulo)) {
				anotacoes.remove(i);
				gravarAnotacoes(anotacoes);
//				achou = true;
			}
		}
		if (tamanho == anotacoes.size()) {
			System.out.println("Titulo não encontrado");
		}

//		if(achou == false) {
//			System.out.println("Titulo não existe");
//		}
	}
	
	//1-criar método alterarAnotacao AQUI que recebe dois parâmetros, o primeiro é o título existente e o segundo o corpo novo
	//2-pegar lista de anotações usando getTodasAnotacoes()
	//3-iterar na lista verificando se encontra a anotação com mesmo título do primeiro parâmetro recebido
	//4-se encontrar colocar o corpo novo(segundo parâmetro) através do método set. Chamar método set na lista para substituir uma anotação pela outra.
	//5-gravar lista atualizada no arquivo usando método gravarAnotacoes
	//6-Testar todo trabalho executando o programa.
	public void alterarAnotacao(String titulo, String corpo) throws IOException {
		ArrayList<Anotacao> anotacoes = getTodasAnotacoes();
		boolean achou = false;
		for (int i = 0; i < anotacoes.size(); i++) {
			Anotacao a = anotacoes.get(i);
			if (a.getTitulo().equals(titulo)) {
				a.setCorpo(corpo);
				gravarAnotacoes(anotacoes);
				achou = true;
			}
		}
		
		if(achou == false) {
		System.out.println("Titulo não alterado");
		}	
	}	

	public void gravarAnotacoes(ArrayList<Anotacao> anotacoes) throws IOException {
		FileWriter fileWriter = new FileWriter(caminhoArquivoJson);
		gson.toJson(anotacoes, fileWriter);
		fileWriter.flush();
		fileWriter.close();
	}

	public ArrayList<Anotacao> getTodasAnotacoes() throws FileNotFoundException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(caminhoArquivoJson));
		Type type = new TypeToken<ArrayList<Anotacao>>() {
		}.getType();
		ArrayList<Anotacao> anotacoes = gson.fromJson(bufferedReader, type);
		return anotacoes;
	}

	public void listarAnotacao() throws FileNotFoundException {		
		ArrayList<Anotacao> anotacoes = getTodasAnotacoes();
		for (int i = 0; i < anotacoes.size(); i++) {
			Anotacao a = anotacoes.get(i);
			System.out.println(a);
		}
	}

	//TODO: fazer um método AQUI chamado buscarPorNome que recebe o título de um anotação e imprime ela. Chamar ele lá no menu
	public void buscaPorNome(String titulo) throws IOException {
		ArrayList<Anotacao> anotacoes = getTodasAnotacoes();
		boolean achou = false;
		for (int i = 0; i < anotacoes.size(); i++) {
			Anotacao a = anotacoes.get(i);
			if (a.getTitulo().equals(titulo)) {
				System.out.println(titulo);
				achou = true;
			}
		}
		
		if(achou == false) {
		System.out.println("Titulo não encontrado");
		}	
		
	}
}
