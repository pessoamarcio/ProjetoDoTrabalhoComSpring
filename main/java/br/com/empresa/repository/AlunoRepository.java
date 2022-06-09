package br.com.empresa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{ 
	//acima o repository foi incluso uma extensão para fazer persistencia no nome do Aluno e no Id(primay key).
	//Lembrando que o Integer é o id
	
}
