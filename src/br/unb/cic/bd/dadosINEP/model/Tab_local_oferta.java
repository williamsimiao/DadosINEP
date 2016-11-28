package br.unb.cic.bd.dadosINEP.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tab_local_oferta")

@Data
public class Tab_local_oferta {
	public Tab_local_oferta() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	private int co_local_oferta_ies;
	private String no_local_oferta;
	private String sgl_uf_local;
	@ManyToOne
    @JoinColumn(name="co_ies",referencedColumnName="co_ies")
	private Tab_ies co_ies;
	
	public Tab_local_oferta(int co_local_oferta_ies) {
		super();
		this.co_local_oferta_ies = co_local_oferta_ies;
	}
}
