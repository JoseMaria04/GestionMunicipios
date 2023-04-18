package com.softwareCompany.municipiosYProvincias.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.softwareCompany.municipiosYProvincias.model.Municipio;



public class ControladorMunicipio {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("municipiosyprovincias");

	
	/**
	 * 
	 * @param descripcion
	 * @return
	 */
	public static List<Municipio> findByLikeDescripcion (String descripcion){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM Municipio where nombre like ? ;", Municipio.class);
		q.setParameter(1, "%" + descripcion + "%");
		
		@SuppressWarnings("unchecked")
		List<Municipio> l = (List<Municipio>) q.getResultList();
		em.close();
		return l;
	}
	
	/**
	 * 
	 */
	public static void modificarEntidad (Municipio l) {
		EntityManager em = entityManagerFactory.createEntityManager();		
		
		em.getTransaction().begin();
		em.merge(l);
		em.getTransaction().commit();
		em.close();
	}
}
