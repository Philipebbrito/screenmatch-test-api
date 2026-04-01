package br.com.philipe.screenmatch.service.traducao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResponseData(String translatedText) {}
