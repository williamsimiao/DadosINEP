package br.unb.cic.bd.dadosINEP.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.unb.cic.bd.dadosINEP.chavesPrimarias.DocentePK;
import br.unb.cic.dadosINEP.tabelasAuxiliares.Tab_cor_raca;
import br.unb.cic.dadosINEP.tabelasAuxiliares.Tab_escolaridade_docente;
import br.unb.cic.dadosINEP.tabelasAuxiliares.Tab_nacionalidade;
import br.unb.cic.dadosINEP.tabelasAuxiliares.Tab_regime_trabalho;
import br.unb.cic.dadosINEP.tabelasAuxiliares.Tab_sexo;
import br.unb.cic.dadosINEP.tabelasAuxiliares.Tab_situacao_docente;
import lombok.Data;

@Entity
@Table(name = "docente")

@Data
public class Tab_docente {
	@EmbeddedId
	private DocentePK docentePK;
	@ManyToOne
	private Tab_situacao_docente co_situacao_docente;
	@ManyToOne
	private Tab_escolaridade_docente co_escolaridade_docente;
	@ManyToOne
	private Tab_regime_trabalho co_regime_trabalho;
	@ManyToOne
	private Tab_sexo co_sexo_docente;
	@ManyToOne
	private Tab_cor_raca co_cor_raca;
	@ManyToOne
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
}
