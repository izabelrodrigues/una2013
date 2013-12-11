package com.estoque.service.interfaces.implementacoes;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;

import com.estoque.service.Constants;
import com.estoque.service.entity.MovimentoItem;
import com.estoque.service.interfaces.Generic;
import com.estoque.service.util.HibernateUtil;

public class MovimentoItemImpl implements Generic<MovimentoItem>{

	private List<MovimentoItem> movimentacaoi;

	@Override 
	public String save(MovimentoItem movi) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(movi);
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
	public MovimentoItem findById(int movi) {
		Session sessao = null;
		Transaction transacao = null;
		MovimentoItem movimento = new MovimentoItem();

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			movimento = (MovimentoItem) sessao.get(MovimentoItem.class,
					new Integer(movi));
			transacao.commit();

		} catch (HibernateException e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}

		return movimento;

	}

	@Override
	public String delete(int movi) {
		Session sessao = null;
		Transaction transacao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(findById(movi));
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
	public String update(MovimentoItem movi) {
		Session sessao = null;
		Transaction transacao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(movi);
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
	public List<MovimentoItem> listAll() {
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
        return session.createCriteria(MovimentoItem.class).list();
	}

	@Override
	public int getCount(List<MovimentoItem> list) {
		return list.size();
	}
	
	
}
