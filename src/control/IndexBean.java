package control;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean (name = "indexBean")
@ViewScoped
public class IndexBean {

	
	public IndexBean() {
		this.nome = "Thiago";
		
		this.texto = "testetdashdlkahsldkh\nldkjhsaklfhldsahflkhl";
	}
	
	private String nome;
	private String texto;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	
	
}
