package com.ApiCar.ApiCar.Models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosCategoria(@JsonAlias("nome") String nome,
                             @JsonAlias("codigo") String codigo) {

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }


}
