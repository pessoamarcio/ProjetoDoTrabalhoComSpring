package br.com.empresa.inicializacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.empresa.entity.Aluno;
import br.com.empresa.entity.AlunoDisciplina;
import br.com.empresa.entity.Avaliacao;
import br.com.empresa.entity.Disciplina;
import br.com.empresa.entity.Turma;
import br.com.empresa.repository.AlunoRepository;
import br.com.empresa.repository.AvaliacaoRepository;
import br.com.empresa.repository.DisciplinaRepository;
import br.com.empresa.service.AvaliacaoService;
import br.com.empresa.service.DisciplinaService;
import br.com.empresa.service.TurmaService;

//Está classe é para testes e verificação antes de entregar o projeto.

@Component
//necessario para realizar implementos na inicializacao e alteração no contexto da aplicacao
public class inicio implements ApplicationListener<ContextRefreshedEvent>{ 
	
	@Autowired
	AlunoRepository alunoRepo;  //Exportar
	
	@Autowired
	 TurmaService turmaService;  //Exportar
	
	@Autowired
	DisciplinaService disciplinaService;  //Exportar
	
	@Autowired
	AvaliacaoService avaliacaoService;
	
	
	//obrigatoriamente quando implementar a interface Application tem que escrever o 
	//metodo onApplication. Esse metodo vai ser mostrado quando a aplicação levantar.
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Lucas");
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Marcos");
	
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Alice");
		
		Aluno aluno4 = new Aluno();
		aluno4.setNome("Fernando");
		
		
		Disciplina logica = new Disciplina();
		logica.setNome("Logica");
		disciplinaService.salvar(logica);
		
		Disciplina engenharia = new Disciplina();
		engenharia.setNome("Engenharia");
		disciplinaService.salvar(engenharia);
		
		Disciplina ccomputacao = new Disciplina();
		ccomputacao.setNome("CComputacao");
		disciplinaService.salvar(ccomputacao);
		
		Disciplina arquitetura = new Disciplina();
		arquitetura.setNome("Arquitetura");
		disciplinaService.salvar(arquitetura);
		

		//para salvar metodo 2
//		alunoRepo.saveAll(Arrays.asList(aluno1, aluno2, aluno3, aluno4));
		
		Turma ads = new Turma();
		ads.setNome("ADS");
		turmaService.salvar(ads);
		
		Turma java = new Turma();
		java.setNome("JAVA");
		turmaService.salvar(java);
		
		Turma javascript = new Turma();
		javascript.setNome("JavaScript");
		turmaService.salvar(javascript);
		
		
		aluno1.setTurma(ads);
		aluno2.setTurma(java);
		aluno3.setTurma(javascript);
		aluno4.setTurma(javascript);
		
		aluno1.setDisciplina(Arrays.asList(logica, engenharia, ccomputacao, arquitetura));
		aluno2.setDisciplina(Arrays.asList(logica, engenharia, ccomputacao));
		aluno3.setDisciplina(Arrays.asList(logica, ccomputacao, arquitetura));
		aluno4.setDisciplina(Arrays.asList(logica, ccomputacao));
		
		//para salvar metodo 1
		//Aluno desceu para a uma turma
		alunoRepo.save(aluno1);
		alunoRepo.save(aluno2);		
		alunoRepo.save(aluno3);
		alunoRepo.save(aluno4);
		
		
		AlunoDisciplina alunoDisciplina = new AlunoDisciplina();
		alunoDisciplina.setAluno(aluno1);
		alunoDisciplina.setDisciplina(arquitetura);
		
		Avaliacao avaliacaoAluno1 = new Avaliacao();
		avaliacaoAluno1.setAlunoDisciplina(alunoDisciplina);
		avaliacaoAluno1.setConceito("A");
		avaliacaoService.save(avaliacaoAluno1);
		
		AlunoDisciplina alunoDisciplina3 = new AlunoDisciplina();
		alunoDisciplina3.setAluno(aluno3);
		alunoDisciplina3.setDisciplina(ccomputacao);
		
		Avaliacao avaliacaoAluno3 = new Avaliacao();
		avaliacaoAluno3.setAlunoDisciplina(alunoDisciplina3);
		avaliacaoAluno3.setConceito("B");
		avaliacaoService.save(avaliacaoAluno3);
		
		//para testar no console
		Avaliacao aval = avaliacaoService.buscarNotaAlunoDisciplina(alunoDisciplina);
		System.out.println("Aluno: " + aval.getAlunoDisciplina().getAluno().getNome());
		System.out.println("Disciplina: " + aval.getAlunoDisciplina().getDisciplina().getNome());
		System.out.println("Avaliacao: " + aval.getConceito());
		
	}

	
}
