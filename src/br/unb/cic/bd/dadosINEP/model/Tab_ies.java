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
	
	public Tab_ies(int co_ies, String no_ies, Tab_mantenedora co_mantenedora,
			Tab_categoria_administrativa co_categoria_administrativa,
			Tab_organizacao_academica co_organizacao_academica, String sgl_uf_ies, int qt_tec_total,
			int qt_tec_fund_incomp_fem, int qt_tec_fund_incomp_masc, int qt_tec_medio_fem, int qt_tec_medio_masc,
			int qt_tec_superior_fem, int qt_tec_superior_masc, int qt_tec_especializacao_fem,
			int qt_tec_especializacao_masc, int qt_tec_mestrado_fem, int qt_tec_mestrado_masc, int qt_tec_doutorado_fem,
			int qt_tec_doutorado_masc, int vl_receita_propria, int vl_transferencia, int vl_outra_receita,
			int vl_des_pessoal_rem_docente, int vl_des_pessoal_rem_tecnico, int vl_des_pessoal_encargo,
			int vl_des_custeio, int vl_des_investimento, int vl_des_pesquisa, int vl_des_outras) {
		super();
		this.co_ies = co_ies;
		this.no_ies = no_ies;
		this.co_mantenedora = co_mantenedora;
		this.co_categoria_administrativa = co_categoria_administrativa;
		this.co_organizacao_academica = co_organizacao_academica;
		this.sgl_uf_ies = sgl_uf_ies;
		this.qt_tec_total = qt_tec_total;
		this.qt_tec_fund_incomp_fem = qt_tec_fund_incomp_fem;
		this.qt_tec_fund_incomp_masc = qt_tec_fund_incomp_masc;
		this.qt_tec_medio_fem = qt_tec_medio_fem;
		this.qt_tec_medio_masc = qt_tec_medio_masc;
		this.qt_tec_superior_fem = qt_tec_superior_fem;
		this.qt_tec_superior_masc = qt_tec_superior_masc;
		this.qt_tec_especializacao_fem = qt_tec_especializacao_fem;
		this.qt_tec_especializacao_masc = qt_tec_especializacao_masc;
		this.qt_tec_mestrado_fem = qt_tec_mestrado_fem;
		this.qt_tec_mestrado_masc = qt_tec_mestrado_masc;
		this.qt_tec_doutorado_fem = qt_tec_doutorado_fem;
		this.qt_tec_doutorado_masc = qt_tec_doutorado_masc;
		this.vl_receita_propria = vl_receita_propria;
		this.vl_transferencia = vl_transferencia;
		this.vl_outra_receita = vl_outra_receita;
		this.vl_des_pessoal_rem_docente = vl_des_pessoal_rem_docente;
		this.vl_des_pessoal_rem_tecnico = vl_des_pessoal_rem_tecnico;
		this.vl_des_pessoal_encargo = vl_des_pessoal_encargo;
		this.vl_des_custeio = vl_des_custeio;
		this.vl_des_investimento = vl_des_investimento;
		this.vl_des_pesquisa = vl_des_pesquisa;
		this.vl_des_outras = vl_des_outras;
	}
}
