package br.unb.cic.bd.dadosINEP.tabelasAuxiliares;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "tab_regime_trabalho")
public class Tab_regime_trabalho {
	@Id
	private int co_regime_trabalho;
	private String ds_regime_trabalho;
	
	public Tab_regime_trabalho(int co_regime_trabalho, String ds_regime_trabalho) {
		super();
		this.co_regime_trabalho = co_regime_trabalho;
		this.ds_regime_trabalho = ds_regime_trabalho;
	}
}
