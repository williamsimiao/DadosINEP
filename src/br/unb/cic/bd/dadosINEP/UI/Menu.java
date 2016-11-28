package br.unb.cic.bd.dadosINEP.UI;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.jpa.jpql.parser.WhereClause;
import org.postgresql.core.NativeQuery;

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
			System.out.println("2-Qual o número de mulheres nos cursos de computação?");
			System.out.println("3-Quais as porcentagens de cursos presenciais e cursos EaD nas categorias "
					+ "dos institutos de ensino?");
			System.out.println("4-Qual a porcentagem de mulheres e homens que trabalham em instituições "
					+ "de ensino com apenas ensino fundamental completo, ensino médio completo, graduação "
					+ "completa, mestrado completo ou doutorado completo?");
//			System.out.println("5-Qual o total de investimento em pesquisa pelas instituições de ensino superior?");
			System.out.println("5-Qual o total de pessoas de raça cor preta nos cursos de computação na seguinte IES?");
			System.out.println("6-Sair");
			
			Scanner reader = new Scanner(System.in);
			System.out.print("Escolha uma opção: ");
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
//			 case 5: quintaQuery();
//			 	break;
			 case 5: sextaQuery();
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
	
	private void primeiraQuery(){
		System.out.print("Escolha um curso: ");
		Scanner reader = new Scanner(System.in);
		String no_curso = reader.nextLine();
		try{
			String queryString = "Select count(co_aluno) from Tab_aluno NATURAL JOIN Tab_curso WHERE no_curso ILIKE " + "'" + no_curso + "'";
			//precisa do NAtive, se nao, da erro sintatico
			Query qNativeQuery = em.createNativeQuery(queryString);
			System.out.println(queryString);
			System.out.println("Total de alunos neste curso nacionalmente: "+ qNativeQuery.getSingleResult());
			System.out.println();
		} catch (Exception e) {
			System.out.println("Deu erro");
			e.printStackTrace();
		}	
	}
	
	private void segundaQuery(){
		//TODO:usar a tabela criada

		try{
			Query q = em.createNativeQuery("SELECT count(co_aluno) FROM tab_aluno"
		+  " NATURAL JOIN tab_curso JOIN tab_sexo"
		+ " ON tab_aluno.in_sexo_aluno = tab_sexo.in_sexo AND tab_sexo.ds_sexo = 'Feminino'"
		+ " WHERE tab_curso.no_curso ILIKE '%Computa%';");
			System.out.println("Total de mulheres em cursos de Computação: "+ (long)q.getSingleResult());
			System.out.println();
		} catch (Exception e) {
			System.out.println("Deu erro");
			e.printStackTrace();
		}
	}
	
	private void terceiraQuery(){
		try{
			//nome das tabelas apos o JOIN ="b"
			String query = "Select count(cur) from Tab_curso cur";
			System.out.println(query);
			Query qtotal = em.createNativeQuery(query);
			
			query = "SELECT count(co_curso) FROM tab_curso NATURAL JOIN tab_modalidade_ensino WHERE ds_modalidade_ensino = 'Curso a distância';";
			System.out.println(query);
			Query qdistancia = em.createNativeQuery(query);
			System.out.println("total = "+ (long)qtotal.getSingleResult());
			System.out.println("ead = "+ qdistancia.getSingleResult());

			float razao =(float) (100.0 * (long)qdistancia.getSingleResult()/(long)qtotal.getSingleResult());
			
			System.out.println("Porcentagem de cursos à distância é: " + razao + "%");
			System.out.println();
		} catch (Exception e) {
			System.out.println("Deu erro");
			e.printStackTrace();
		}
	}
	
	private void quartaQuery(){
		System.out.print("Escolha um IES:");
		Scanner reader = new Scanner(System.in);
		String no_ies = reader.nextLine();
		try{			
			
			//total
			Query q = em.createNativeQuery("SELECT qt_tec_total FROM tab_ies WHERE no_ies = " +  "'" + no_ies + "'");
			System.out.println("Número total de tecnicos : " + q.getSingleResult());
			//
			String query = "SELECT qt_tec_fund_incomp_fem FROM tab_ies WHERE no_ies = " +  "'" + no_ies + "'";
			System.out.println(query);
			Query q2 = em.createNativeQuery(query);
			System.out.println("Número de tecnicos do sexo feminino com o nivel fundamental completo: "
					+ q2.getSingleResult());
			//
			query = "SELECT qt_tec_fund_incomp_masc FROM tab_ies WHERE no_ies = " +  "'" + no_ies + "'";
			System.out.println(query);
			Query q3 = em.createNativeQuery(query);
			System.out.println("Número de tecnicos do sexo masculino com o nivel fundamental completo: "
					+ q3.getSingleResult());
			//
			query = "SELECT qt_tec_fund_incomp_masc FROM tab_ies WHERE no_ies = " +  "'" + no_ies + "'";
			System.out.println(query);
			Query q4 = em.createNativeQuery(query);
			System.out.println("Número de tecnicos do sexo masculino com o nivel fundamental incompleto: "
					+ q4.getSingleResult());
			//
			query = "SELECT qt_tec_medio_fem FROM tab_ies WHERE no_ies = " +  "'" + no_ies + "'";
			Query q5 = em.createNativeQuery(query);
			System.out.println("Número de tecnicos do sexo feminido com o nivel medio completo: "
					+ q5.getSingleResult());
			//
			query = "SELECT qt_tec_medio_masc FROM tab_ies WHERE no_ies = " +  "'" + no_ies + "'";
			Query q6 = em.createNativeQuery(query);
			System.out.println("Número de tecnicos do sexo masculino com o nivel medio completo: "
					+ q6.getSingleResult());
			//
			query = "SELECT qt_tec_superior_fem FROM tab_ies WHERE no_ies = " +  "'" + no_ies + "'";
			Query q7 = em.createNativeQuery(query);
			System.out.println("Número de tecnicos do sexo feminino com o nivel superior completo: "
					+ q7.getSingleResult());
			//
			query = "SELECT qt_tec_superior_masc FROM tab_ies WHERE no_ies = " +  "'" + no_ies + "'";
			Query q8 = em.createNativeQuery(query);
			System.out.println("Número de tecnicos do sexo masculino com o nivel superior completo: "
					+ q8.getSingleResult());
			//
			query = "SELECT qt_tec_mestrado_fem FROM tab_ies WHERE no_ies = " +  "'" + no_ies + "'";
			Query q9 = em.createNativeQuery(query);
			System.out.println("Número de tecnicos do sexo feminino com o mestrado completo: "
					+ q9.getSingleResult());
			//
			query = "SELECT qt_tec_mestrado_masc FROM tab_ies WHERE no_ies = " +  "'" + no_ies + "'";
			Query q10 = em.createNativeQuery(query);
			System.out.println("Número de tecnicos do sexo masculino com o mestrado completo: "
					+ q10.getSingleResult());
			//
			query = "SELECT qt_tec_doutorado_fem FROM tab_ies WHERE no_ies = " +  "'" + no_ies + "'";
			Query q11 = em.createNativeQuery(query);
			System.out.println("Número de tecnicos do sexo feminino com o doutorado completo: "
					+ q11.getSingleResult());
			//
			query = "SELECT qt_tec_doutorado_masc FROM tab_ies WHERE no_ies = " +  "'" + no_ies + "'";
			Query q12 = em.createNativeQuery(query);
			System.out.println("Número de tecnicos do sexo masculino com o doutorado completo: "
					+ q12.getSingleResult());
			//
			System.out.println();
			
		} catch (Exception e) {
			System.out.println("Deu erro");
			e.printStackTrace();
		}
	}
