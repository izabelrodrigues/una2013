/**
 * 
 */
package com.estoque.service.interfaces;

import java.util.Set;

/**
 * @author Izabel
 * Interface a ser implementada pelo serviço das entiddades.
 */
public interface Generic<T> {
	
	public void save(T obj);
	public void searchId(int cod);
	public void delete (T obj);
	public void update(T obj);
	public Set<T> listAll();

}
