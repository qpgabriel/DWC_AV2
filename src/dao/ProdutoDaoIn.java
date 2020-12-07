package dao;

import java.sql.SQLException;
import java.util.List;

import model.Produto;

public interface ProdutoDaoIn {

	void Insert(Produto _objeto) throws SQLException;
		
	Boolean Delete(int _id) throws SQLException;
	
	Boolean Update(Produto _objeto) throws SQLException;
	
	List<Produto> GetAll() throws SQLException;
	
	List<Produto> GetAllForEstoque(int _id) throws SQLException;
	
	Produto GetForID(int _id) throws SQLException;
}
