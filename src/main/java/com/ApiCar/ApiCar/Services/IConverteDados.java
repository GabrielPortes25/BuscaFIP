package com.ApiCar.ApiCar.Services;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
