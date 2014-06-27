package com.epsi.TPOracle.dao;

import java.io.Serializable;
import java.util.List;

import com.epsi.TPOracle.common.HibernateSessionUtils;

public abstract class AbstractDao <T, PK extends Serializable> extends HibernateSessionUtils {


	
	@SuppressWarnings("unchecked")
	public T find(Class<T> c, PK id){
		return (T) getHibernateTemplate().get(c,id);
	}
	
	
	@SuppressWarnings("unchecked")
	public PK save(T obj){
		return (PK) getHibernateTemplate().save(obj);
	}
	
	public void update(T obj){
		getHibernateTemplate().update(obj);
	}
	
	public void delete(T obj){
		getHibernateTemplate().delete(obj);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> list(Class<T> c){
		return getHibernateTemplate().find("from"+c.getCanonicalName());
	}

}
