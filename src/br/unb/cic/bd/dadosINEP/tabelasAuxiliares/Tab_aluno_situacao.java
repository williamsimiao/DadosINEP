package br.unb.cic.bd.dadosINEP.tabelasAuxiliares;

import java.security.spec.DSAGenParameterSpec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tab_aluno_situacao")
public class Tab_aluno_situacao {
	@Id
	private int co_aluno_situacao;
	private String ds_aluno_situacao;
	
	public Tab_aluno_situacao(int co_aluno_situacao, String ds_aluno_situacao) {
		super();
		this.co_aluno_situacao = co_aluno_situacao;
		this.ds_aluno_situacao = ds_aluno_situacao;
	}
}
