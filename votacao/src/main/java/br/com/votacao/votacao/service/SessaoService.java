package br.com.votacao.votacao.service;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

import br.com.votacao.votacao.model.Sessao;
import br.com.votacao.votacao.repository.SessaoRepository;

/**
 * Serviço responsável por gerenciar sessões de votação.
 * 
 * Este serviço permite abrir uma nova sessão de votação para uma pauta específica,
 * definindo a duração da sessão em minutos. Caso a duração não seja especificada,
 * a sessão terá a duração padrão de 1 minuto.
 * 
 * Dependências:
 * - SessaoRepository: Repositório para persistência das sessões de votação.
 * 
 * Métodos:
 * - abrirSessao(String pautaId, Integer duracaoEmMinutos): Abre uma nova sessão de votação
 *   para a pauta especificada, com a duração informada.
 * - listarSessoesAbertas(): Lista todas as sessões de votação abertas com base no horário.
 */
@Service
public class SessaoService {
    private final SessaoRepository sessaoRepository;

    public SessaoService(SessaoRepository sessaoRepository) {
        this.sessaoRepository = sessaoRepository;
    }

    public Sessao abrirSessao(String pautaId, Integer duracaoEmMinutos) {
        Sessao sessao = new Sessao();
        sessao.setPautaId(pautaId);
        sessao.setInicio(LocalDateTime.now());
        sessao.setFim(LocalDateTime.now().plusMinutes(duracaoEmMinutos != null ? duracaoEmMinutos : 1));
        return sessaoRepository.save(sessao);
    }

    public List<Sessao> listarSessoesAbertas() {
        return sessaoRepository.findAll().stream()
                .filter(sessao -> sessao.getFim().isAfter(LocalDateTime.now()))
                .toList();
    }
}
