package com.estoque.service.interfaces.implementacoes;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;

import com.estoque.service.Constants;
import com.estoque.service.entity.Usuario;
import com.estoque.service.interfaces.Generic;
import com.estoque.service.util.HibernateUtil;


public class UsuarioImpl implements Generic<Usuario>{
	private List<Usuario> usuario;

	@Override 
	public String save(Usuario use) {
		Session sessao = null;
		Transaction transacao = null;

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(use);
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
	public Usuario findById(int cod) {
		Session sessao = null;
		Transaction transacao = null;
		Usuario usuario = new Usuario();

		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			usuario = (Usuario) sessao.get(Usuario.class,
					new Integer(cod));
			transacao.commit();

		} catch (HibernateException e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}

		return usuario;

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
	public String update(Usuario usr) {
		Session sessao = null;
		Transaction transacao = null;
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.update(usr);
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
	public List<Usuario> listAll() {
		Session sessao = null;
		Transaction transacao = null;
		usuario = new ArrayList<Usuario>();
		try {
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			Criteria consulta = sessao.createCriteria(Usuario.class);
			consulta.addOrder(Order.asc("id"));
			usuario = consulta.list();
			transacao.commit();
		} catch (HibernateException e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}

		return usuario;
	}

	@Override
	public int getCount(List<Usuario> list) {
		return list.size();
	}
}
