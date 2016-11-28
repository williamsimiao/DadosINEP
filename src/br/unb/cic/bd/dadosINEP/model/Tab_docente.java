package br.unb.cic.bd.dadosINEP.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.unb.cic.bd.dadosINEP.chavesPrimarias.DocentePK;
import br.unb.cic.bd.dadosINEP.tabelasAuxiliares.Tab_cor_raca;
import br.unb.cic.bd.dadosINEP.tabelasAuxiliares.Tab_escolaridade_docente;
import br.unb.cic.bd.dadosINEP.tabelasAuxiliares.Tab_nacionalidade;
import br.unb.cic.bd.dadosINEP.tabelasAuxiliares.Tab_regime_trabalho;
import br.unb.cic.bd.dadosINEP.tabelasAuxiliares.Tab_sexo;
import br.unb.cic.bd.dadosINEP.tabelasAuxiliares.Tab_situacao_docente;
import lombok.Data;

@Entity
@Table(name = "tab_docente")

@Data
public class Tab_docente {
	@EmbeddedId
	private DocentePK docentePK;
	
	@ManyToOne
    @PrimaryKeyJoinColumn(name = "co_ies", referencedColumnName = "co_ies")
	Tab_ies ies;
	//
	
	@ManyToOne
    @PrimaryKeyJoinColumn(name="co_situacao_docente",referencedColumnName="co_situacao_docente")
	private Tab_situacao_docente co_situacao_docente;
	@ManyToOne
    @PrimaryKeyJoinColumn(name="co_escolaridade_docente",referencedColumnName="co_escolaridade_docente")
	private Tab_escolaridade_docente co_escolaridade_docente;
	@ManyToOne
    @PrimaryKeyJoinColumn(name="co_regime_trabalho",referencedColumnName="co_regime_trabalho")
	private Tab_regime_trabalho co_regime_trabalho;
	@ManyToOne
    @PrimaryKeyJoinColumn(name="in_sexo_docente",referencedColumnName="in_sexo")
	private Tab_sexo sexo_docente;
	@ManyToOne
    @PrimaryKeyJoinColumn(name="co_cor_raca_docente",referencedColumnName="co_cor_raca")
	private Tab_cor_raca co_cor_raca_docente;
	@ManyToOne
    @PrimaryKeyJoinColumn(name="co_nacionalidade_docente",referencedColumnName="co_nacionalidade")
	private Tab_nacionalidade co_nacionalidade_docente;
	private int nu_idade_docente;
	private int in_docente_deficiencia;
	private int in_atu_extensao;
	private int in_atua_pesquisa;
	private int in_bolsa_pesquisa;
	
	public Tab_docente(DocentePK docentePK) {
		super();
		this.docentePK = docentePK;
	}

	public Tab_docente() {
		super();
		// TODO Auto-generated constructor stub
	}
}
