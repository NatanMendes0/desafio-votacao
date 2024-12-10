package br.com.votacao.votacao.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoVoto {
    SIM("Sim"),
    NAO("Nao");

    private final String descricao;

    TipoVoto(String descricao) {
        this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static TipoVoto fromValue(String value) {
        for (TipoVoto tipo : TipoVoto.values()) {
            if (tipo.descricao.equalsIgnoreCase(value)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Valor invalido para o tipo de voto: " + value);
    }
}
