package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private float preco;
	private String descricao;
	
	private List<Categoria> categorias;
	private List<Fornecedor> fornecedors;
	
	public Produto() {
		this.categorias = new ArrayList<Categoria>();
		this.fornecedors = new ArrayList<Fornecedor>();
	}

	public Produto(int id, String nome, float preco, String descricao, List<Categoria> _idCategorias, List<Fornecedor> _idFornecedors) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.categorias = _idCategorias;
		this.fornecedors = _idFornecedors;
	}
	
	public int getIdProduto() {
		return id;
	}

	public void setIdProduto(int id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nome;
	}

	public void setNomeProduto(String nome) {
		this.nome = nome;
	}

	public float getPrecoProduto() {
		return preco;
	}

	public void setPrecoProduto(float preco) {
		this.preco = preco;
	}

	public String getDescricaoProduto() {
		return descricao;
	}

	public void setDescricaoProduto(String descricao) {
		this.descricao = descricao;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public List<Fornecedor> getfornecedors() {
		return fornecedors;
	}

	public void setfornecedors(List<Fornecedor> fornecedors) {
		this.fornecedors = fornecedors;
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
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa (id:" + id + ", nome:" + nome + ", preco:" + preco + ", descricao:" + descricao + ", idCategoria:\" + idCategoria + \", idFornecedor:\" + idFornecedor + \")";
	}	
}
