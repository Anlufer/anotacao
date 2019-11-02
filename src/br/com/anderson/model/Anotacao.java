package br.com.anderson.model;

public class Anotacao {
	
	private String titulo;
	private String corpo;
	
	public Anotacao(String titulo, String corpo) {
		super();
		this.titulo = titulo;
		this.corpo = corpo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getCorpo() {
		return corpo;
	}
	
	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
	
	@Override
	public String toString() {
		return "Anotacao [titulo=" + titulo + ", corpo=" + corpo + "]";
	}
}
