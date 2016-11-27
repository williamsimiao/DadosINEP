package br.unb.cic.bd.dadosINEP.tabelasAuxiliares;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "tab_situacao_docente")
public class Tab_situacao_docente {
	@Id
	private int co_situacao_docente;
	private String ds_situacao_docente;
	
	public Tab_situacao_docente(int co_situacao_docente, String ds_situacao_docente) {
		super();
		this.co_situacao_docente = co_situacao_docente;
		this.ds_situacao_docente = ds_situacao_docente;
	}
}
