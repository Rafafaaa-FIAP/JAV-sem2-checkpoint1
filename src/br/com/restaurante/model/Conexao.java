package br.com.restaurante.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public Connection retornarConexao() throws SQLException {
		String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
		String user = "";
		String password = "";

		return DriverManager.getConnection(url, user, password);
	}
	
}
