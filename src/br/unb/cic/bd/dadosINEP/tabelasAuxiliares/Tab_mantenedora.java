package br.unb.cic.bd.dadosINEP.tabelasAuxiliares;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "tab_mantenedora")
public class Tab_mantenedora {
	@Id
	private int co_mantenedora;
	private String no_mantenedora;
	public Tab_mantenedora(int co_mantenedora, String no_mantenedora) {
		super();
		this.co_mantenedora = co_mantenedora;
		this.no_mantenedora = no_mantenedora;
	}

}
