package br.unb.cic.bd.dadosINEP.tabelasAuxiliares;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "tab_escolaridade_docente")
public class Tab_escolaridade_docente {
	@Id
	private int co_escolaridade_docente;
	private String ds_escolaridade_docente;
	public Tab_escolaridade_docente(int co_escolaridade_docente, String ds_escolaridade_docente) {
		super();
		this.co_escolaridade_docente = co_escolaridade_docente;
		this.ds_escolaridade_docente = ds_escolaridade_docente;
	}
}
