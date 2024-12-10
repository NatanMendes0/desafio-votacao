package br.com.votacao.votacao.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.votacao.votacao.model.enums.TipoVoto;
import lombok.Data;

/**
 * A classe Voto representa um voto em uma determinada pauta de votação.
 * Cada voto é associado a um ID de pauta e a um ID de associado.
 * O campo 'voto' utiliza o enum TipoVoto para indicar o voto como "SIM" ou "NAO".
 */

@Data
@Document
public class Voto {
    @Id
    private String id;
    private String pautaId;
    private String associadoId;
    private TipoVoto voto; // Enum para "SIM" ou "NAO"
}
