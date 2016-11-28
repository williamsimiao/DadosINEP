package br.unb.cic.bd.dadosINEP.tabelasAuxiliares;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "tab_nivel_academico")
public class Tab_nivel_academico {
	public Tab_nivel_academico() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	private int co_nivel_academico;
	private String ds_nivel_academico;
	public Tab_nivel_academico(int co_nivel_academico, String ds_nivel_academico) {
		super();
		this.co_nivel_academico = co_nivel_academico;
		this.ds_nivel_academico = ds_nivel_academico;
	}
}
