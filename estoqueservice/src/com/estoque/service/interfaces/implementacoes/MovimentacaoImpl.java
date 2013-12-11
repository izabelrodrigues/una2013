package com.estoque.service.interfaces.implementacoes;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.estoque.service.Constants;
import com.estoque.service.entity.Movimentacao;
import com.estoque.service.interfaces.Generic;
import com.estoque.service.util.HibernateUtil;


public class MovimentacaoImpl implements Generic<Movimentacao>{

	private List<Movimentacao> movimentacao;

	@Override 
	public String save(Movimentacao mov) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(mov);
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
	public Movimentacao findById(int mov) {
		Session sessao = null;
		Transaction transacao = null;
		Movimentacao movimento = new Movimentacao();

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			movimento = (Movimentacao) sessao.get(Movimentacao.class,
					new Integer(mov));
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
	public String delete(int mov) {
		Session sessao = null;
		Transaction transacao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(findById(mov));
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
	public String update(Movimentacao mov) {
		Session sessao = null;
		Transaction transacao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(mov);
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
	public List<Movimentacao> listAll() {
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
        return session.createCriteria(Movimentacao.class).list();
	}

	@Override
	public int getCount(List<Movimentacao> list) {
		return list.size();
	}
	
}
