package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	// forma comum de pesquisar
	List<Topico> findByCursoNome(String nomeCurso);

	// formar de pesquisar pelo id
	Topico getReferenceById(Long id);

	// forma de pesquisar se co existir um mesmo nome
	// List<Topico> findByCurso_Nome(String nomeCurso);

	// @Query("") Forma de pesquisar mais complexa
	// List<Topico> nomeQueQuiser(String nomeCurso);

}
