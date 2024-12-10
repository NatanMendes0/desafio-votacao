package br.com.votacao.votacao.controller;

import br.com.votacao.votacao.service.VotoService;
import br.com.votacao.votacao.model.Voto;
import br.com.votacao.votacao.model.enums.TipoVoto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/votos")
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
        long votosSim = votoService.contarVotos(pautaId, TipoVoto.SIM);
        long votosNao = votoService.contarVotos(pautaId, TipoVoto.NAO);
        // return "Resultado: Sim = " + votosSim + ", Não = " + votosNao;
        // return "Resultado: da pauta No." + pautaId + " Sim = " + votosSim + ", Não = " + votosNao;
        String nomePauta = votoService.obterNomePauta(pautaId);
        return "Resultado da pauta \"" + nomePauta + "\": Sim = " + votosSim + ", Não = " + votosNao;
        
    }   

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
