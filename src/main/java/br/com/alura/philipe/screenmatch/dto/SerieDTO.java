package br.com.alura.philipe.screenmatch.dto;

import br.com.alura.philipe.screenmatch.model.Categoria;


public record SerieDTO(Long id, String titulo, Integer totalTemporadas, Double avaliacao, Categoria genero,
                       String atores, String poster, String sinopse) {
}
