package br.com.restaurante.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public double calculaTotal() {
		double[] total = {0};

		this.pratos.forEach(prato -> {
			total[0] += prato.getPreco();
		});

		this.bebidas.forEach(bebida -> {
			total[0] += bebida.getPreco();
		});

		return total[0];
	}

	public void fazerPedido() throws SQLException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = new Conexao().retornarConexao();

			double total = this.calculaTotal();

			preparedStatement = conn.prepareStatement("INSERT INTO PEDIDO  (ID_PEDIDO, ID_CLIENTE, DATA_PEDIDO, STATUS, TOTAL, ENDERECO_ENTREGA, ID_FUNCIONARIO) VALUES (?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, 14);
			preparedStatement.setInt(2, 1);
			preparedStatement.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
			preparedStatement.setString(4, "FINALIZADO");
			preparedStatement.setDouble(5, total);
			preparedStatement.setString(6, this.endereco);
			preparedStatement.setInt(7, 1);

			preparedStatement.executeUpdate();



			for (Prato prato : this.pratos) {
				preparedStatement = conn.prepareStatement("INSERT INTO ITENS_PEDIDO (ID_ITEM, ID_PEDIDO, ID_PRODUTO, QUANTIDADE, PRECO_UNITARIO) VALUES (?, ?, ?, ?, ?)");

				preparedStatement.setInt(1, 99);
				preparedStatement.setInt(2, 14);
				preparedStatement.setInt(3, prato.getCodigo());
				preparedStatement.setInt(4, 5);
				preparedStatement.setDouble(5, prato.getPreco());
			}

			preparedStatement.executeUpdate();


			for (Bebida bebida : this.bebidas) {
				preparedStatement = conn.prepareStatement("INSERT INTO ITENS_PEDIDO (ID_ITEM, ID_PEDIDO, ID_PRODUTO, QUANTIDADE, PRECO_UNITARIO) VALUES (?, ?, ?, ?, ?)");

				preparedStatement.setInt(1, 100);
				preparedStatement.setInt(2, 14);
				preparedStatement.setInt(3, bebida.getCodigo());
				preparedStatement.setInt(4, 5);
				preparedStatement.setDouble(5, bebida.getPreco());
			}

			preparedStatement.executeUpdate();


		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			preparedStatement.close();
			conn.close();
		}
	}


	public void verificarStatus(Integer idPedido) throws SQLException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = new Conexao().retornarConexao();
			preparedStatement = conn.prepareStatement("SELECT status FROM PEDIDO WHERE ID_PEDIDO = ?");
			preparedStatement.setInt(1, idPedido);

			ResultSet resultSet = preparedStatement.executeQuery();

			String status = null;

			while (resultSet.next()) {
				status = resultSet.getString("status");
			}

			System.out.println("Status do pedido: " + status);


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
