package br.unb.cic.bd.dadosINEP.tabelasAuxiliares;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "tab_sexo")
public class Tab_sexo {
	public Tab_sexo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	private int in_sexo;
	private String ds_sexo;

	public Tab_sexo(int in_sexo, String ds_sexo) {
		super();
		this.in_sexo = in_sexo;
		this.ds_sexo = ds_sexo;
	}
}
