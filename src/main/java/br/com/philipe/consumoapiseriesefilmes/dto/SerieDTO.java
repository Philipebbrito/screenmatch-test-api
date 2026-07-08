package br.com.alura.philipe.consumoapiseriesefilmes.dto;

import br.com.alura.philipe.consumoapiseriesefilmes.model.Categoria;


public record SerieDTO(Long id, String titulo, Integer totalTemporadas, Double avaliacao, Categoria genero,
                       String atores, String poster, String sinopse) {
}
