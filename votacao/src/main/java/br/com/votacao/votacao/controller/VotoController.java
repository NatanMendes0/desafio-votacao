package br.com.votacao.votacao.controller;

import br.com.votacao.votacao.service.VotoService;
import br.com.votacao.votacao.model.Voto;
import org.springframework.web.bind.annotation.*;

/**
 * VotoController é um controlador REST responsável por gerenciar as operações de votação.
 * Ele permite que os usuários registrem seus votos e obtenham o resultado da votação para uma pauta específica.
 * 
 * Métodos:
 * - votar: Registra um novo voto.
 * - contarVotos: Retorna o resultado da votação para uma pauta específica, contando os votos "Sim" e "Não".
 */

@RestController
@RequestMapping("/votos")
public class VotoController {
    private final VotoService votoService;

    public VotoController(VotoService votoService) {
        this.votoService = votoService;
    }

    @PostMapping
    public Voto votar(@RequestBody Voto voto) {
        return votoService.votar(voto);
    }

    @GetMapping("/{pautaId}/resultado")
    public String contarVotos(@PathVariable String pautaId) {
        long votosSim = votoService.contarVotos(pautaId, true);
        long votosNao = votoService.contarVotos(pautaId, false);
        return "Resultado: Sim = " + votosSim + ", Não = " + votosNao;
    }
}
