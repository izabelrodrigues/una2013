package com.estoque.service.interfaces.implementacoes;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;

import com.estoque.service.entity.Categoria;
import com.estoque.service.interfaces.Generic;
import com.estoque.service.util.HibernateUtil;

public class CategoriaImpl implements Generic<Categoria> {

	private List<Categoria> categorias;

	@Override
	public void save(Categoria cat) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(cat);
			transacao.commit();
		} catch (HibernateException e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}

	}

	@Override
	public Categoria findById(int cod) {
		Session sessao = null;
		Transaction transacao = null;
		Categoria categoria = new Categoria();

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			categoria = (Categoria) sessao.get(Categoria.class,
					new Integer(cod));
			transacao.commit();

		} catch (HibernateException e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}

		return categoria;

	}

	@Override
	public void delete(int cod) {
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
		} finally {
			sessao.close();
		}

	}

	@Override
	public void update(Categoria cat) {
		Session sessao = null;
		Transaction transacao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(cat);
			transacao.commit();
		} catch (HibernateException e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> listAll() {
		Session sessao = null;
		Transaction transacao = null;
		categorias = new ArrayList<Categoria>();
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria consulta = sessao.createCriteria(Categoria.class);
			consulta.addOrder(Order.asc("id"));
			categorias = consulta.list();
			transacao.commit();
		} catch (HibernateException e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}

		return categorias;
	}

	@Override
	public int getCount(List<Categoria> list) {
		return list.size();
	}

}
