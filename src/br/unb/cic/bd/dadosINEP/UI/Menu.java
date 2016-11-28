package br.unb.cic.bd.dadosINEP.UI;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
	
	private void primeiraQuery(){
		//Exemplo
		
		try {
			Query q = em.createQuery("Select UPPER(ies.no_ies) from Tab_ies ies");
			q.setMaxResults(100);
			List<Tab_ies> iezes = q.getResultList();
			for(Tab_ies ies : iezes){
				System.out.println(ies);
			}
			System.out.println("Size:" + iezes.size());
		} catch (Exception e) {
			System.out.println("Deu erro");
			e.printStackTrace();
		}
		
	}
	
	private void segundaQuery(){
		
	}
	
	private void terceiraQuery(){
		
	}
	
	private void quartaQuery(){
		
	}
	private void quintaQuery(){
		
	}


	

}
