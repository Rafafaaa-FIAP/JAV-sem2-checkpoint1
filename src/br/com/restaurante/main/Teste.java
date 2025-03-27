package br.com.restaurante.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Teste {

	public static void main(String[] args) throws SQLException {
		System.out.println("teste");
		
		String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
		String user = "RM553521";
		String password = "031002";

		System.out.println(url);
		System.out.println(user);
		System.out.println(password);
		
		String select = "SELECT * FROM PRATO";
		
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			preparedStatement = conn.prepareStatement(select);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				//int codigo = resultSet.getInt("COD_PRATO");
				String nome = resultSet.getString("NOME");
				//String descricao = resultSet.getString("DESCRICAO");
				//float preco = resultSet.getFloat("VALOR");
				
				System.out.println(" nome = " + nome);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			preparedStatement.close();
			conn.close();
		}
		
	}

}
