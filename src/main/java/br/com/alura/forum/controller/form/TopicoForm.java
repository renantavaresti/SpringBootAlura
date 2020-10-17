package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.respository.CursoRepository;

//vou definir quais campos vaochegar do cliente
public class TopicoForm {

	@NotNull
	@Size(min = 5)
	private String titulo;
	@NotNull
	private String mensagem;
	@NotNull
	private String nomeCurso; // para nao trabalhar com o objeto, vou buscar o nomeCurso no banco de dados

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensage() {
		return mensagem;
	}

	public void setMensage(String mensage) {
		this.mensagem = mensage;
	}

	public String getNomeCruso() {
		return nomeCurso;
	}

	public void setNomeCruso(String nomeCruso) {
		this.nomeCurso = nomeCruso;
	}

	public Topico converter(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(nomeCurso);
		return new Topico(titulo, mensagem, curso);
	}

}