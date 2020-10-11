package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.respository.TopicoRepository;

@RestController
public class TopicosController {
	
	@Autowired 	
	private TopicoRepository topicoRepository;
	
	//Temos que ter um método mapeando o endereço
	//A lógica nesse trecho seria carregar a lista com todos os tópicos e devolver ela pra quem fez a chamada.
	@RequestMapping("/topicos")
	public List<TopicoDto> lista(String nomeCurso) {
		if(nomeCurso == null) {
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDto.converter(topicos);
				
		} else {
			List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
			return TopicoDto.converter(topicos);
		}
		}
		

}
