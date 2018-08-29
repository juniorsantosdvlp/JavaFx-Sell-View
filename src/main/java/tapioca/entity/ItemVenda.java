package tapioca.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ItemVenda {


	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(unique = true, name = "iditem")
	private Integer id;

	@Column
	private int quantidade;
	@Column
	private double valor;
	@Column
	private Produto produto;


}