//	private void quintaQuery(){
//		System.out.print("Escolha um IES: ");
//		Scanner reader = new Scanner(System.in);
//		String no_ies = reader.nextLine();
//		try{
//			String query = "SELECT vl_des_pesquisa FROM tab_ies WHERE no_ies = " + "'" + no_ies + "';";
//			System.out.println(query);
//			Query q = em.createNativeQuery(query);
//			System.out.println("Total gasto com pesquisa pelo IES: " + q.getSingleResult());
//			System.out.println();
//		} catch (Exception e) {
//			System.out.println("Deu erro");
//			e.printStackTrace();
//		}	
//	}
	
	private void sextaQuery(){
		System.out.print("Escolha um IES: ");
		Scanner reader = new Scanner(System.in);
		String no_ies = reader.nextLine();
		try{
			String query = "SELECT qt_alunos_cor_preta FROM tab_estatisticas_computacao NATURAL JOIN tab_ies WHERE no_ies = " + "'" + no_ies + "'";
			System.out.println(query);
			Query q = em.createNativeQuery(query);
			System.out.println("Total gasto com pesquisa pelo IES: " + q.getSingleResult());
			System.out.println();
		} catch (Exception e) {
			System.out.println("Deu erro");
			e.printStackTrace();
		}	
	}


	

}
