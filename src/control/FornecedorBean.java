package control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.FabricaConexao;
import dao.FornecedorDAO;
import model.Fornecedor;


@ManagedBean (name = "paginaFornecedor")
@ViewScoped

public class FornecedorBean {

	
	private Fornecedor fornecedor;
	private List<Fornecedor> listaDeFornecedors;
	private ListDataModel<Fornecedor> fornecedors;
		
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getListaDeFornecedors() {
		return listaDeFornecedors;
	}

	public void setListaDeFornecedors(List<Fornecedor> listaDeFornecedors) {
		this.listaDeFornecedors = listaDeFornecedors;
	}
	
	public ListDataModel<Fornecedor> getFornecedors() {
		return fornecedors;
	}

	public void setFornecedors(ListDataModel<Fornecedor> fornecedors) {
		this.fornecedors = fornecedors;
	}

	public void PrepararEditar() {
		this.fornecedor = fornecedors.getRowData();
	}
	
	public void Update() {
		try {
			FabricaConexao fab= new FabricaConexao();
			java.sql.Connection conn =  fab.fazerConexao();
			
			FornecedorDAO daoFornecedor = new FornecedorDAO(conn);
			
			daoFornecedor.Update(this.fornecedor);
			
			this.listaDeFornecedors =  daoFornecedor.GetAll();
			
			this.fornecedors = new ListDataModel<Fornecedor>(listaDeFornecedors);
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	public void Clear() {
		this.fornecedor = new Fornecedor();
	}
	
	@PostConstruct
	public void iniciar() {
		try {
			FabricaConexao fab= new FabricaConexao();
			java.sql.Connection conn =  fab.fazerConexao();
			
			FornecedorDAO daoFornecedor = new FornecedorDAO(conn);
			
			this.listaDeFornecedors =  daoFornecedor.GetAll();
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
	}

	
}
