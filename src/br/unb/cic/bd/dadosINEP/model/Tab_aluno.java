package br.unb.cic.bd.dadosINEP.model;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.unb.cic.bd.dadosINEP.chavesPrimarias.AlunoPK;
import br.unb.cic.dadosINEP.tabelasAuxiliares.Tab_aluno_situacao;
import br.unb.cic.dadosINEP.tabelasAuxiliares.Tab_cor_raca;
import br.unb.cic.dadosINEP.tabelasAuxiliares.Tab_grau_academico;
import br.unb.cic.dadosINEP.tabelasAuxiliares.Tab_modalidade_ensino;
import br.unb.cic.dadosINEP.tabelasAuxiliares.Tab_nacionalidade;
import br.unb.cic.dadosINEP.tabelasAuxiliares.Tab_sexo;
import br.unb.cic.dadosINEP.tabelasAuxiliares.Tab_turno_aluno;
import lombok.Data;

@Entity
@Data
@Table(name = "aluno")
public class Tab_aluno {
	@EmbeddedId
	//as tres chaves PKs estao nessa classe
	private AlunoPK alunoPK;
	@ManyToOne
	private Tab_turno_aluno co_turno_aluno;
	@ManyToOne
	private Tab_cor_raca co_cor_raca_aluno;
	@ManyToOne
	private Tab_sexo co_sexo_aluno;
	private int nu_idade_aluno;
	@ManyToOne
	private Tab_nacionalidade co_nacionalidade_aluno;
	@ManyToOne
	private Tab_aluno_situacao co_aluno_situacao;
	private int in_aluno_def_tgd_super;
	private int in_reserva_etnico;
	private int in_reserva_deficincia;
	private int in_reserva_ensino_publico;
	private int in_reserva_renda_familiar;
	private int in_apoio_social;
	private int in_atividade_extracurricular;
	private int in_bolsa_pesquisa;
	
	public Tab_aluno(AlunoPK alunoPK) {
		super();
		this.alunoPK = alunoPK;
	}
	
	
}
