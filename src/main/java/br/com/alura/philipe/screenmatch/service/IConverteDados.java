package br.com.alura.philipe.screenmatch.service;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}
