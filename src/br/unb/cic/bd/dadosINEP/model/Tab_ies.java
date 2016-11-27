package br.unb.cic.bd.dadosINEP.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.unb.cic.dadosINEP.tabelasAuxiliares.Tab_categoria_administrativa;
import br.unb.cic.dadosINEP.tabelasAuxiliares.Tab_mantenedora;
import br.unb.cic.dadosINEP.tabelasAuxiliares.Tab_organizacao_academica;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "ies")

@Data
public class Tab_ies {
	@Id
	private int co_ies;
	private String no_ies;
	private Tab_mantenedora co_mantenedora;
	private Tab_categoria_administrativa co_categoria_administrativa;
	private Tab_organizacao_academica co_organizacao_academica;
	private String sgl_uf_ies;
	private int qt_tec_total;
	private int qt_tec_fund_incomp_fem;
	private int qt_tec_fund_incomp_masc;
	private int qt_tec_medio_fem;
	private int qt_tec_medio_masc;
	private int qt_tec_superior_fem;
	private int qt_tec_superior_masc;
	private int qt_tec_especializacao_fem;
	private int qt_tec_especializacao_masc;
	private int qt_tec_mestrado_fem;
	private int qt_tec_mestrado_masc;
	private int qt_tec_doutorado_fem;
	private int qt_tec_doutorado_masc;
	private int vl_receita_propria;
	private int vl_transferencia;
	private int vl_outra_receita;
	private int vl_des_pessoal_rem_docente;
	private int vl_des_pessoal_rem_tecnico;
	private int vl_des_pessoal_encargo;
	private int vl_des_custeio;
	private int vl_des_investimento;
	private int vl_des_pesquisa;
	private int vl_des_outras;
	
	public Tab_ies(int co_ies) {
		super();
		this.co_ies = co_ies;
	}
}
