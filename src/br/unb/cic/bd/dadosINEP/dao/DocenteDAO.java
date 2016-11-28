package br.unb.cic.bd.dadosINEP.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unb.cic.bd.dadosINEP.chavesPrimarias.DocentePK;
import br.unb.cic.bd.dadosINEP.model.Tab_docente;

public class DocenteDAO {

	private static DocenteDAO instance;
    protected EntityManager entityManager;
    
    public static DocenteDAO getInstance(){
              if (instance == null){
                       instance = new DocenteDAO();
              }
              
              return instance;
    }

    private DocenteDAO() {
              entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("INEP");
        if (entityManager == null) {
                 entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    public Tab_docente getByPK(DocentePK docentePK) {
        return entityManager.find(Tab_docente.class, docentePK);
    }
    
    @SuppressWarnings("unchecked")
    public List<Tab_docente> findAll() {
              return entityManager.createQuery("FROM " + Tab_docente.class.getName()).getResultList();
    }
    
    public void persist(Tab_docente docente) {
        try {
                 entityManager.getTransaction().begin();
                 entityManager.persist(docente);
                 entityManager.getTransaction().commit();
        } catch (EntityExistsException e) {
			System.out.println("Já existe um elemento com esta pk");
		} catch (Exception ex) {
			if(!ex.getClass().isInstance(EntityExistsException.class)) {
			}
            entityManager.getTransaction().rollback();
		}
    }
    
    public void merge(Tab_docente docente) {
        try {
                 entityManager.getTransaction().begin();
                 entityManager.merge(docente);
                 entityManager.getTransaction().commit();
        } catch (Exception ex) {
                 ex.printStackTrace();
                 entityManager.getTransaction().rollback();
        }
    }
    
    public void remove(Tab_docente docente) {
        try {
                 entityManager.getTransaction().begin();
                 docente = entityManager.find(Tab_docente.class, docente.getDocentePK());
                 entityManager.remove(docente);
                 entityManager.getTransaction().commit();
        } catch (Exception ex) {
                 ex.printStackTrace();
                 entityManager.getTransaction().rollback();
        }
}
    
    public void removeById(final DocentePK docentePK) {
        try {
                 Tab_docente docente = getByPK(docentePK);
                 remove(docente);
        } catch (Exception ex) {
                 ex.printStackTrace();
        }
    }
}
