package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {

	private Connection conexao;
	
	public Connection fazerConexao() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			this.conexao = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/av1_dwc",//URL BD com Schema
					"root",//User
					"admin"//Password
					);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return this.conexao;
	}
	
	public void fecharConexao() {
		
	}
	
}
