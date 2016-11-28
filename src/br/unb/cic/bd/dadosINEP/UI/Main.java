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
		Menu meuMenu = new Menu();
		
		
		
		AlunoPK alunoPK = new AlunoPK(2, 23, 32);
//		Tab_aluno aluno = new Tab_aluno(alunoPK);
//		AlunoDAO.getInstance().persist(aluno);
		
		Tab_aluno aluno = AlunoDAO.getInstance().getByPK(alunoPK);
		System.out.println(aluno);

		
		
				
	}

}
