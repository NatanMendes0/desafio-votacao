package br.com.votacao.votacao.service;

import br.com.votacao.votacao.model.Pauta;
import br.com.votacao.votacao.repository.PautaRepository;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * A classe PautaService é responsável por gerenciar as operações relacionadas às pautas.
 * Ela utiliza o repositório PautaRepository para realizar operações de criação e listagem de pautas.
 * 
 * Métodos:
 * - criarPauta(Pauta pauta): Cria uma nova pauta e a salva no repositório.
 * - listarPautas(): Retorna uma lista de todas as pautas cadastradas no repositório.
 */

@Service
public class PautaService {
    private final PautaRepository pautaRepository;

    public PautaService(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    public Pauta criarPauta(Pauta pauta) {
        return pautaRepository.save(pauta);
    }

    public List<Pauta> listarPautas() {
        return pautaRepository.findAll();
    }
}
