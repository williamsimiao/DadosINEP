package br.unb.cic.bd.dadosINEP.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unb.cic.bd.dadosINEP.chavesPrimarias.AlunoPK;
import br.unb.cic.bd.dadosINEP.model.Tab_aluno;
import br.unb.cic.bd.dadosINEP.model.Tab_curso;

public class CursoDAO {
	private static CursoDAO instance;
    protected EntityManager entityManager;
    
    public static CursoDAO getInstance(){
              if (instance == null){
                       instance = new CursoDAO();
              }
              
              return instance;
    }

    private CursoDAO() {
              entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("INEP");
        if (entityManager == null) {
                 entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    public Tab_curso getByPK(int id) {
        return entityManager.find(Tab_curso.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<Tab_curso> findAll() {
              return entityManager.createQuery("FROM " + Tab_aluno.class.getName()).getResultList();
    }
    
    public void persist(Tab_curso curso) {
        try {
                 entityManager.getTransaction().begin();
                 entityManager.persist(curso);
                 entityManager.getTransaction().commit();
        } catch (EntityExistsException e) {
			System.out.println("Já existe um elemento com esta pk");
		} catch (Exception ex) {
			if(!ex.getClass().isInstance(EntityExistsException.class)) {
			}
//            entityManager.getTransaction().rollback();
		}
    }
    
    public void merge(Tab_curso curso) {
        try {
                 entityManager.getTransaction().begin();
                 entityManager.merge(curso);
                 entityManager.getTransaction().commit();
        } catch (Exception ex) {
                 ex.printStackTrace();
                 entityManager.getTransaction().rollback();
        }
    }
    
    public void remove(Tab_curso curso) {
        try {
                 entityManager.getTransaction().begin();
                 curso = entityManager.find(Tab_curso.class, curso.getCo_curso());
                 entityManager.remove(curso);
                 entityManager.getTransaction().commit();
        } catch (Exception ex) {
                 ex.printStackTrace();
                 entityManager.getTransaction().rollback();
        }
}
    
    public void removeById(final int id) {
        try {
                 Tab_curso curso = getByPK(id);
                 remove(curso);
        } catch (Exception ex) {
                 ex.printStackTrace();
        }
    }
	
}
