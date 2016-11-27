package br.unb.cic.bd.dadosINEP.model;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
    @JoinColumn(name = "co_ies", referencedColumnName = "co_ies")
	Tab_ies ies;
	//
	@ManyToOne
    @JoinColumn(name = "co_curso", referencedColumnName = "co_curso")
	Tab_curso curso;
	
	@Column(name = "co_turno_aluno")
	private int co_turno_aluno;
	@ManyToOne
    @JoinColumn(name="co_turno_aluno",referencedColumnName="co_turno_aluno")
	private Tab_turno_aluno turno_aluno;
	//
	@Column(name = "co_cor_raca_aluno")
	private int co_cor_raca_aluno;
	@ManyToOne
    @JoinColumn(name="co_cor_raca_aluno",referencedColumnName="co_cor_raca")
	private Tab_cor_raca cor_raca_aluno;
	//
	@Column(name = "co_sexo_aluno")
	private int co_sexo_aluno;
	
	@ManyToOne
    @JoinColumn(name="in_sexo_aluno",referencedColumnName="in_sexo")
	private Tab_sexo sexo_aluno;
	//
	private int nu_idade_aluno;
	//
	@Column(name = "co_nacionalidade_aluno")
	private int co_nacionalidade_aluno;
	@ManyToOne
    @JoinColumn(name="co_nacionalidade_aluno",referencedColumnName="co_nacionalidade")
	private Tab_nacionalidade nacionalidade_aluno;
	//
	@Column(name = "co_aluno_situacao")
	private int co_aluno_situacao;
	@ManyToOne
    @JoinColumn(name="co_aluno_situacao",referencedColumnName="co_aluno_situacao")
	private Tab_aluno_situacao aluno_situacao;
	//
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
