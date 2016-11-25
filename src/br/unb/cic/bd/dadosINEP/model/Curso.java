package br.unb.cic.bd.dadosINEP.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Curso {
	@Id
	private int co_curso;
	private int co_ies;
	private String sgl_uf_curso;
	private String nome_curso;
	private String ocdf;
	private int co_grau_acad;
	private int co_modalidade_ensino;
	private int co_nivel_acad;
	private int co_local_oferta;
	private int in_gratuito;
	private int in_ajuda_deficiente;
	private int qt_matriculado_curso;
	private int qt_concluinte_curso;
	
	@Override
	public String toString() {
		return "";		
	}

	
	
	
	
}
