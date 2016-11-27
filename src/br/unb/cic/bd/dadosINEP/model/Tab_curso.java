package br.unb.cic.bd.dadosINEP.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.unb.cic.dadosINEP.tabelasAuxiliares.Tab_grau_academico;
import br.unb.cic.dadosINEP.tabelasAuxiliares.Tab_modalidade_ensino;
import br.unb.cic.dadosINEP.tabelasAuxiliares.Tab_nivel_academico;
import lombok.Data;

@Entity
@Table(name = "curso")

@Data
public class Tab_curso {
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
	
	public Tab_curso(int co_curso, Tab_ies co_ies, String sgl_uf_curso, String no_curso, String ocde,
			Tab_grau_academico co_grau_acad, Tab_modalidade_ensino co_modalidade_ensino,
			Tab_nivel_academico co_nivel_acad, Tab_local_oferta co_local_oferta, int in_gratuito, int nu_carga_horaria,
			int in_ajuda_deficiente, int qt_matriculado_curso, int qt_concluinte_curso) {
		super();
		this.co_curso = co_curso;
		this.co_ies = co_ies;
		this.sgl_uf_curso = sgl_uf_curso;
		this.no_curso = no_curso;
		this.ocde = ocde;
		this.co_grau_acad = co_grau_acad;
		this.co_modalidade_ensino = co_modalidade_ensino;
		this.co_nivel_acad = co_nivel_acad;
		this.co_local_oferta = co_local_oferta;
		this.in_gratuito = in_gratuito;
		this.nu_carga_horaria = nu_carga_horaria;
		this.in_ajuda_deficiente = in_ajuda_deficiente;
		this.qt_matriculado_curso = qt_matriculado_curso;
		this.qt_concluinte_curso = qt_concluinte_curso;
	}
}
