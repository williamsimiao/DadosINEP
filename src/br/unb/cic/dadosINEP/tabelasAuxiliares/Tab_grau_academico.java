package br.unb.cic.dadosINEP.tabelasAuxiliares;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "tab_grau_academico")
public class Tab_grau_academico {
	@Id
	private int co_grau_academico;
	private String ds_grau_academico;
	public Tab_grau_academico(int co_grau_academico, String ds_grau_academico) {
		super();
		this.co_grau_academico = co_grau_academico;
		this.ds_grau_academico = ds_grau_academico;
	}
}
