package br.com.votacao.votacao.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * A classe Voto representa um voto em uma determinada pauta de votação.
 * Cada voto é associado a um ID de pauta e a um ID de associado.
 * O campo 'voto' indica se o voto é a favor (true) ou contra (false) a pauta.
 */

@Data
@Document
public class Voto {
    @Id
    private String id;
    private String pautaId;
    private String associadoId;
    private boolean voto; // true para sim, false para não
}
