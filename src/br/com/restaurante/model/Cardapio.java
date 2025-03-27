package br.com.restaurante.model;

import java.util.HashMap;
import java.util.Map;

public class Cardapio {
	
	private Map<Integer, Prato> pratos;
	private Map<Integer, Bebida> bebidas;


	public Cardapio() {
		this.pratos = carregarPratos();
		this.bebidas = carregarBebidas();
	}
	
	private Map<Integer, Prato> carregarPratos() {
		Map<Integer, Prato> pratos = new HashMap<>();
		
		Prato prato1 = new Prato(1, "Baião de Dois", "Arroz, feijão fradinho, linguiça calabresa", 50.f);
		pratos.put(prato1.getCodigo(), prato1);
		
		Prato prato2 = new Prato(2, "Da casa", "Carne moída com batata", 40.f);
		pratos.put(prato2.getCodigo(), prato2);
		
		Prato prato3 = new Prato(3, "Parmegiana de Carne", "Filé Mignon, arroz, fritas", 40.f);
		pratos.put(prato3.getCodigo(), prato3);
		
		return pratos;
	}
	
	private Map<Integer, Bebida> carregarBebidas() {
		Map<Integer, Bebida> bebidas = new HashMap<>();
		
		Bebida bebida1 = new Bebida(1, "Refrigerante", "Coca-Cola, Fanta, Guaraná", 8f);
		bebidas.put(bebida1.getCodigo(), bebida1);
		
		Bebida bebida2 = new Bebida(2, "Cerveja", "Corona, Skol, Original", 12f);
		bebidas.put(bebida2.getCodigo(), bebida2);
		
		Bebida bebida3 = new Bebida(3, "Suco", "Laranja, Limão, Melancia, Melão", 12f);
		bebidas.put(bebida3.getCodigo(), bebida3);
		
		return bebidas;
	}
	
	
	public Map<Integer, Prato> getPratos() {
		return pratos;
	}
	public void setPratos(Map<Integer, Prato> pratos) {
		this.pratos = pratos;
	}
	public Map<Integer, Bebida> getBebidas() {
		return bebidas;
	}
	public void setBebidas(Map<Integer, Bebida> bebidas) {
		this.bebidas = bebidas;
	}
}
