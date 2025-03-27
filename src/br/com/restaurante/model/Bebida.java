package br.com.restaurante.model;

public class Bebida {

	private int codigo;
	private String nome;
	private String descricao;
	private float preco;


	
	public Bebida(int codigo, String nome, String descricao, float preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public void exibirBebida() {
		System.out.println("Código: " + this.codigo + " Bebida: " + this.nome + " Descrição: " + this.descricao + " Preço: " + this.preco);
	}
	
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}

}
