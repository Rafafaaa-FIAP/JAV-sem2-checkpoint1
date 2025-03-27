package br.com.restaurante.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Pedido {

	private String endereco;
	private List<Prato> pratos;
	private List<Bebida> bebidas;


	
	public Pedido(String endereco, List<Prato> pratos, List<Bebida> bebidas) {
		this.endereco = endereco;
		this.pratos = pratos;
		this.bebidas = bebidas;
	}
	
	public void fazerPedido() throws SQLException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		try {
			conn = new Conexao().retornarConexao();
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			preparedStatement.close();
			conn.close();
		}
	}
	
	
	
	public String Endereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public List<Prato> getPratos() {
		return pratos;
	}
	public void setPratos(List<Prato> pratos) {
		this.pratos = pratos;
	}
	public List<Bebida> getBebidas() {
		return bebidas;
	}
	public void setBebidas(List<Bebida> bebidas) {
		this.bebidas = bebidas;
	}
	
}
