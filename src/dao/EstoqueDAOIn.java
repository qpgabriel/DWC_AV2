package dao;

import java.sql.SQLException;
import java.util.List;

import model.Estoque;

public interface EstoqueDAOIn {

	void Insert(Estoque _objeto) throws SQLException;
	
	Boolean Delete(int _id) throws SQLException;
	
	Boolean Update(Estoque _objeto) throws SQLException;
	
	List<Estoque> GetAll() throws SQLException;
	
	Estoque GetForID(int _id) throws SQLException;
}
