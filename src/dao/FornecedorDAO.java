package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Fornecedor;

public class FornecedorDAO implements FornecedorDAOIn {

	private Connection conexao;
	
	public FornecedorDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Insert(Fornecedor _objeto) throws SQLException {

		String SQL = "INSERT INTO Fornecedor (nomeFornecedor, infoFornecedor) VALUES (?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getDescricao());
		
		ps.execute();

	}

	@Override
	public Boolean Delete(int _id) throws SQLException {

		String SQL = "DELETE FROM Fornecedor WHERE idFornecedor = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
			
		return ps.execute();
	}

	@Override
	public Boolean Update(Fornecedor _objeto) throws SQLException {
		String SQL = "UPDATE Fornecedor SET nomeFornecedor = ?, infoFornecedor  WHERE idFornecedor = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getDescricao());
		ps.setInt(3, _objeto.getId());

		return ps.execute();
	}

	@Override
	public List<Fornecedor> GetAll() throws SQLException {
		List<Fornecedor> listaFornecedors = new ArrayList<Fornecedor>();
		
		String SQL = "SELECT idFornecedor, nomeFornecedor, infoFornecedor FROM Categoria";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String descricao = rs.getString(3);
			
			listaFornecedors.add(new Fornecedor(id, nome, descricao));
		}
		return listaFornecedors;
	}

	@Override
	public Fornecedor GetForID(int _id) throws SQLException {
		String SQL = "SELECT idFornecedor, nomeFornecedor, infoFornecedor FROM Fornecedor WHERE idFornecedor = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String descricao = rs.getString(3);
		
			Fornecedor fornecedor = new Fornecedor(id, nome, descricao);
		
			return fornecedor;
		}
		return null;
	}

	@Override
	public List<Fornecedor> GetAllForProduto(int _id) throws SQLException {

		List<Fornecedor> listaFornecedors = new ArrayList<Fornecedor>();
		
		String SQL = "SELECT idFornecedor, nomeFornecedor, infoFornecedor FROM Fornecedor WHERE idFornecedor = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String descricao = rs.getString(3);
						
			listaFornecedors.add(new Fornecedor(id, nome, descricao));
		}
		
		
		return listaFornecedors;
	}

}
