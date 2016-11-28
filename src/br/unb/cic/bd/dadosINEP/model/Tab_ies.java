package br.unb.cic.bd.dadosINEP.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.unb.cic.bd.dadosINEP.tabelasAuxiliares.Tab_categoria_administrativa;
import br.unb.cic.bd.dadosINEP.tabelasAuxiliares.Tab_mantenedora;
import br.unb.cic.bd.dadosINEP.tabelasAuxiliares.Tab_organizacao_academica;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "tab_ies")

@Data
public class Tab_ies {
	public Tab_ies() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	private int co_ies;
	private String no_ies;
	@ManyToOne
    @JoinColumn(name="co_mantenedora",referencedColumnName="co_mantenedora")
	private Tab_mantenedora co_mantenedora;
	@ManyToOne
    @JoinColumn(name="co_categoria_administrativa",referencedColumnName="co_categoria_administrativa")
	private Tab_categoria_administrativa co_categoria_administrativa;
	@ManyToOne
    @JoinColumn(name="co_organizacao_academica",referencedColumnName="co_organizacao_academica")
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
	@Column(columnDefinition = "text")
	private String vl_receita_propria;
	@Column(columnDefinition = "text")
	private String vl_transferencia;
	@Column(columnDefinition = "text")
	private String vl_outra_receita;
	@Column(columnDefinition = "text")
	private String vl_des_pessoal_rem_docente;
	@Column(columnDefinition = "text")
	private String vl_des_pessoal_rem_tecnico;
	@Column(columnDefinition = "text")
	private String vl_des_pessoal_encargo;
	@Column(columnDefinition = "text")
	private String vl_des_custeio;
	@Column(columnDefinition = "text")
	private String vl_des_investimento;
	@Column(columnDefinition = "money")
	private String vl_des_pesquisa;
	@Column(columnDefinition = "text")
	private String vl_des_outras;
	
	public Tab_ies(int co_ies) {
		super();
		this.co_ies = co_ies;
	}
}
