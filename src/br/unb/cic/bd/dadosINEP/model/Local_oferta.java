package br.unb.cic.bd.dadosINEP.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Local_oferta {
	@Id
	private int co_local_oferta;
	private String nome_local_oferta;
	private int co_uf_local_oferta;
	private int co_curso;
	
	@Override
	public String toString() {
		return "";		
	}
}
