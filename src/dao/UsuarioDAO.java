package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDAO implements UsuarioDaoIn {

	private Connection conexao;
	
	public UsuarioDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Insert(Usuario _objeto) throws SQLException {
		
		String SQL = "INSERT INTO Usuario (nomeUsuario) VALUES (?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		
		ps.execute();

	}

	@Override
	public Boolean Delete(int _id) throws SQLException {
		
		String SQL = "DELETE FROM usuario WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
			
		return ps.execute();
	}

	@Override
	public Boolean Update(Usuario _objeto) throws SQLException {
		
		String SQL = "UPDATE usuario SET nomeUsuario = ? WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setInt(3, _objeto.getId());
		
		return ps.execute();
	}

	@Override
	public List<Usuario> GetAll() throws SQLException {
		
		List<Usuario> listaPessoas = new ArrayList<Usuario>();
		
		String SQL = "SELECT id, nomeUsuario FROM usuario";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);

			listaPessoas.add(new Usuario(id, nome));
		}
		
		return listaPessoas;
	}

	@Override
	public List<Usuario> GetAllForEstoque(int _id) throws SQLException {
		
		List<Usuario> listaPessoas = new ArrayList<Usuario>();
		
		String SQL = "SELECT id, nomeUsuario FROM usuario where id=?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);

			listaPessoas.add(new Usuario(id, nome));
		}
		
		return listaPessoas;
	}
	
	@Override
	public Usuario GetForID(int _id) throws SQLException {
		
		String SQL = "SELECT id, nomeUsuario FROM usuario WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			
			Usuario usuario = new Usuario(id, nome);
			
			return usuario;
		}
		
		return null;
	}

}
