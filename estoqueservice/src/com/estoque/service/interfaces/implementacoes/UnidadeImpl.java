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
import com.estoque.service.entity.Unidade;
import com.estoque.service.interfaces.Generic;
import com.estoque.service.util.HibernateUtil;

public class UnidadeImpl implements Generic<Unidade> {

	private List<Unidade> unidades;

	@Override
	public String save(Unidade unidadeMedida) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(unidadeMedida);
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
	public Unidade findById(int cod) {
		Session sessao = null;
		Transaction transacao = null;
		Unidade unidadeMedida = new Unidade();

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			unidadeMedida = (Unidade) sessao.get(Unidade.class,
					new Integer(cod));
			transacao.commit();

		} catch (HibernateException e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}

		return unidadeMedida;

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
	public String update(Unidade unidade) {
		Session sessao = null;
		Transaction transacao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(unidade);
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
	public List<Unidade> listAll() {
		/*Session sessao = null;
		Transaction transacao = null;
		unidades = new ArrayList<Unidade>();
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria consulta = sessao.createCriteria(Unidade.class);
			consulta.addOrder(Order.asc("id"));
			unidades = consulta.list();
			transacao.commit();
		} catch (HibernateException e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
*/
		Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createCriteria(Unidade.class).list();
	}

	@Override
	public int getCount(List<Unidade> list) {
		// TODO Auto-generated method stub
		return 0;
	}

}
