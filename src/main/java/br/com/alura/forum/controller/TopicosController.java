package br.com.alura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;

@RestController
public class TopicosController {
	//Temos que ter um método mapeando o endereço
	
	//*A lógica nesse trecho seria carregar a lista com todos os tópicos e devolver ela pra quem fez a chamada.
	@RequestMapping("/topicos")
	public List<Topico> lista(){
		Topico topico = new Topico("Duvida", "Duvida com Spring", new Curso("Spring", "Programação"));
		
		return Arrays.asList(topico, topico, topico);
	}

}
