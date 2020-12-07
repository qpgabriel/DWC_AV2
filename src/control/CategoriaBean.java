package control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.FabricaConexao;
import dao.CategoriaDAO;
import model.Categoria;


@ManagedBean (name = "paginaCategoria")
@ViewScoped

public class CategoriaBean {

	
	private Categoria categoria;
	private List<Categoria> listaDeCategorias;
	private ListDataModel<Categoria> categorias;
		
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getListaDeCategorias() {
		return listaDeCategorias;
	}

	public void setListaDeCategorias(List<Categoria> listaDeCategorias) {
		this.listaDeCategorias = listaDeCategorias;
	}
    
	
	public void PrepararEditar() {
		this.categoria = categorias.getRowData();
	}
	
	public ListDataModel<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(ListDataModel<Categoria> categorias) {
		this.categorias = categorias;
	}

	public void Update() {
		try {
			FabricaConexao fab= new FabricaConexao();
			java.sql.Connection conn =  fab.fazerConexao();
			
			CategoriaDAO daoCategoria = new CategoriaDAO(conn);
			
			daoCategoria.Update(this.categoria);
			
			this.listaDeCategorias =  daoCategoria.GetAll();
			
			this.categorias = new ListDataModel<Categoria>(listaDeCategorias);
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	public void Clear() {
		this.categoria = new Categoria();
	}
	
	@PostConstruct
	public void iniciar() {
		try {
			FabricaConexao fab= new FabricaConexao();
			java.sql.Connection conn =  fab.fazerConexao();
			
			CategoriaDAO daoCategoria = new CategoriaDAO(conn);
			
			this.listaDeCategorias =  daoCategoria.GetAll();
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	
}
