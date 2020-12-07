package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Estoque implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int qnt;
	private float preco;
	
	private List<Produto> produtos;
	private List<Usuario> usuarios;
	
	public Estoque() {
		this.produtos = new ArrayList<Produto>();
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public Estoque(int id, int qnt, float preco,List<Produto> produtos, List<Usuario> usuarios) {
		super();
		this.id = id;
		this.qnt = qnt;
		this.preco = preco;
		this.produtos = produtos;
		this.usuarios = usuarios;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}
	
	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estoque other = (Estoque) obj;
		if (id != other.id)
			return false;
		return true;
	}

	//@Override
	//public String toString() {
	//	return this.descricao;
	//}
}
