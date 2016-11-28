package br.unb.cic.bd.dadosINEP.UI;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.unb.cic.bd.dadosINEP.chavesPrimarias.AlunoPK;
import br.unb.cic.bd.dadosINEP.dao.AlunoDAO;
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
		try {
			Query q = em.createQuery("select a from Tab_aluno a");
			List<Tab_aluno> alunos = q.getResultList();
			for(Tab_aluno aluno : alunos){
				System.out.println(aluno);
			}
			System.out.println("Size:" + alunos.size());
		} catch (Exception e) {
			System.out.println("Deu erro");
			e.printStackTrace();

		}
		
		AlunoPK alunoPK = new AlunoPK(2, 23, 32);
//		Tab_aluno aluno = new Tab_aluno(alunoPK);
//		AlunoDAO.getInstance().persist(aluno);
		
		Tab_aluno aluno = AlunoDAO.getInstance().getByPK(alunoPK);
		System.out.println(aluno);

		
		
				
	}

}
