package br.com.philipe.screenmatch.dto;

import br.com.philipe.screenmatch.model.Categoria;


public record SerieDTO(Long id, String titulo, Integer totalTemporadas, Double avaliacao, Categoria genero,
                       String atores, String poster, String sinopse) {
}
