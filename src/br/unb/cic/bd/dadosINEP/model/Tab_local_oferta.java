package br.unb.cic.bd.dadosINEP.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "local_oferta")

@Data
public class Tab_local_oferta {
	@Id
	private int co_local_oferta_ies;
	private String no_local_oferta;
	private String sgl_uf_local;
	@ManyToOne
	private Tab_ies co_ies;
	
	public Tab_local_oferta(int co_local_oferta_ies, String no_local_oferta, String sgl_uf_local, Tab_ies co_ies) {
		super();
		this.co_local_oferta_ies = co_local_oferta_ies;
		this.no_local_oferta = no_local_oferta;
		this.sgl_uf_local = sgl_uf_local;
		this.co_ies = co_ies;
	}
}
