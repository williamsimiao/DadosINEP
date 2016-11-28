package br.unb.cic.bd.dadosINEP.UI;

import java.util.Scanner;

import br.unb.cic.bd.dadosINEP.chavesPrimarias.AlunoPK;
import br.unb.cic.bd.dadosINEP.dao.AlunoDAO;
import br.unb.cic.bd.dadosINEP.dao.CursoDAO;
import br.unb.cic.bd.dadosINEP.dao.IesDAO;
import br.unb.cic.bd.dadosINEP.model.Tab_aluno;
import br.unb.cic.bd.dadosINEP.model.Tab_curso;
import br.unb.cic.bd.dadosINEP.model.Tab_ies;
import br.unb.cic.bd.dadosINEP.tabelasAuxiliares.Tab_estatisticas_computacao;
import br.unb.cic.bd.dadosINEP.tabelasAuxiliares.Tab_modalidade_ensino;

public class Main {

	public static void main(String[] args) {
		System.out.println("Deseja fazer o CRUD (1) ou visualizar(2)");
		Scanner reader = new Scanner(System.in);
		int opcao = reader.nextInt();
		switch (opcao) {
		case 1:
			new MenuCRUD();
			break;
		case 2:
			new Menu();
			break;

		default:
			break;
		}



	
	}

}
