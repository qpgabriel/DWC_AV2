package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Estoque;

public class EstoqueDAO implements EstoqueDAOIn {

	private Connection conexao;
	
	public EstoqueDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Insert(Estoque _objeto) throws SQLException {

		String SQL = "INSERT INTO Estoque (qnt, preco, Produto_id, Usuario_id) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getQnt());
		ps.setFloat(2, _objeto.getPreco());
		ps.setInt(3, _objeto.progetProduto_id());
		ps.setInt(4, _objeto.getUsuario_id());
		ps.execute();

	}
	
	//public void InsertIdEstoque(Estoque _objeto) throws SQLException {

		String SQL = "INSERT INTO Estoque (qnt, preco, Produto_id, Usuario_id) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getQnt());
		ps.setFloat(2, _objeto.getPreco());
		ps.setInt(3, _objeto.estoque.getProduto_id());
		ps.setInt(4, _objeto.getUsuario_id());
		ps.execute();

	}
	
	//inser

	@Override
	public Boolean Delete(int _id) throws SQLException {

		String SQL = "DELETE FROM Estoque WHERE idEstoque = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
			
		return ps.execute();
	}

	@Override
	public Boolean Update(Estoque _objeto) throws SQLException {
		String SQL = "UPDATE Categoria SET qnd = ?, preco = ?, descCategoria = ?, Produto_id = ?, Usuario_id = ?  WHERE idEstoque = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getQnt());
		ps.setFloat(2, _objeto.getPreco());
		ps.setInt(3, _objeto.getProduto_id());
		ps.setInt(4, _objeto.getUsuario_id());

		return ps.execute();
	}

	@Override
	public List<Estoque> GetAll() throws SQLException {
		
		List<Estoque> listaEstoques = new ArrayList<Estoque>();
		
		String SQL = "SELECT idEstoque, qnt, preco, descCategoria, Produto_id, Usuario_id FROM Categoria";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			int qnt = rs.getInt(2);
			Float preco = rs.getFloat(3);
			int produto_id = rs.getInt(2);
			int usuario_id = rs.getInt(2);
			
			listaEstoques.add(new Estoque(id, qnt, preco, produto_id, usuario_id));
		}
		return listaEstoques;
	}

	@Override
	public Estoque GetForID(int _id) throws SQLException {
		String SQL = "SELECT Categoria SET qnd = ?, preco = ?, descCategoria = ?, Produto_id = ?, Usuario_id = ?  WHERE idEstoque = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			int qnt = rs.getInt(2);
			Float preco = rs.getFloat(3);
			int produto_id = rs.getInt(2);
			int usuario_id = rs.getInt(2);
			

			Estoque estoque = new Estoque(id, qnt, preco, produto_id, usuario_id);

		return estoque;
		}
		return null;
	}

}
