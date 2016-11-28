package br.unb.cic.bd.dadosINEP.tabelasAuxiliares;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "tab_turno_aluno")
public class Tab_turno_aluno {
	public Tab_turno_aluno() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	private int co_turno_aluno;
	private String ds_turno_aluno;
	
	public Tab_turno_aluno(int co_turno_aluno, String ds_turno_aluno) {
		super();
		this.co_turno_aluno = co_turno_aluno;
		this.ds_turno_aluno = ds_turno_aluno;
	}
}

