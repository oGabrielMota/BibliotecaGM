package br.com.aceleragep.BibliotecaGM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aceleragep.BibliotecaGM.entities.AutorEntity;

public interface AutorRepository extends JpaRepository <AutorEntity, Long> {

}
