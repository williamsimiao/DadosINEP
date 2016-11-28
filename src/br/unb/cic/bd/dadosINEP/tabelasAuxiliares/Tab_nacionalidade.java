package br.unb.cic.bd.dadosINEP.tabelasAuxiliares;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "tab_nacionalidade")
public class Tab_nacionalidade {
	public Tab_nacionalidade() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	private int co_nacionalidade;
	private String ds_nacionalidade;
	
	public Tab_nacionalidade(int co_nacionalidade, String ds_nacionalidade) {
		super();
		this.co_nacionalidade = co_nacionalidade;
		this.ds_nacionalidade = ds_nacionalidade;
	}
}
