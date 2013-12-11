package com.estoque.service.interfaces.implementacoes;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;

import com.estoque.service.Constants;
import com.estoque.service.entity.Categoria;
import com.estoque.service.entity.Produto;
import com.estoque.service.interfaces.Generic;
import com.estoque.service.util.HibernateUtil;

public class ProdutoImpl implements Generic<Produto> {
	
	private List<Produto> produtos;

	@Override
	public String save(Produto prod) {
		Session sessao = null;
		Transaction transacao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(prod);
			transacao.commit();

		} catch (HibernateException e) {
			if (transacao != null) {
				transacao.rollback();
			}
			return Constants.ERROR;
		} finally {
			sessao.close();
		}

		return Constants.SUCCESS;
	}

	@Override
	public Produto findById(int cod) {
		Session sessao = null;
		Transaction transacao = null;
		Produto produto = new Produto();

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			produto = (Produto) sessao.get(Produto.class,
					new Integer(cod));
			transacao.commit();

		} catch (HibernateException e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}

		return produto;
	}

	@Override
	public String delete(int cod) {
		Session sessao = null;
		Transaction transacao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(findById(cod));
			transacao.commit();
		} catch (HibernateException e) {
			if (transacao != null) {
				transacao.rollback();
			}
			return Constants.ERROR;
		} finally {
			sessao.close();
		}

		return Constants.SUCCESS;
	}

	@Override
	public String update(Produto prod) {
		Session sessao = null;
		Transaction transacao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(prod);
			transacao.commit();
		} catch (HibernateException e) {
			if (transacao != null) {
				transacao.rollback();
			}

			return Constants.ERROR;
		} finally {
			sessao.close();
		}

		return Constants.SUCCESS;
	}

	@Override
	public List<Produto> listAll() {
		/*Session sessao = null;
		Transaction transacao = null;
		produtos = new ArrayList<Produto>();
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria consulta = sessao.createCriteria(Produto.class);
			consulta.addOrder(Order.asc("id"));
			produtos = consulta.list();
			transacao.commit();
		} catch (HibernateException e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}

		return produtos;*/
		Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createCriteria(Produto.class).list();
	}

	@Override
	public int getCount(List<Produto> list) {
		return list.size();
	}

}
