package br.com.votacao.votacao.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * A classe Pauta representa uma pauta de votação.
 * Ela contém informações sobre o título e a descrição da pauta.
 * 
 * Anotações:
 * - @Data: Gera automaticamente getters, setters, equals, hashCode e toString.
 * - @Document: Indica que esta classe é um documento MongoDB.
 * - @Id: Indica o campo que será utilizado como identificador único no MongoDB.
 */

@Data
@Document
public class Pauta {
    @Id
    private String id;
    private String titulo;
    private String descricao;
}
