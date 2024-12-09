package br.com.votacao.votacao.service;

import br.com.votacao.votacao.repository.VotoRepository;
import br.com.votacao.votacao.model.Voto;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável pela lógica de votação.
 * 
 * Este serviço fornece métodos para registrar votos e contar votos em uma determinada pauta.
 * 
 * Métodos:
 * - votar(Voto voto): Registra um voto, verificando se o associado já votou na pauta.
 * - contarVotos(String pautaId, boolean voto): Conta o número de votos em uma pauta específica, filtrando por tipo de voto (sim ou não).
 * 
 * Dependências:
 * - VotoRepository: Repositório para acesso aos dados de votos.
 */

@Service
public class VotoService {
    private final VotoRepository votoRepository;

    public VotoService(VotoRepository votoRepository) {
        this.votoRepository = votoRepository;
    }

    public Voto votar(Voto voto) {
        if (votoRepository.existsByPautaIdAndAssociadoId(voto.getPautaId(), voto.getAssociadoId())) {
            throw new RuntimeException("Associado já votou nesta pauta.");
        }
        return votoRepository.save(voto);
    }

    public long contarVotos(String pautaId, boolean voto) {
        return votoRepository.countByPautaIdAndVoto(pautaId, voto);
    }
}
