package br.com.votacao.votacao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.votacao.votacao.model.Pauta;

/**
 * Interface de repositório para a entidade Pauta, utilizando MongoDB como armazenamento.
 * Esta interface estende MongoRepository, fornecendo métodos CRUD para a entidade Pauta.
 */

public interface PautaRepository extends MongoRepository<Pauta, String> {}
