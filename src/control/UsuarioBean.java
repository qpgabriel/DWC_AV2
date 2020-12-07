package control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.FabricaConexao;
import dao.UsuarioDAO;
import model.Usuario;


@ManagedBean (name = "paginaUsuario")
@ViewScoped

public class UsuarioBean {

	
	private Usuario usuario;
	private List<Usuario> listaDeUsuarios;
	private ListDataModel<Usuario> usuarios;
		
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaDeUsuarios() {
		return listaDeUsuarios;
	}

	public void setListaDeUsuarios(List<Usuario> listaDeUsuarios) {
		this.listaDeUsuarios = listaDeUsuarios;
	}
    
	
	public void PrepararEditar() {
		this.usuario = usuarios.getRowData();
	}
	
	public ListDataModel<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ListDataModel<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void Update() {
		try {
			FabricaConexao fab= new FabricaConexao();
			java.sql.Connection conn =  fab.fazerConexao();
			
			UsuarioDAO daoUsuario = new UsuarioDAO(conn);
			
			daoUsuario.Update(this.usuario);
			
			this.listaDeUsuarios =  daoUsuario.GetAll();
			
			this.usuarios = new ListDataModel<Usuario>(listaDeUsuarios);
			
			JSFMessage.adicionarMensagemDeSucesso("Usuario atualizada com sucesso!");
			
	
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	public void Clear() {
		this.usuario = new Usuario();
	}
	
	@PostConstruct
	public void iniciar() {
		try {
			FabricaConexao fab= new FabricaConexao();
			java.sql.Connection conn =  fab.fazerConexao();
			
			UsuarioDAO daoUsuario = new UsuarioDAO(conn);
			
			this.listaDeUsuarios =  daoUsuario.GetAll();
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	
}
