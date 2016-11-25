package br.unb.cic.bd.dadosINEP.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//notation da jpa
@Entity
@Table(name = "aluno")
//para evitar escrever getters e setters
@Data
public class Aluno {
	@Id
	private int co_aluno;
	private int co_ies;
	private int co_curso;
	private int co_turno_aluno;
	private int co_grau_acad;
	private int co_modalidade_ensino;
	private int co_nivel_acad;
	private int co_cor_raca_aluno;
	private int co_sexo_aluno;
	private int idade_aluno;
	private int co_nacionalidade_aluno;
	private int co_aluno_situacao;
	private int in_aluno_def_tgd_super;
	private int in_reserva_etnico;
	private int in_reserva_deficincia;
	private int in_reserva_ensino_publico;
	private int in_reserva_renda_familiar;
	private int in_apoio_social;
	private int in_atividade_extracurricular;
	private int in_bolsa_pesquisa;

	@Override
	public String toString() {
		return "";		
	}
	
	

}
