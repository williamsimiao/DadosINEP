package br.unb.cic.bd.dadosINEP.tabelasAuxiliares;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "tab_modalidade_ensino")
public class Tab_modalidade_ensino {
	public Tab_modalidade_ensino() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	private int co_modalidade_ensino;
	private String ds_modalidade_ensino;
	public Tab_modalidade_ensino(int co_modalidade_ensino, String ds_modalidade_ensino) {
		super();
		this.co_modalidade_ensino = co_modalidade_ensino;
		this.ds_modalidade_ensino = ds_modalidade_ensino;
	}
}
