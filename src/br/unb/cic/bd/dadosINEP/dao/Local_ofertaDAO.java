package br.unb.cic.bd.dadosINEP.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unb.cic.bd.dadosINEP.model.Tab_local_oferta;

public class Local_ofertaDAO {
	private static Local_ofertaDAO instance;
    protected EntityManager entityManager;
    
    public static Local_ofertaDAO getInstance(){
              if (instance == null){
                       instance = new Local_ofertaDAO();
              }
              
              return instance;
    }

    private Local_ofertaDAO() {
              entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("INEP");
        if (entityManager == null) {
                 entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    public Tab_local_oferta getByPK(int localPK) {
        return entityManager.find(Tab_local_oferta.class, localPK);
    }
    
    @SuppressWarnings("unchecked")
    public List<Tab_local_oferta> findAll() {
              return entityManager.createQuery("FROM " + Tab_local_oferta.class.getName()).getResultList();
    }
    
    public void persist(Tab_local_oferta local) {
        try {
                 entityManager.getTransaction().begin();
                 entityManager.persist(local);
                 entityManager.getTransaction().commit();
        } catch (EntityExistsException e) {
			System.out.println("Já existe um elemento com esta pk");
		} catch (Exception ex) {
			if(!ex.getClass().isInstance(EntityExistsException.class)) {
			}
            entityManager.getTransaction().rollback();
		}
    }
    
    public void merge(Tab_local_oferta local) {
        try {
                 entityManager.getTransaction().begin();
                 entityManager.merge(local);
                 entityManager.getTransaction().commit();
        } catch (Exception ex) {
                 ex.printStackTrace();
                 entityManager.getTransaction().rollback();
        }
    }
    
    public void remove(Tab_local_oferta local) {
        try {
                 entityManager.getTransaction().begin();
                 local = entityManager.find(Tab_local_oferta.class, local.getCo_ies());
                 entityManager.remove(local);
                 entityManager.getTransaction().commit();
        } catch (Exception ex) {
                 ex.printStackTrace();
                 entityManager.getTransaction().rollback();
        }
}
    
    public void removeById(final int localPK) {
        try {
                 Tab_local_oferta local = getByPK(localPK);
                 remove(local);
        } catch (Exception ex) {
                 ex.printStackTrace();
        }
    }
}
