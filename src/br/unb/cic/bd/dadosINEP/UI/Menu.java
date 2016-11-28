package br.unb.cic.bd.dadosINEP.UI;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.jpa.jpql.parser.WhereClause;

import br.unb.cic.bd.dadosINEP.model.Tab_aluno;
import br.unb.cic.bd.dadosINEP.model.Tab_ies;

public class Menu {
	private static final String PERSISTENCE_UNIT_NAME = "INEP";
    private EntityManager em;
	
	public Menu() {
		inicialize();
		
		while(true){
			System.out.println("Escolha uma opção");
			System.out.println("1-Qual o número de alunos por curso no nível superior no ano de 2013?");
			System.out.println("2-Qual o número de mulheres nos cursos de computação");
			System.out.println("3-Quais as porcentagens de cursos presenciais e cursos EaD nas categorias "
					+ "dos institutos de ensino?");
			System.out.println("4-Qual a porcentagem de mulheres e homens que trabalham em instituições "
					+ "de ensino com apenas ensino fundamental completo, ensino médio completo, graduação "
					+ "completa, mestrado completo ou doutorado completo?");
			System.out.println("5-Qual o total de investimento em pesquisa pelas instituições de ensino superior?");
			System.out.println("6-Sair");
			
			Scanner reader = new Scanner(System.in);
			System.out.println("Enter a number: ");
			int n = reader.nextInt();
			
			switch (n) {
			 case 1: primeiraQuery();
			 	break;
			 case 2: segundaQuery();
			 	break;
			 case 3: terceiraQuery();
			 	break;
			 case 4: quartaQuery();
			 	break;
			 case 5: quintaQuery();
			 	break;
			 case 6: System.exit(0);
			 	break;
			 default: System.out.println("Opção Invalida");

			}
		}
		
	}
	
