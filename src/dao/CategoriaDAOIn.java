package dao;

import java.sql.SQLException;
import java.util.List;

import model.Categoria;

public interface CategoriaDAOIn {

	void Insert(Categoria _objeto) throws SQLException;
	
	Boolean Delete(int _id) throws SQLException;
	
	Boolean Update(Categoria _objeto) throws SQLException;
	
	List<Categoria> GetAll() throws SQLException;
	
	List<Categoria> GetAllForProduto(int _produtoID) throws SQLException;
	
	Categoria GetForID(int _id) throws SQLException;
}
