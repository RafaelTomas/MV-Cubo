package br.com.alura.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	// forma comum de pesquisar
	Page<Topico> findByCursoNome(String nomeCurso, Pageable paginacao);

	// formar de pesquisar pelo id
	Topico getReferenceById(Long id);

	// forma de pesquisar se co existir um mesmo nome
	// List<Topico> findByCurso_Nome(String nomeCurso);

	// @Query("") Forma de pesquisar mais complexa
	// List<Topico> nomeQueQuiser(String nomeCurso);

}
