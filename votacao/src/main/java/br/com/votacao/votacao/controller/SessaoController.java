package br.com.votacao.votacao.controller;

import br.com.votacao.votacao.service.SessaoService;
import br.com.votacao.votacao.model.Sessao;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gerenciar sessões de votação.
 * 
 * Este controlador fornece um endpoint para abrir uma nova sessão de votação
 * para uma pauta específica. A duração da sessão pode ser especificada opcionalmente.
 * 
 * Endpoints:
 * - POST /sessoes/{pautaId}: Abre uma nova sessão de votação para a pauta especificada.
 * 
 * @param sessaoService Serviço responsável pelas operações relacionadas às sessões de votação.
 */

@RestController
@RequestMapping("/sessoes")
public class SessaoController {
    private final SessaoService sessaoService;

    public SessaoController(SessaoService sessaoService) {
        this.sessaoService = sessaoService;
    }

    @PostMapping("/{pautaId}")
    public Sessao abrirSessao(@PathVariable String pautaId, @RequestParam(required = false) Integer duracaoEmMinutos) {
        return sessaoService.abrirSessao(pautaId, duracaoEmMinutos);
    }
}