	private void inicialize() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = factory.createEntityManager();
	}
	
	private void zeroQuery(){
		//Exemplo
		
		try {
			Query q = em.createQuery("Select UPPER(ies.no_ies) from Tab_ies ies");
			q.setMaxResults(100);
			List<String> iezes = q.getResultList();
			for(String ies : iezes){
				System.out.println(ies);
			}
			System.out.println("Size:" + iezes.size());
		} catch (Exception e) {
			System.out.println("Deu erro");
//			e.printStackTrace();
		}
		
	}
	
	private void primeiraQuery(){
		System.out.println("Escolha um ies");
		Scanner reader = new Scanner(System.in);
		String no_ies = reader.nextLine();
		try{
			String query = "Select count(ies) from Tab_aluno a JOIN Tab_ies ies where ies.no_ies = " +  "'" + no_ies + "'";
			System.out.println(query);
			Query q = em.createQuery(query);
			System.out.println("Total de alunos neste IES: "+ (long)q.getSingleResult());
		} catch (Exception e) {
			System.out.println("Deu erro");
			e.printStackTrace();
		}	
	}
	
	private void segundaQuery(){
		//TODO:usar a tabela criada

		//imcompleta
//		try{
//			Query q = em.createQuery("Select count(b) from Tab_alunos a JOIN a.co_sexo b JOIN Tab_curso " +
//			"WHERE b.ds_sexo = :sexo");
//			q.setParameter("sexo", "Feminino");
//			System.out.println("Total de alunos neste IES: "+ (long)q.getSingleResult());
//		} catch (Exception e) {
//			System.out.println("Deu erro");
//			e.printStackTrace();
//		}
	}
	
	private void terceiraQuery(){
		try{
			//nome das tabelas apos o JOIN ="b"
			String query = "Select count(cur) from Tab_curso cur";
			System.out.println(query);
			Query qtotal = em.createQuery(query);
			
			query = "Select count(b) from Tab_curso cur JOIN Tab_modalidade_ensino b"
		+" where b.ds_modalidade_ensino = 'Curso a distância'";
			System.out.println(query);
			Query qdistancia = em.createQuery(query);
			System.out.println("total = "+ (long)qtotal.getSingleResult());
			System.out.println("ead = "+ (long)qdistancia.getSingleResult());

			float razao = (long)qdistancia.getSingleResult()/(long)qtotal.getSingleResult();
			System.out.println("Porcentagem de cursos a distancia é: " + razao);
		} catch (Exception e) {
			System.out.println("Deu erro");
			e.printStackTrace();
		}
	}
	
	private void quartaQuery(){
		System.out.println("Escolha um ies");
		Scanner reader = new Scanner(System.in);
		String no_ies = reader.nextLine();
		try{			
			Query q = em.createQuery("Select ies.qt_tec_total from Tab_ies ies");
			System.out.println("Número de tecnicos : " + q.getSingleResult());
			//
			String query = "Select ies.qt_tec_fund_incomp_fem from Tab_ies ies "
					+ "WHERE ies.no_ies = " +  "'" + no_ies + "'";
			System.out.println(query);
			Query q2 = em.createQuery(query);
			System.out.println("Número de tecnicos do sexo feminino com o nivel fundamnetal completo: "
					+ q.getFirstResult());
			//
			query = "Select ies.qt_tec_fund_incomp_masc from Tab_ies ies "
					+ "WHERE ies.no_ies = " +  "'" + no_ies + "'";
			System.out.println(query);
			Query q3 = em.createQuery(query);
			System.out.println("Número de tecnicos do sexo masculino com o nivel fundamnetal completo: "
					+ q.getFirstResult());
			//
			query = "Select ies.qt_tec_fund_incomp_masc from Tab_ies ies "
					+ "WHERE ies.no_ies = " +  "'" + no_ies + "'";
			System.out.println(query);
			Query q4 = em.createQuery(query);
			System.out.println("Número de tecnicos do sexo masculino com o nivel fundamnetal incompleto: "
					+ q.getFirstResult());
			//
			Query q5 = em.createQuery("Select ies.qt_tec_medio_fem from Tab_ies ies "
					+ "WHERE ies.no_ies = " +  "'" + no_ies + "'");
			System.out.println("Número de tecnicos do sexo feminido com o nivel medio completo: "
					+ q.getFirstResult());
			//
			Query q6 = em.createQuery("Select ies.qt_tec_medio_masc from Tab_ies ies "
					+ "WHERE ies.no_ies = " +  "'" + no_ies + "'");
			System.out.println("Número de tecnicos do sexo masculino com o nivel medio completo: "
					+ q.getFirstResult());
			//
			Query q7 = em.createQuery("Select ies.qt_tec_superior_fem from Tab_ies ies "
					+ "WHERE ies.no_ies = " +  "'" + no_ies + "'");
			System.out.println("Número de tecnicos do sexo feminino com o nivel superior completo: "
					+ q.getFirstResult());
			//
			Query q8 = em.createQuery("Select ies.qt_tec_superior_masc from Tab_ies ies "
					+ "WHERE ies.no_ies = " + "'" + no_ies + "'");
			System.out.println("Número de tecnicos do sexo masculino com o nivel superior completo: "
					+ q.getFirstResult());
			//
			///deixei sem a especializacao
			Query q9 = em.createQuery("Select ies.qt_tec_mestrado_fem from Tab_ies ies "
					+ "WHERE ies.no_ies = " +   "'" + no_ies + "'");
			System.out.println("Número de tecnicos do sexo feminino com o mestrado completo: "
					+ q.getFirstResult());
			//
			Query q10 = em.createQuery("Select ies.qt_tec_mestrado_masc from Tab_ies ies "
					+ "WHERE ies.no_ies = " +  "'" + no_ies + "'");
			System.out.println("Número de tecnicos do sexo masculino com o mestrado completo: "
					+ q.getFirstResult());
			//
			Query q11 = em.createQuery("Select ies.qt_tec_doutorado_fem from Tab_ies ies "
					+ "WHERE ies.no_ies = " +  "'" + no_ies + "'");
			System.out.println("Número de tecnicos do sexo feminino com o doutorado completo: "
					+ q.getFirstResult());
			//
			Query q12 = em.createQuery("Select ies.qt_tec_doutorado_masc from Tab_ies ies "
					+ "WHERE ies.no_ies = " +  "'" + no_ies + "'");
			System.out.println("Número de tecnicos do sexo masculino com o doutorado completo: "
					+ q.getFirstResult());
			//
			
		} catch (Exception e) {
			System.out.println("Deu erro");
			e.printStackTrace();
		}
	}
	private void quintaQuery(){
		System.out.println("Escolha um ies ");
		Scanner reader = new Scanner(System.in);
		String no_ies = reader.nextLine();
		try{
			String query = "Select ies.vl_des_pesquisa from Tab_ies ies "
					+ "WHERE ies.no_ies = " +  "'" + no_ies + "'";
			System.out.println(query);

			Query q = em.createQuery(query);
			System.out.println("Total gasto com pesquisa pelo ies"
					+ q.getSingleResult());
		} catch (Exception e) {
			System.out.println("Deu erro");
			e.printStackTrace();
		}	
	}


	

}
