package br.unb.cic.bd.dadosINEP.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unb.cic.bd.dadosINEP.model.Tab_ies;

public class IesDAO {
	private static IesDAO instance;
    protected EntityManager entityManager;
    
    public static IesDAO getInstance(){
              if (instance == null){
                       instance = new IesDAO();
              }
              
              return instance;
    }

    private IesDAO() {
              entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("INEP");
        if (entityManager == null) {
                 entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    public Tab_ies getByPK(int iesPK) {
        return entityManager.find(Tab_ies.class, iesPK);
    }
    
    @SuppressWarnings("unchecked")
    public List<Tab_ies> findAll() {
              return entityManager.createQuery("FROM " + Tab_ies.class.getName()).getResultList();
    }
    
    public void persist(Tab_ies ies) {
        try {
                 entityManager.getTransaction().begin();
                 entityManager.persist(ies);
                 entityManager.getTransaction().commit();
        } catch (EntityExistsException e) {
			System.out.println("Já existe um elemento com esta pk");
		} catch (Exception ex) {
			if(!ex.getClass().isInstance(EntityExistsException.class)) {
			}
            entityManager.getTransaction().rollback();
		}
    }
    
    public void merge(Tab_ies ies) {
        try {
                 entityManager.getTransaction().begin();
                 entityManager.merge(ies);
                 entityManager.getTransaction().commit();
        } catch (Exception ex) {
                 ex.printStackTrace();
                 entityManager.getTransaction().rollback();
        }
    }
    
    public void remove(Tab_ies ies) {
        try {
                 entityManager.getTransaction().begin();
                 ies = entityManager.find(Tab_ies.class, ies.getCo_ies());
                 entityManager.remove(ies);
                 entityManager.getTransaction().commit();
        } catch (Exception ex) {
                 ex.printStackTrace();
                 entityManager.getTransaction().rollback();
        }
}
    
    public void removeById(final int iesPK) {
        try {
                 Tab_ies ies = getByPK(iesPK);
                 remove(ies);
        } catch (Exception ex) {
                 ex.printStackTrace();
        }
    }
}
