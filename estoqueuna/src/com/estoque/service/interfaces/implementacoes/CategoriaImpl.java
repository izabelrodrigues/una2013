package com.estoque.service.interfaces.implementacoes;

import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.estoque.service.entity.Categoria;
import com.estoque.service.interfaces.Generic;
import com.estoque.service.util.HibernateUtil;

public class CategoriaImpl implements Generic<Categoria> {

	private Set<Categoria> categorias = new TreeSet<Categoria>();

	@Override
	public void save(Categoria obj) {

	}

	@Override
	public Categoria findById(int cod) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		return (Categoria) sessao.load(Categoria.class, cod);
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
	public Set<Categoria> listAll() {
		Session sessao = null;
		Transaction transacao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria consulta = sessao.createCriteria(Categoria.class);
			categorias = (Set<Categoria>) consulta.list();
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
	public int getCount(Set<Categoria> list) {
		return list.size();
	}

}
