package br.com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.entity.Turma;
import br.com.empresa.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired  
	private TurmaRepository turmaRepo; 
	
	public List<Turma> listaTodosTurma(){
		return turmaRepo.findAll(); 
		
	}
	
	public Turma buscaPorID(Integer id) throws ObjectNotFoundException{
		Optional<Turma> turma = turmaRepo.findById(id);
		return turma.orElseThrow(()-> new ObjectNotFoundException(null, "Objeto não encontrado"));
		
	}
	
	public Turma salvar(Turma turma) {
		return turmaRepo.save(turma);
	}
	
	public void excluir(Integer id) {
		turmaRepo.deleteById(id);
	}
	
	public Turma alterar(Turma objTurma) {
		Turma turma = buscaPorID(objTurma.getId());
		turma.setNome(objTurma.getNome());
		return salvar(turma);
	}
}
