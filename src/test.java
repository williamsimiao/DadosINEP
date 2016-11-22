import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.unb.cic.bd.dadosINEP.model.Aluno;

public class test {
	private static final String PERSISTANCE_UNIT_NAME = "alunos";
	private static EntityManagerFactory factory;
	
	public static void main(String[]args) {
		System.out.println("OI");
		factory = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
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
		novo.setCategoria_administrativa(0);
		novo.setGrau_academico(1);
		novo.setModalidades_de_ensino(2);
		novo.setNivel_academico(3);
		novo.setOrganizacao_academica(4);
		novo.setRaca_do_aluno(5);
		novo.setSexo_do_aluno(6);
		em.persist(novo);
		em.getTransaction().commit();
		em.close();
		
	}

}
