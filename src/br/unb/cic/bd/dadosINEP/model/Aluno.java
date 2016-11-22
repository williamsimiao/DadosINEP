package br.unb.cic.bd.dadosINEP.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import br.unb.cic.bd.dadosINEP.util.alunoUtil;

//notation da jpa
@Entity
@Table(name = "aluno")
//para evitar escrever getters e setters
@Data
public class Aluno {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	//Olhar Filtros Censo Ed Superior 2013.pdf para detalhes
	private Long id;
	private Integer categoria_administrativa;
	private Integer organizacao_academica;
	private Integer nivel_academico;
	private Integer grau_academico;
	private Integer modalidades_de_ensino;
	private Integer sexo_do_aluno;
	private Integer raca_do_aluno;
	
	@Override
	public String toString() {
		
		alunoUtil util = new alunoUtil();
		return "aluno [Categoria administrativa=" + util.categoria_administrativaUtil(categoria_administrativa) + ", "
				+ "Organização acadêmica=" + util.organizacao_academicaUtil(organizacao_academica)
				+ "Nível acadêmico=" + util.nivel_academicoUtil(nivel_academico)
				+ "Grau acadêmico=" + util.grau_academicoUtil(grau_academico)
				+ "Modalidade de Ensino=" + util.modalidades_de_ensinoUtil(modalidades_de_ensino)
				+ "Sexo do aluno(a)=" + util.sexo_do_alunoUtil(sexo_do_aluno)
				+ "Cor/Raça do aluno(a)=" + util.raca_do_alunoUtil(raca_do_aluno)
                + "]";
	}
	
	

}
