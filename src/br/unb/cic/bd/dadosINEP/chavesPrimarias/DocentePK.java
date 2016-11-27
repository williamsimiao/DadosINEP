package br.unb.cic.bd.dadosINEP.chavesPrimarias;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import br.unb.cic.bd.dadosINEP.model.Tab_ies;
@Embeddable
public class DocentePK implements Serializable {
	
	
	@Column(name = "co_docente", nullable = false)
	private int co_docente;
	
	
	@Column(name = "co_ies", nullable = false)
	private int co_ies;
	
	public DocentePK(int co_docente, int co_ies) {
		super();
		this.co_docente = co_docente;
		this.co_ies = co_ies;
	}
}
