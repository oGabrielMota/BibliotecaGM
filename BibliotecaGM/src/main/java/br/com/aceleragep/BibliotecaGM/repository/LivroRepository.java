package br.com.aceleragep.BibliotecaGM.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aceleragep.BibliotecaGM.entities.LivroEntity;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

	Page<LivroEntity> findAllByAutoresId(Long id, Pageable paginacao);
}
