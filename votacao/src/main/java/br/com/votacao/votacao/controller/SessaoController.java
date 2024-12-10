package br.com.votacao.votacao.controller;

import br.com.votacao.votacao.service.SessaoService;
import br.com.votacao.votacao.model.Sessao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gerenciar sessões de votação.
 * 
 * Este controlador fornece:
 * - Endpoint para abrir uma nova sessão de votação para uma pauta específica.
 * - Endpoint para listar todas as sessões de votação abertas.
 */
@RestController
@RequestMapping("/api/sessoes") // Ajuste para refletir o caminho completo no endpoint.
public class SessaoController {
    private final SessaoService sessaoService;

    public SessaoController(SessaoService sessaoService) {
        this.sessaoService = sessaoService;
    }

    @PostMapping("/{pautaId}")
    public Sessao abrirSessao(@PathVariable String pautaId, @RequestParam(required = false) Integer duracaoEmMinutos) {
        return sessaoService.abrirSessao(pautaId, duracaoEmMinutos);
    }

    @GetMapping
    public List<Sessao> listarSessoesAbertas() {
        return sessaoService.listarSessoesAbertas();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
