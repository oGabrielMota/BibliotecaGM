package br.com.aceleragep.BibliotecaGM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aceleragep.BibliotecaGM.entities.LivroEntity;
import br.com.aceleragep.BibliotecaGM.entities.LivroImagemEntity;

public interface LivroImagemRepository extends JpaRepository<LivroImagemEntity, Long>{

	List<LivroImagemEntity> findAllByLivro(LivroEntity livroLocalizado);

}
