package br.com.aceleragep.BibliotecaGM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aceleragep.BibliotecaGM.entities.LivroEntity;


public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

	List<LivroEntity> findAllByAutoresId(Long id);
}
