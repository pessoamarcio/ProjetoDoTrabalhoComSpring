package br.com.empresa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Columns;

@Entity //Depois importa ela 
public class Aluno {

	@Id   //importar também.
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //para geração de valores
	private Integer id;   //criar uma chave primaria
	
	private String nome;
	//agora gerar o getters and setters

	@ManyToOne   //Fazendo relacionamento com Turma N:1
	@JoinColumn(name = "id_turma") //Depois faz getters and setters
	private Turma turma;
	
	@ManyToMany
	//criou uma tabela matricula onde a coluna irá ser o id_aluno
	@JoinTable(name = "matricula", joinColumns = {@JoinColumn(name = "id_aluno")},
	inverseJoinColumns = {@JoinColumn(name = "id_disciplina")})
	private List<Disciplina> disciplina; 
	//Depois getters and setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Disciplina> getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(List<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}
	
	
}
