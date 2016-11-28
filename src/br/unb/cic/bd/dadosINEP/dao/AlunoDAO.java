package br.unb.cic.bd.dadosINEP.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unb.cic.bd.dadosINEP.chavesPrimarias.AlunoPK;
import br.unb.cic.bd.dadosINEP.model.Tab_aluno;
import br.unb.cic.bd.dadosINEP.model.Tab_curso;
import br.unb.cic.bd.dadosINEP.model.Tab_ies;
import lombok.Data;

@Data
public class AlunoDAO {

	private static AlunoDAO instance;
    protected EntityManager entityManager;
    
    public static AlunoDAO getInstance(){
              if (instance == null){
                       instance = new AlunoDAO();
              }
              
              return instance;
    }

    private AlunoDAO() {
              entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("INEP");
        if (entityManager == null) {
                 entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    public Tab_aluno getByPK(AlunoPK alunoPK) {
        return entityManager.find(Tab_aluno.class, alunoPK);
    }
    
    @SuppressWarnings("unchecked")
    public List<Tab_aluno> findAll() {
              return entityManager.createQuery("FROM " + Tab_aluno.class.getName()).getResultList();
    }
    
    public void persist(Tab_aluno aluno) {
        try {
                 entityManager.getTransaction().begin();
                 entityManager.persist(aluno);
                 entityManager.getTransaction().commit();
        } catch (EntityExistsException e) {
			System.out.println("Já existe um elemento com esta pk");
		} catch (Exception ex) {
			if(!ex.getClass().isInstance(EntityExistsException.class)) {
			}
            entityManager.getTransaction().rollback();
		}
    }
    
    public void merge(Tab_aluno aluno) {
        try {
                 entityManager.getTransaction().begin();
                 entityManager.merge(aluno);
                 entityManager.getTransaction().commit();
        } catch (Exception ex) {
                 ex.printStackTrace();
                 entityManager.getTransaction().rollback();
        }
    }
    
    public void remove(Tab_aluno aluno) {
        try {
                 entityManager.getTransaction().begin();
                 aluno = entityManager.find(Tab_aluno.class, aluno.getAlunoPK());
                 entityManager.remove(aluno);
                 entityManager.getTransaction().commit();
        } catch (Exception ex) {
                 ex.printStackTrace();
                 entityManager.getTransaction().rollback();
        }
}
    
    public void removeById(final AlunoPK alunoPK) {
        try {
                 Tab_aluno aluno = getByPK(alunoPK);
                 remove(aluno);
        } catch (Exception ex) {
                 ex.printStackTrace();
        }
    }
    
    
    
}
