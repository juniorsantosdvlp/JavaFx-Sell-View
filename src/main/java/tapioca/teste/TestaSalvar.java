package tapioca.teste;

import tapioca.dao.ProdutoDAO;
import tapioca.entity.Produto;

public class TestaSalvar {

	public static void main(String[] args) {

		Produto p = new Produto("30","arroz", 10.1);
		ProdutoDAO pd = new ProdutoDAO();
		pd.addProduto(p);


	}

}
