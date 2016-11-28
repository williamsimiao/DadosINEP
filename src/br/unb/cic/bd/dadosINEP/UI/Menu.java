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
			System.out.println("1-lalalalala");
			System.out.println("2-lalalalala");
			System.out.println("3-lalalalala");
			System.out.println("4-lalalalala");
			System.out.println("5-lalalalala");
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
			Query q = em.createQuery("Select count(ies) from Tab_ies ies where ies.no_ies = " + no_ies);
			System.out.println("Total de alunos neste IES: "+ (long)q.getSingleResult());
		} catch (Exception e) {
			System.out.println("Deu erro");
//			e.printStackTrace();
		}	
	}
	
	private void segundaQuery(){
		//imcompleta
		try{
			Query q = em.createQuery("Select count(b) from Tab_alunos a JOIN a.co_sexo b JOIN Tab_curso " +
			"WHERE b.ds_sexo = :sexo");
			q.setParameter("sexo", "Feminino");
			System.out.println("Total de alunos neste IES: "+ (long)q.getSingleResult());
		} catch (Exception e) {
			System.out.println("Deu erro");
//			e.printStackTrace();
		}
	}
	
	private void terceiraQuery(){
		try{
			//nome das tabelas apos o JOIN ="b"
			Query qtotal = em.createQuery("Select count(cur) from Tab_curso cur");
			Query qdistancia = em.createQuery("Select count(b) from Tab_curso cur JOIN Tab_modalidade_ensino b"
		+" where b.ds_modalidade_ensino = :modalidade");
			qdistancia.setParameter("modalidade", "Curso a distancia");
			float razao = (long)qdistancia.getSingleResult()/(long)qtotal.getSingleResult();
			System.out.println("Porcentagem de cursos a distancia é: " + razao);
		} catch (Exception e) {
			System.out.println("Deu erro");
//			e.printStackTrace();
		}
		
	}
	
	private void quartaQuery(){
		System.out.println("Escolha um ies");
		Scanner reader = new Scanner(System.in);
		String no_ies = reader.nextLine();
		try{			
			Query q = em.createQuery("Select ies.qt_tec_total from Tab_ies ies");
			System.out.println("Número de tecnicos" + (long)q.getSingleResult());
			//
			Query q2 = em.createQuery("Select ies.qt_tec_fund_incomp_fem from Tab_ies ies"
					+ "WHERE ies.no_ies = " + no_ies);
			System.out.println("Número de tecnicos do sexo feminino com o nivel fundamnetal completo: "
					+ (long)q.getSingleResult());
			//
			Query q3 = em.createQuery("Select ies.qt_tec_fund_incomp_masc from Tab_ies ies"
					+ "WHERE ies.no_ies = " + no_ies);
			System.out.println("Número de tecnicos do sexo masculino com o nivel fundamnetal completo: "
					+ (long)q.getSingleResult());
			//
			Query q4 = em.createQuery("Select ies.qt_tec_fund_incomp_masc from Tab_ies ies"
					+ "WHERE ies.no_ies = " + no_ies);
			System.out.println("Número de tecnicos do sexo masculino com o nivel fundamnetal incompleto: "
					+ (long)q.getSingleResult());
			//
			Query q5 = em.createQuery("Select ies.qt_tec_medio_fem from Tab_ies ies"
					+ "WHERE ies.no_ies = " + no_ies);
			System.out.println("Número de tecnicos do sexo feminido com o nivel medio completo: "
					+ (long)q.getSingleResult());
			//
			Query q6 = em.createQuery("Select ies.qt_tec_medio_masc from Tab_ies ies"
					+ "WHERE ies.no_ies = " + no_ies);
			System.out.println("Número de tecnicos do sexo masculino com o nivel medio completo: "
					+ (long)q.getSingleResult());
			//
			Query q7 = em.createQuery("Select ies.qt_tec_superior_fem from Tab_ies ies"
					+ "WHERE ies.no_ies = " + no_ies);
			System.out.println("Número de tecnicos do sexo feminino com o nivel superior completo: "
					+ (long)q.getSingleResult());
			//
			Query q8 = em.createQuery("Select ies.qt_tec_superior_masc from Tab_ies ies"
					+ "WHERE ies.no_ies = " + no_ies);
			System.out.println("Número de tecnicos do sexo masculino com o nivel superior completo: "
					+ (long)q.getSingleResult());
			//
			///deixei sem a especializacao
			Query q9 = em.createQuery("Select ies.qt_tec_mestrado_fem from Tab_ies ies"
					+ "WHERE ies.no_ies = " + no_ies);
			System.out.println("Número de tecnicos do sexo feminino com o mestrado completo: "
					+ (long)q.getSingleResult());
			//
			Query q10 = em.createQuery("Select ies.qt_tec_mestrado_masc from Tab_ies ies"
					+ "WHERE ies.no_ies = " + no_ies);
			System.out.println("Número de tecnicos do sexo masculino com o mestrado completo: "
					+ (long)q.getSingleResult());
			//
			Query q11 = em.createQuery("Select ies.qt_tec_doutorado_fem from Tab_ies ies"
					+ "WHERE ies.no_ies = " + no_ies);
			System.out.println("Número de tecnicos do sexo feminino com o doutorado completo: "
					+ (long)q.getSingleResult());
			//
			Query q12 = em.createQuery("Select ies.qt_tec_doutorado_masc from Tab_ies ies"
					+ "WHERE ies.no_ies = " + no_ies);
			System.out.println("Número de tecnicos do sexo masculino com o doutorado completo: "
					+ (long)q.getSingleResult());
			//
			
		} catch (Exception e) {
			System.out.println("Deu erro");
			e.printStackTrace();
		}
		
	}
	private void quintaQuery(){
		System.out.println("Escolha um ies");
		Scanner reader = new Scanner(System.in);
		String no_ies = reader.nextLine();
		try{
			Query q = em.createQuery("Select ies.vl_des_pesquisa from Tab_ies ies "
					+ "WHERE ies.no_ies = " + no_ies);
			System.out.println("Numero de tecnicos do sexo feminino com o nivel fundamnetal incompleto: "
					+ (long)q.getSingleResult());
		} catch (Exception e) {
			System.out.println("Deu erro");
			e.printStackTrace();
		}
		
		
		
	}


	

}
