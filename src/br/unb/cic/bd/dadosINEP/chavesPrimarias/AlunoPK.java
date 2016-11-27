package br.unb.cic.bd.dadosINEP.chavesPrimarias;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import br.unb.cic.bd.dadosINEP.model.Tab_curso;
import br.unb.cic.bd.dadosINEP.model.Tab_ies;

@Embeddable
public class AlunoPK implements Serializable {
	
	@Column(name = "co_aluno", nullable = false)
	private int co_aluno;
	
	@Column(name = "co_curso", nullable = false)
	private int co_curso;
	
	@Column(name = "co_ies", nullable = false)
	private int co_ies;

	public AlunoPK(int co_aluno, int co_curso, int co_ies) {
		super();
		this.co_aluno = co_aluno;
		this.co_curso = co_curso;
		this.co_ies = co_ies;
	}
}
