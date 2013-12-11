package com.estoque.service.interfaces.implementacoes;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;

import com.estoque.service.Constants;
import com.estoque.service.entity.TipoMovimento;
import com.estoque.service.interfaces.Generic;
import com.estoque.service.util.HibernateUtil;

public class TipoMovimentoImpl implements Generic<TipoMovimento>{

	private List<TipoMovimento> movimentacaoi;

	@Override 
	public String save(TipoMovimento tmov) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(tmov);
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
	public TipoMovimento findById(int tmov) {
		Session sessao = null;
		Transaction transacao = null;
		TipoMovimento tmovimento = new TipoMovimento();

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			tmovimento = (TipoMovimento) sessao.get(TipoMovimento.class,
					new Integer(tmov));
			transacao.commit();

		} catch (HibernateException e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}

		return tmovimento;

	}

	@Override
	public String delete(int tmov) {
		Session sessao = null;
		Transaction transacao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(findById(tmov));
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
	public String update(TipoMovimento tmov) {
		Session sessao = null;
		Transaction transacao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(tmov);
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
	public List<TipoMovimento> listAll() {
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
        return session.createCriteria(TipoMovimento.class).list();
	}

	@Override
	public int getCount(List<TipoMovimento> list) {
		return list.size();
	}
	
	
}
