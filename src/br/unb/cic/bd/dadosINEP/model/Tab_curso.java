package br.unb.cic.bd.dadosINEP.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.unb.cic.bd.dadosINEP.tabelasAuxiliares.Tab_grau_academico;
import br.unb.cic.bd.dadosINEP.tabelasAuxiliares.Tab_modalidade_ensino;
import br.unb.cic.bd.dadosINEP.tabelasAuxiliares.Tab_nivel_academico;
import lombok.Data;

@Entity
@Table(name = "tab_curso")

@Data
public class Tab_curso {
	
	public Tab_curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	private int co_curso;
	@ManyToOne
	private Tab_ies co_ies;
	private String sgl_uf_curso;
	private String no_curso;
	private String ocde;
	@ManyToOne
	private Tab_grau_academico co_grau_acad;
	@ManyToOne
	private Tab_modalidade_ensino co_modalidade_ensino;
	@ManyToOne
	private Tab_nivel_academico co_nivel_acad;
	@ManyToOne
	private Tab_local_oferta co_local_oferta;
	private int in_gratuito;
	private int nu_carga_horaria;
	private int in_ajuda_deficiente;
	private int qt_matriculado_curso;
	private int qt_concluinte_curso;
	
	public Tab_curso(int co_curso) {
		super();
		this.co_curso = co_curso;
	}
}
