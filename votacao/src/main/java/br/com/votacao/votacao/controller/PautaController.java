package br.com.votacao.votacao.controller;

import org.springframework.web.bind.annotation.*;
import br.com.votacao.votacao.model.Pauta;
import br.com.votacao.votacao.service.PautaService;

import java.util.List;

/**
 * PautaController é um controlador REST que gerencia as operações relacionadas às pautas.
 * Ele fornece endpoints para criar uma nova pauta e listar todas as pautas existentes.
 * 
 * Endpoints:
 * - POST /pautas: Cria uma nova pauta.
 * - GET /pautas: Lista todas as pautas.
 * 
 * Este controlador utiliza o PautaService para realizar as operações de negócio.
 */

@RestController
@RequestMapping("/api/pautas")
public class PautaController {
    private final PautaService pautaService;

    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @PostMapping
    public Pauta criarPauta(@RequestBody Pauta pauta) {
        return pautaService.criarPauta(pauta);
    }

    @GetMapping
    public List<Pauta> listarPautas() {
        return pautaService.listarPautas();
    }
}
