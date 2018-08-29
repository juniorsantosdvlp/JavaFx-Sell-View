package tapioca.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Produto {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(unique = true, name = "idproduto")
	private Integer id;
	@Column
	private String codigo;

	@Column
	private String nome;
	@Column
	private Double valor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Produto(String codigo, String nome, double valor) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
	}

	public Produto() {
		super();
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", valor=" + valor + "]";
	}

}