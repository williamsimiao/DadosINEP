package br.unb.cic.bd.dadosINEP.tabelasAuxiliares;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.unb.cic.bd.dadosINEP.model.Tab_curso;
import br.unb.cic.bd.dadosINEP.model.Tab_ies;
import br.unb.cic.bd.dadosINEP.model.Tab_local_oferta;
import lombok.Data;
@Entity
@Table(name = "tab_estatisticas_computacao")

@Data
public class Tab_estatisticas_computacao {
	@Id
	private long co_estatisticas_computacao;
	@OneToOne
	private int co_ies;
	private long qt_total_alunos;
	private long qt_mulheres;
	private float pc_mulheres;
	private long qt_homens;
	private float pc_homens;
	private boolean in_qt_mulheres_maior_que_homens;
	private long qt_alunos_cor_branca;
	private float pc_alunos_cor_branca;
	private long qt_alunos_cor_preta;
	private float pc_alunos_cor_preta;
	private long qt_alunos_cor_parda;
	private float pc_alunos_cor_parda;
	private long qt_alunos_cor_amarela;
	private float pc_alunos_cor_amarela;
	private long qt_alunos_indigena;
	private float pc_alunos_indigena;
	private long qt_alunos_cor_sem_info;
	private float pc_alunos_cor_sem_info;
	private long qt_alunos_cor_nao_declarada;
	private float pc_alunos_cor_nao_declarada;


	public Tab_estatisticas_computacao() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Tab_estatisticas_computacao(long co_estatisticas_computacao) {
		super();
		this.co_estatisticas_computacao = co_estatisticas_computacao;

	}

}
