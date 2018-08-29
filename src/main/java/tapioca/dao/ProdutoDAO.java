package tapioca.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import tapioca.entity.HibernateUtil;
import tapioca.entity.Produto;

public class ProdutoDAO {

	public void addProduto(Produto produto) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.save(produto);
		s.getTransaction().commit();
		s.close();

	}

	public void removeProduto(Produto produto) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.remove(produto);
		s.getTransaction().commit();
		s.close();

	}

	public List<Produto> listProduto() {
		List<Produto> list = new ArrayList<Produto>();
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		list = s.createQuery("select p from Produto p ", Produto.class).getResultList();
		s.getTransaction().commit();
		s.close();
		return list;
	}

}
