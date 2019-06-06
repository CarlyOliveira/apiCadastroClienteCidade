package com.br.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.cadastro.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	@Query("select c from Cidade c where c.nome = ?1")
	public Iterable<Cidade> findByNome(String nome);

	@Query(value = "select * from Cidade c where c.estado = ?1", nativeQuery = true)
	public Iterable<Cidade> findByEstado(String estado);

}