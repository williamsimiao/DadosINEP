package br.unb.cic.bd.dadosINEP.chavesPrimarias;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import br.unb.cic.bd.dadosINEP.model.Tab_ies;

public class DocentePK implements Serializable {
	
	@ManyToOne
	@Column(name = "co_docente", nullable = false)
	private int co_docente;
	
	@ManyToOne
	@Column(name = "co_ies", nullable = false)
	private Tab_ies co_ies;
	
	public DocentePK(int co_docente, Tab_ies co_ies) {
		super();
		this.co_docente = co_docente;
		this.co_ies = co_ies;
	}
}
