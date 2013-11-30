/**
 * 
 */
package com.estoque.service.interfaces;

import java.util.List;

/**
 * @author Izabel Interface a ser implementada pelo serviço das entiddades.
 */
public interface Generic<T> {

	public void save(T obj);

	public T findById(int cod);

	public void delete(int cod);

	public void update(T obj);

	public List<T> listAll();

	public int getCount(List<T> list);

}
