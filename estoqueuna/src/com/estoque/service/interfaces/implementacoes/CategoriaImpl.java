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
import com.estoque.service.interfaces.Generic;
import com.estoque.service.util.HibernateUtil;

public class CategoriaImpl implements Generic<Categoria> {

	private List<Categoria> categorias;

	@Override 
	public String save(Categoria cat) {
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
			return Constants.ERROR;
		} finally {
			sessao.close();
		}

		return Constants.SUCCESS;

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
	public String update(Categoria cat) {
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

			return Constants.ERROR;
		} finally {
			sessao.close();
		}

		return Constants.SUCCESS;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> listAll() {
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
        return session.createCriteria(Categoria.class).list();
	}
	
	public List<Categoria> list(int page, int start, int limit){
		Session session = HibernateUtil.getSessionFactory().openSession();
		final Criteria criteria = session.createCriteria(Categoria.class);
		criteria.setFirstResult(start);
		criteria.setMaxResults(limit);
		criteria.addOrder(Order.asc("id"));
		return categorias = criteria.list();
	}
	

	@Override
	public int getCount(List<Categoria> list) {
		return list.size();
	}
	
	
	public void deleteList(List<Integer> listCod) {
		Session sessao = null;
		Transaction transacao = null;
		/*try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			for (Integer integer : listCod) {
				
				sessao.delete(load);
				transacao.commit();
			}
		} catch (HibernateException e) {
			if (transacao != null) {
				transacao.rollback();
			}
			return Constants.ERROR;
		} finally {
			sessao.close();
		}
*/
		sessao = HibernateUtil.getSessionFactory().openSession();
		Categoria categoria = new Categoria();
		for (Integer cod : listCod) {
			
			transacao = sessao.beginTransaction();
			categoria = (Categoria) sessao.get(Categoria.class,
					new Integer(cod));
			sessao.delete(categoria);
			transacao.commit();
		}

	}

}
