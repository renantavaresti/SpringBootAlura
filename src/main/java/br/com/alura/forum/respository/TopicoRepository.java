package br.com.alura.forum.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Topico;

//por ser uma interface nao precisa colocar nenhuma anotacao pois o spring ja encontra automaticamente
// essa interface eu precisa herdar ela de alguma interface... no caso JPARepository
// JpaRespository tem o generics onde tenho q passar a entidade e qual tipo do atributo do ID dessa entidade
public interface TopicoRepository extends JpaRepository<Topico, Long> {

	List<Topico> findByCurso_Nome(String nomeCurso);


}
