package br.unb.cic.bd.dadosINEP.UI;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.unb.cic.bd.dadosINEP.model.Aluno;

public class Main {
	private static final String PERSISTENCE_UNIT_NAME = "INEP";
    private static EntityManagerFactory factory;


	public static void main(String[] args) {
		//TODO: mudar isso
		System.out.println("Criando a tabela toda vez que executa");
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		Query q = em.createQuery("select a from Aluno a");
		List<Aluno> alunos = q.getResultList();
		for(Aluno aluno : alunos){
			System.out.println(aluno);
		}
		System.out.println("Size:" + alunos.size());
		
		em.getTransaction().begin();
		//criando novo aluno
		Aluno novo = new Aluno();
		novo.setCo_aluno(23);
		em.persist(novo);
		em.getTransaction().commit();
		em.close();
		
	}

}
