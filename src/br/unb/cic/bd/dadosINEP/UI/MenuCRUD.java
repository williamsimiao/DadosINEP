package br.unb.cic.bd.dadosINEP.UI;

import java.util.Scanner;

import br.unb.cic.bd.dadosINEP.chavesPrimarias.AlunoPK;
import br.unb.cic.bd.dadosINEP.dao.AlunoDAO;
import br.unb.cic.bd.dadosINEP.model.Tab_aluno;

public class MenuCRUD {
	public MenuCRUD() {
		System.out.println("CRUD para a entidade Aluno");
		System.out.println("1-CREATE");
		System.out.println("2-READ");
		System.out.println("3-UPDATE");
		System.out.println("4-DELETE");
		
		Scanner reader = new Scanner(System.in);
		System.out.print("Escolha uma opção: ");
		int n = reader.nextInt();
		
		AlunoPK alunoPk = inputPK();
		Tab_aluno aluno = new Tab_aluno(alunoPk);
		switch (n) {
		//create
		 case 1:
			AlunoDAO.getInstance().persist(aluno);
		 	break;
		 //update
		 case 2:
			 AlunoDAO.getInstance().getByPK(alunoPk);
			 AlunoPK novaPK = inputPK();
			 aluno.setAlunoPK(novaPK);
			 AlunoDAO.getInstance().merge(aluno);
		
		 	break;
		 case 3: 
			 AlunoDAO.getInstance().removeById(aluno.getAlunoPK());
		 	break;
		 default: System.out.println("Opção Invalida");

		}
	}
	private AlunoPK inputPK(){
		System.out.println("Qual o codigo do IES");
		Scanner reader1 = new Scanner(System.in);
		int ies = reader1.nextInt();
//		reader1.close();
		System.out.println("Qual o o codigo do curso");
		Scanner reader2 = new Scanner(System.in);
		int curso = reader2.nextInt();
//		reader2.close();
		System.out.println("Qual o codigo do aluno");
		Scanner reader3 = new Scanner(System.in);
		int co_aluno = reader3.nextInt();
//		reader3.close();

		AlunoPK alunoPK = new AlunoPK(co_aluno, curso, ies);
		return alunoPK;
	}

}
