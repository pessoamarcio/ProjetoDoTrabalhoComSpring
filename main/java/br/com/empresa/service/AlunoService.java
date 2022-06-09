package br.com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.entity.Aluno;
import br.com.empresa.repository.AlunoRepository;


@Service
public class AlunoService {

	@Autowired  //imoporta ele. Faz chamar o alunoRepo sem precisar de funçao.
	private AlunoRepository alunoRepo; //alunorepo é uma variavel.
	
	//criou uma lista e tipo como Aluno
	public List<Aluno> listaTodosAlunos(){
		return alunoRepo.findAll(); //para listar todos alunos.
		
	}
	
	public Aluno buscaPorID(Integer id) throws ObjectNotFoundException{
		Optional<Aluno> aluno = alunoRepo.findById(id);
		return aluno.orElseThrow(()-> new ObjectNotFoundException(null, "Objeto não encontrado"));
		//se não localizar o objeto retorna a frase a cima, se encontrar retorna aluno.
	}
	
	public Aluno salvar(Aluno aluno) {
		return alunoRepo.save(aluno);
	}
	
	public void excluir(Integer id) {
		alunoRepo.deleteById(id);
	}
	
	public Aluno alterar(Aluno objAluno) {
		Aluno aluno = buscaPorID(objAluno.getId());
		aluno.setNome(objAluno.getNome());
		aluno.setTurma(objAluno.getTurma());
		aluno.setDisciplina(objAluno.getDisciplina());
		return salvar(aluno);
	}
	
	
}
