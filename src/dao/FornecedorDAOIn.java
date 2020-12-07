package dao;

import java.sql.SQLException;
import java.util.List;

import model.Fornecedor;

public interface FornecedorDAOIn {

	void Insert(Fornecedor _objeto) throws SQLException;
	
	Boolean Delete(int _id) throws SQLException;
	
	Boolean Update(Fornecedor _objeto) throws SQLException;
	
	List<Fornecedor> GetAll() throws SQLException;
	
	List<Fornecedor> GetAllForProduto(int _produtoID) throws SQLException;
	
	Fornecedor GetForID(int _id) throws SQLException;
}
