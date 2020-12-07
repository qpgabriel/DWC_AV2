package dao;

import java.sql.SQLException;
import java.util.List;

import model.Usuario;

public interface UsuarioDaoIn {

	void Insert(Usuario _objeto) throws SQLException;
		
	Boolean Delete(int _id) throws SQLException;
	
	Boolean Update(Usuario _objeto) throws SQLException;
	
	List<Usuario> GetAll() throws SQLException;
	
	List<Usuario> GetAllForEstoque(int _id) throws SQLException;
	
	Usuario GetForID(int _id) throws SQLException;
}
