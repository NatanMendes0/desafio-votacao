package br.com.votacao.votacao.service;

import br.com.votacao.votacao.model.Pauta;
import br.com.votacao.votacao.model.Voto;
import br.com.votacao.votacao.model.enums.TipoVoto;
import br.com.votacao.votacao.repository.PautaRepository;
import br.com.votacao.votacao.repository.VotoRepository;

import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * Serviço responsável pela lógica de votação.
 * 
 * Este serviço fornece métodos para registrar votos e contar votos em uma
 * determinada pauta.
 * 
 * Métodos:
 * - votar(Voto voto): Registra um voto, verificando se o associado já votou na
 * pauta.
 * - contarVotos(String pautaId, boolean voto): Conta o número de votos em uma
 * pauta específica, filtrando por tipo de voto (sim ou não).
 * 
 * Dependências:
 * - VotoRepository: Repositório para acesso aos dados de votos.
 */

@Service
public class VotoService {
    private final VotoRepository votoRepository;
    private final PautaRepository pautaRepository;

    public VotoService(VotoRepository votoRepository, PautaRepository pautaRepository) {
        this.votoRepository = votoRepository;
        this.pautaRepository = pautaRepository;
    }

    public Voto votar(Voto voto) {
        if (votoRepository.existsByPautaIdAndAssociadoId(voto.getPautaId(), voto.getAssociadoId())) {
            throw new IllegalArgumentException("Associado ja votou nesta pauta!");
        }
        return votoRepository.save(voto);
    }

    public long contarVotos(String pautaId, TipoVoto tipoVoto) {
        return votoRepository.countByPautaIdAndVoto(pautaId, tipoVoto);
    }

    public String obterNomePauta(String pautaId) {
        Optional<Pauta> nomePauta = pautaRepository.findById(pautaId);
        if (nomePauta.isPresent()) {
            return nomePauta.get().getTitulo();
        } else {
            throw new IllegalArgumentException("Pauta não encontrada!");
        }
    }
}
