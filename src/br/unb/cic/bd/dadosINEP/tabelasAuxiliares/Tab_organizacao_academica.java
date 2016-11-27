package br.unb.cic.bd.dadosINEP.tabelasAuxiliares;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "tab_organizacao_academica")
public class Tab_organizacao_academica {
	@Id
	private int co_organizacao_academica;
	private String ds_organizacao_academica;
	public Tab_organizacao_academica(int co_organizacao_academica, String ds_organizacao_academica) {
		super();
		this.co_organizacao_academica = co_organizacao_academica;
		this.ds_organizacao_academica = ds_organizacao_academica;
	}
}
