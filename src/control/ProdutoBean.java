package control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

//import com.mysql.jdbc.Connection;

import dao.FabricaConexao;
import dao.ProdutoDAO;
import model.Produto;

@ManagedBean (name = "paginaProduto")
@ViewScoped
public class ProdutoBean {
	
	private Produto produto;
	private List<Produto> listaDeProdutos;
	private ListDataModel<Produto> produtos;
	
		
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getListaDeProdutos() {
		return listaDeProdutos;
	}

	public void setListaDeProdutos(List<Produto> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
	}
	
	public ListDataModel<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ListDataModel<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void PrepararEditar() {
		this.produto = produtos.getRowData();
	}
	
	public void Update() {
		try {
			FabricaConexao fab= new FabricaConexao();
			java.sql.Connection conn =  fab.fazerConexao();
			
			ProdutoDAO daoProduto = new ProdutoDAO(conn);
			
			daoProduto.Update(this.produto);
			
			this.listaDeProdutos =  daoProduto.GetAll();
			
			this.produtos = new ListDataModel<Produto>(listaDeProdutos);
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	public void Clear() {
		this.produto = new Produto();
	}

	@PostConstruct
	public void iniciar() {
		try {
			FabricaConexao fab= new FabricaConexao();
			java.sql.Connection conn =  fab.fazerConexao();
			
			ProdutoDAO daoProduto = new ProdutoDAO(conn);
			
			this.setProdutos(new ListDataModel<Produto>(listaDeProdutos));
			
			this.listaDeProdutos =  daoProduto.GetAll();
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
	}



	
}
