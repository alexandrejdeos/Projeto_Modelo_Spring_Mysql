package br.com.lds.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import br.com.lds.model.entity.Acao;

@Repository
public interface AcaoRepository extends JpaRepository<Acao, Long>, QueryDslPredicateExecutor<Acao>{
	
}
