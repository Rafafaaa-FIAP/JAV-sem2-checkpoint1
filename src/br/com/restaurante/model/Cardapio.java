package br.com.restaurante.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Cardapio {
	
	private Map<Integer, Prato> pratos;
	private Map<Integer, Bebida> bebidas;


	public Cardapio() throws SQLException {
		this.pratos = carregarPratos();
		this.bebidas = carregarBebidas();
	}
	
	private Map<Integer, Prato> carregarPratos() throws SQLException {
		Map<Integer, Prato> pratos = new HashMap<>();
		
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		try {
			conn = new Conexao().retornarConexao();
			
			preparedStatement = conn.prepareStatement("SELECT * FROM PRATO");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int codigo = resultSet.getInt("COD_PRATO");
				String nome = resultSet.getString("NOME");
				String descricao = resultSet.getString("DESCRICAO");
				float preco = resultSet.getFloat("VALOR");

				Prato prato = new Prato(codigo, nome, descricao, preco);
				pratos.put(prato.getCodigo(), prato);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			preparedStatement.close();
			conn.close();
		}
		
		return pratos;
	}
	
	private Map<Integer, Bebida> carregarBebidas() throws SQLException {
		Map<Integer, Bebida> bebidas = new HashMap<>();
		
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		try {
			conn = new Conexao().retornarConexao();
			
			preparedStatement = conn.prepareStatement("SELECT * FROM BEBIDA");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int codigo = resultSet.getInt("COD_BEBIDA");
				String nome = resultSet.getString("NOME");
				String descricao = resultSet.getString("DESCRICAO");
				float preco = resultSet.getFloat("VALOR");

				Bebida bebida = new Bebida(codigo, nome, descricao, preco);
				bebidas.put(bebida.getCodigo(), bebida);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			preparedStatement.close();
			conn.close();
		}
		
		return bebidas;
	}

	public void listarPratosBebidas() {
		System.out.println("###### CARDÁPIO ######");
		
		System.out.println("### PRATOS ###");
		for (Prato prato : this.pratos.values()) {
			prato.exibirPrato();
		}
		
		System.out.println("### BEBIDAS ###");
		for (Bebida bebida : this.bebidas.values()) {
			bebida.exibirBebida();
		}
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
