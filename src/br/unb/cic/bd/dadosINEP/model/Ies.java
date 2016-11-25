package br.unb.cic.bd.dadosINEP.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Ies {
	@Id
	private int co_ies;
	private String nome_ies;
	private int co_mant;
	private String nome_mant;
	private int co_cat_adm;
	private int co_org_acad;
	private String sgl_uf_ies;
	private int qt_tec_adm;
	private int vl_receita_propria;
	private int vl_des_pesquisa;
	
	@Override
	public String toString() {
		return "";		
	}

}
