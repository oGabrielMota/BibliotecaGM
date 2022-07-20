package br.com.aceleragep.BibliotecaGM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aceleragep.BibliotecaGM.entities.AutorEntity;


@Repository
public interface AutorRepository extends JpaRepository <AutorEntity, Long> {

}
