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
	
	public Tab_aluno(AlunoPK alunoPK, Tab_turno_aluno co_turno_aluno, Tab_cor_raca co_cor_raca_aluno,
			Tab_sexo co_sexo_aluno, int nu_idade_aluno, Tab_nacionalidade co_nacionalidade_aluno,
			Tab_aluno_situacao co_aluno_situacao, int in_aluno_def_tgd_super, int in_reserva_etnico,
			int in_reserva_deficincia, int in_reserva_ensino_publico, int in_reserva_renda_familiar,
			int in_apoio_social, int in_atividade_extracurricular, int in_bolsa_pesquisa) {
		super();
		this.alunoPK = alunoPK;
		this.co_turno_aluno = co_turno_aluno;
		this.co_cor_raca_aluno = co_cor_raca_aluno;
		this.co_sexo_aluno = co_sexo_aluno;
		this.nu_idade_aluno = nu_idade_aluno;
		this.co_nacionalidade_aluno = co_nacionalidade_aluno;
		this.co_aluno_situacao = co_aluno_situacao;
		this.in_aluno_def_tgd_super = in_aluno_def_tgd_super;
		this.in_reserva_etnico = in_reserva_etnico;
		this.in_reserva_deficincia = in_reserva_deficincia;
		this.in_reserva_ensino_publico = in_reserva_ensino_publico;
		this.in_reserva_renda_familiar = in_reserva_renda_familiar;
		this.in_apoio_social = in_apoio_social;
		this.in_atividade_extracurricular = in_atividade_extracurricular;
		this.in_bolsa_pesquisa = in_bolsa_pesquisa;
	}
	
	
}
