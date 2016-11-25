package br.unb.cic.bd.dadosINEP.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Docente {
	@Id
	//TODO: checar se é unico
	private int co_docente;
	private int co_ies;
	private int co_situacao_docente;
	private String desc_situacao_docente;
	private int co_escolaridade_docente;
	private int co_regime_trabalho;
	private int co_sexo_docente;
	private int idade_docente;
	private int co_nacionalidade_docente;
	private int in_docente_deficiencia;
	private int in_atua_pesquisa;
	private int in_bolsa_pesquisa;
	
	@Override
	public String toString() {
		return "";		
	}
}
