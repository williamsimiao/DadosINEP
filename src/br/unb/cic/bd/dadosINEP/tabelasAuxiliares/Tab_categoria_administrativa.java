package br.unb.cic.bd.dadosINEP.tabelasAuxiliares;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tab_categoria_administrativa")
public class Tab_categoria_administrativa {
	public Tab_categoria_administrativa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	private int co_categoria_administrativa;
	private String ds_categoria_administrativa;
	
	public Tab_categoria_administrativa(int co_categoria_administrativa, String ds_categoria_administrativa) {
		super();
		this.co_categoria_administrativa = co_categoria_administrativa;
		this.ds_categoria_administrativa = ds_categoria_administrativa;
	}
}
