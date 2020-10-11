package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.respository.CursoRepository;
import br.com.alura.forum.respository.TopicoRepository;

@RestController
@RequestMapping("/topicos") //Incluindo antes da classe, toda vez q tiver uma chamada para topica, vai cair aqui.
public class TopicosController {
	
	@Autowired 	
	private TopicoRepository topicoRepository;
	
	@Autowired 	
	private CursoRepository cursoRepository;

	
	//A lógica nesse trecho seria carregar a lista com todos os tópicos e devolver ela pra quem fez a chamada.
	//temos que utilizar a notacao abaixo para sinalizar que é um GET
	@GetMapping
	public List<TopicoDto> lista(String nomeCurso) {
		if(nomeCurso == null) {
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDto.converter(topicos);
				
		} else {
			List<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso);
			return TopicoDto.converter(topicos);
		}
		}
		
	@PostMapping
	public void cadastras(@RequestBody TopicoForm form) { //RequestBody Spring, esse parametro é para vc pegar no corpo da requisicao e nao na URL
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
	}
	

}
