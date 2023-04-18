package com.softwareCompany.municipiosYProvincias.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.softwareCompany.municipiosYProvincias.model.Provincia;



public class ControladorProvincia {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("municipiosyprovincias");
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static List<Provincia> findById (int id){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM Provincia order by id = ? desc;", Provincia.class);
		q.setParameter(1, id);
		
		@SuppressWarnings("unchecked")
		List<Provincia> l = (List<Provincia>) q.getResultList();
		em.close();
		return l;
	}
}
