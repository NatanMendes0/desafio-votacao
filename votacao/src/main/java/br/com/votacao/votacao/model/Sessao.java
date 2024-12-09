package br.com.votacao.votacao.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * A classe Sessao representa uma sessão de votação.
 * Cada sessão possui um identificador único, um identificador da pauta associada,
 * e os horários de início e fim da sessão.
 */

@Data
@Document
public class Sessao {
    @Id
    private String id;
    private String pautaId;
    private LocalDateTime inicio;
    private LocalDateTime fim;
}
