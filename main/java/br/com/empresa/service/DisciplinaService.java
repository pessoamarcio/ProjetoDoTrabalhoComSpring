package br.com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.entity.Disciplina;
import br.com.empresa.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired  
	private DisciplinaRepository disciplinaRepo; 
	
	public List<Disciplina> listaTodosDisciplina(){
		return disciplinaRepo.findAll(); 
		
	}
	
	public Disciplina buscaPorID(Integer id) throws ObjectNotFoundException{
		Optional<Disciplina> disciplina = disciplinaRepo.findById(id);
		return disciplina.orElseThrow(()-> new ObjectNotFoundException(null, "Objeto não encontrado"));
	}
	
	public Disciplina salvar(Disciplina disciplina) {
		return disciplinaRepo.save(disciplina);
	}
	
	public void excluir(Integer id) {
		disciplinaRepo.deleteById(id);
	}
	
	public Disciplina alterar(Disciplina objDisciplina) {
		Disciplina disciplina = buscaPorID(objDisciplina.getId());
		disciplina.setNome(objDisciplina.getNome());
		return salvar(disciplina);
	}
}
