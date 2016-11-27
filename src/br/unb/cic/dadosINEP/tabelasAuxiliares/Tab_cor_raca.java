package br.unb.cic.dadosINEP.tabelasAuxiliares;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "tab_cor_raca")
public class Tab_cor_raca {
	@Id
	private int co_cor_raca;
	private String ds_cor_raca;
	
	public Tab_cor_raca(int co_cor_raca, String ds_cor_raca) {
		super();
		this.co_cor_raca = co_cor_raca;
		this.ds_cor_raca = ds_cor_raca;
	}
}
