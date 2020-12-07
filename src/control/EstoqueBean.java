package control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.FabricaConexao;
import dao.EstoqueDAO;
import model.Estoque;


@ManagedBean (name = "paginaEstoque")
@ViewScoped
public class EstoqueBean {

	
	private Estoque estoque;
	private List<Estoque> listaDeEstoques;
	private ListDataModel<Estoque> estoques;
		
	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public List<Estoque> getListaDeEstoques() {
		return listaDeEstoques;
	}

	public void setListaDeEstoques(List<Estoque> listaDeEstoques) {
		this.listaDeEstoques = listaDeEstoques;
	}

	public void PrepararEditar() {
		this.estoque = estoques.getRowData();
	}
	
	public ListDataModel<Estoque> getEstoques() {
		return estoques;
	}

	public void setEstoques(ListDataModel<Estoque> estoques) {
		this.estoques = estoques;
	}

	public void Update() {
		try {
			FabricaConexao fab= new FabricaConexao();
			java.sql.Connection conn =  fab.fazerConexao();
			
			EstoqueDAO daoEstoque = new EstoqueDAO(conn);
			
			daoEstoque.Update(this.estoque);
			
			this.listaDeEstoques =  daoEstoque.GetAll();
			
			this.estoques = new ListDataModel<Estoque>(listaDeEstoques);
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	public void Clear() {
		this.estoque = new Estoque();
	}
	
	@PostConstruct
	public void iniciar() {
		try {
			FabricaConexao fab= new FabricaConexao();
			java.sql.Connection conn =  fab.fazerConexao();
			
			EstoqueDAO daoEstoque = new EstoqueDAO(conn);
			
			this.listaDeEstoques =  daoEstoque.GetAll();
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
	}
	

}
