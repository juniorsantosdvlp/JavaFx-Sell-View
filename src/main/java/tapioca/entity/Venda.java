package tapioca.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venda {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(unique = true, name = "idvenda")
	private Integer id;

	@Column(name = "numero")
	private int numero;

	@Column(name = "item")
	private List<ItemVenda> produtos;

	@Column(name = "data")
	private Date data;



}