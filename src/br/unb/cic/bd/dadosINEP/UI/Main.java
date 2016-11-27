package br.unb.cic.bd.dadosINEP.UI;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.unb.cic.bd.dadosINEP.chavesPrimarias.AlunoPK;
import br.unb.cic.bd.dadosINEP.model.Tab_aluno;
import br.unb.cic.bd.dadosINEP.model.Tab_curso;
import br.unb.cic.bd.dadosINEP.model.Tab_ies;

public class Main {
	private static final String PERSISTENCE_UNIT_NAME = "INEP";
    private static EntityManagerFactory factory;


	public static void main(String[] args) {
		//TODO: mudar isso
		System.out.println("Criando a tabela toda vez que executa");
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		Query q = em.createQuery("select a from Aluno a");
		List<Tab_aluno> alunos = q.getResultList();
		for(Tab_aluno aluno : alunos){
			System.out.println(aluno);
		}
		System.out.println("Size:" + alunos.size());
		
		em.getTransaction().begin();
		//Ies
		Tab_ies ies = new Tab_ies(32);
		em.persist(ies);
		//curso
		Tab_curso curso = new Tab_curso(23);
		em.persist(curso);
	
		//criando PK aluno
		AlunoPK alunoPK = new AlunoPK(1, 23, 32);
		Tab_aluno aluno = new Tab_aluno(alunoPK);
		em.persist(aluno);

		em.getTransaction().commit();
		em.close();
		
	}

}
