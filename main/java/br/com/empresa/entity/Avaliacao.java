package br.com.empresa.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "avaliacao")  //caso queira trocar o nome
public class Avaliacao implements Serializable{  /**
	 * 
	 */
	private static final long serialVersionUID = 4420697889536342298L;

//é como se tivesse colocando o idAluno e idDisciplina em Avaliacao

	@EmbeddedId
	private AlunoDisciplina alunoDisciplina; 
	
	private String conceito; //O conceito é como se fosse a media do aluno. 

	//Depois faz os Gatters and Setters
	
	public AlunoDisciplina getAlunoDisciplina() {
		return alunoDisciplina;
	}

	public void setAlunoDisciplina(AlunoDisciplina alunoDisciplina) {
		this.alunoDisciplina = alunoDisciplina;
	}

	public String getConceito() {
		return conceito;
	}

	public void setConceito(String conceito) {
		this.conceito = conceito;
	}
	
	
	
}
