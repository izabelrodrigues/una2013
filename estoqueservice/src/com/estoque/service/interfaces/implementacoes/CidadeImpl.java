package com.estoque.service.interfaces.implementacoes;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;

import com.estoque.service.Constants;
import com.estoque.service.entity.Cidade;
import com.estoque.service.interfaces.Generic;
import com.estoque.service.util.HibernateUtil;

public class CidadeImpl  implements Generic<Cidade> {

	private List<Cidade> cidades;

	@Override 
	public String save(Cidade cid) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(cid);
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
	public Cidade findById(int cid) {
		Session sessao = null;
		Transaction transacao = null;
		Cidade cidade = new Cidade();

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			cidade = (Cidade) sessao.get(Cidade.class,
					new Integer(cid));
			transacao.commit();

		} catch (HibernateException e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}

		return cidade;

	}

	@Override
	public String delete(int cid) {
		Session sessao = null;
		Transaction transacao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(findById(cid));
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
	public String update(Cidade cid) {
		Session sessao = null;
		Transaction transacao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(cid);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> listAll() {
		/*Session sessao = null;
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

		return categorias;*/
		Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createCriteria(Cidade.class).list();
	}

	@Override
	public int getCount(List<Cidade> list) {
		return list.size();
	}
	
}
