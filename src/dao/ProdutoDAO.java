package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;
import model.Fornecedor;
import model.Produto;

public class ProdutoDAO implements ProdutoDaoIn {

	private Connection conexao;
	
	public ProdutoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Insert(Produto _objeto) throws SQLException {
		
		String SQL = "INSERT INTO produto (nome, preco, descricao) VALUES (?,?,?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNomeProduto());
		ps.setFloat(2, _objeto.getPrecoProduto());
		ps.setString(3, _objeto.getDescricaoProduto());
		
		ps.execute();

	}

	@Override
	public Boolean Delete(int _id) throws SQLException {
		
		String SQL = "DELETE FROM produto WHERE idProduto = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
			
		return ps.execute();
	}

	@Override
	public Boolean Update(Produto _objeto) throws SQLException {
		
		String SQL = "UPDATE produto SET nome = ?, preco = ?, descricao= ? WHERE idProduto = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNomeProduto());
		ps.setFloat(2, _objeto.getPrecoProduto());
		ps.setString(3, _objeto.getDescricaoProduto());
		ps.setInt(4, _objeto.getIdProduto());

		return ps.execute();
	}

	@Override
	public List<Produto> GetAll() throws SQLException {
		
		List<Produto> listaProdutos = new ArrayList<Produto>();
		
		String SQL = "SELECT id, nome, preco, descricao FROM produto";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			Float preco = rs.getFloat(3);
			String descricao = rs.getString(4);
					
			CategoriaDAO daoCategoria = new CategoriaDAO(conexao);
			
			List<Categoria> listaCategoriasDoProduto = daoCategoria.GetAllForProduto(id);
			
			FornecedorDAO daoFornecedor = new FornecedorDAO(conexao);
			
			List<Fornecedor> listaFornecedorsDoProduto = daoFornecedor.GetAllForProduto(id);
			
			listaProdutos.add(new Produto(id, nome, preco, descricao, listaCategoriasDoProduto, listaFornecedorsDoProduto));
		}
		
		return listaProdutos;
	}

	public List<Produto> GetAllForEstoque(int _id) throws SQLException {
		
		List<Produto> listaProdutos = new ArrayList<Produto>();
		
		String SQL = "SELECT id, nome, preco, descricao FROM produto WHERE idProduto = ?\"";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			Float preco = rs.getFloat(3);
			String descricao = rs.getString(4);
					
			CategoriaDAO daoCategoria = new CategoriaDAO(conexao);
			
			List<Categoria> listaCategoriasDoProduto = daoCategoria.GetAllForProduto(id);
			
			FornecedorDAO daoFornecedor = new FornecedorDAO(conexao);
			
			List<Fornecedor> listaFornecedorsDoProduto = daoFornecedor.GetAllForProduto(id);
			
			listaProdutos.add(new Produto(id, nome, preco, descricao, listaCategoriasDoProduto, listaFornecedorsDoProduto));
		}
		
		return listaProdutos;
	}
	
	@Override
	public Produto GetForID(int _id) throws SQLException {
		
		String SQL = "SELECT id, nome, preco, descricao FROM produto WHERE idProduto = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			Float preco = rs.getFloat(3);
			String descricao = rs.getString(4);
			
			CategoriaDAO daoCategoria = new CategoriaDAO(conexao);
			
			List<Categoria> listaCategoriasDoProduto = daoCategoria.GetAllForProduto(id);
			
			FornecedorDAO daoFornecedor = new FornecedorDAO(conexao);
			
			List<Fornecedor> listaFornecedorsDoProduto = daoFornecedor.GetAllForProduto(id);
			
			Produto produto = new Produto(id, nome, preco, descricao, listaCategoriasDoProduto, listaFornecedorsDoProduto);
			
			return produto;
		}
		
		return null;
	}

}
