package com.ApiCar.ApiCar.Models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosModelos(@JsonAlias("modelos") List<DadosMarca> modelos
) {

}
