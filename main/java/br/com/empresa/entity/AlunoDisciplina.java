package br.com.empresa.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable   //para passar chave composta
public class AlunoDisciplina implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8225929723047775610L;


	//Nesta classe o Relacionamento é de chave extrangeira // chave composta
	
	@ManyToOne
	private Aluno aluno;
	
	
	@ManyToOne
	private Disciplina disciplina;


	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


	public Disciplina getDisciplina() {
		return disciplina;
	}


	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	
	
	
}
