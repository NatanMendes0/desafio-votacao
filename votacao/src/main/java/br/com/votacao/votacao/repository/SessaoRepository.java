package br.com.votacao.votacao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.votacao.votacao.model.Sessao;

/**
 * Interface de repositório para a entidade Sessao, que estende MongoRepository.
 * Fornece métodos para realizar operações de CRUD (Create, Read, Update, Delete)
 * em documentos Sessao armazenados no MongoDB.
 */

public interface SessaoRepository extends MongoRepository<Sessao, String> {}
