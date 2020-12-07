package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;

public class CategoriaDAO implements CategoriaDAOIn {

	private Connection conexao;
	
	public CategoriaDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Insert(Categoria _objeto) throws SQLException {

		String SQL = "INSERT INTO Categoria (desCategoria) VALUES (?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getDescricao());
		
		ps.execute();

	}

	@Override
	public Boolean Delete(int _id) throws SQLException {

		String SQL = "DELETE FROM Categoria WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
			
		return ps.execute();
	}

	@Override
	public Boolean Update(Categoria _objeto) throws SQLException {
		String SQL = "UPDATE Categoria SET descCategoria = ? WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getDescricao());
		ps.setInt(2, _objeto.getId());

		return ps.execute();
	}

	@Override
	public List<Categoria> GetAll() throws SQLException {
		
		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		
		String SQL = "SELECT id, descCategoria FROM Categoria";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String descricao = rs.getString(2);
			
			listaCategorias.add(new Categoria(id, descricao));
		}
		return listaCategorias;
	}

	@Override
	public Categoria GetForID(int _id) throws SQLException {
		String SQL = "SELECT descCategoria  FROM produto WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String descricao = rs.getString(2);
		
			Categoria categoria = new Categoria(id, descricao);
		
			return categoria;
		}
		return null;
	}


	@Override
	public List<Categoria> GetAllForProduto(int _id) throws SQLException {

		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		
		String SQL = "SELECT id, descCategoria FROM Categoria WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String descricao = rs.getString(2);
						
			listaCategorias.add(new Categoria(id, descricao));
		}
		
		return listaCategorias;
	}

}
