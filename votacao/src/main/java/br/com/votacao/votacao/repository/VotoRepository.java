package br.com.votacao.votacao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.votacao.votacao.model.Voto;

/**
 * Repositório de votos que estende MongoRepository para fornecer operações CRUD e consultas personalizadas.
 * 
 * Métodos disponíveis:
 * - countByPautaIdAndVoto: Conta o número de votos para uma determinada pauta e valor de voto.
 * - existsByPautaIdAndAssociadoId: Verifica se existe um voto para uma determinada pauta e associado.
 */

public interface VotoRepository extends MongoRepository<Voto, String> {
    long countByPautaIdAndVoto(String pautaId, boolean voto);

    boolean existsByPautaIdAndAssociadoId(String pautaId, String associadoId);
}
