package br.com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.entity.AlunoDisciplina;
import br.com.empresa.entity.Avaliacao;

@Repository  //para passar que é um repositorio.
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, AlunoDisciplina>{
	
	//select * from avaliacao where id_aluno = 3 and id_disciplina = 6 --> é a mesma coisa em baixo
	Avaliacao findByAlunoDisciplina(AlunoDisciplina alunoDisciplina);
	
}
