package br.com.alura.philipe.consumoapiseriesefilmes.service.traducao;


import br.com.alura.philipe.consumoapiseriesefilmes.service.ConsumoApi;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ConsultaMyMemory {
    public static String obterTraducao(String text) {
        ObjectMapper mapper = new ObjectMapper();
        ConsumoApi consumo = new ConsumoApi();


        String texto = URLEncoder.encode(text, StandardCharsets.UTF_8);
        String langpair = URLEncoder.encode("en|pt-br", StandardCharsets.UTF_8);
        String url = "https://api.mymemory.translated.net/get?q=" + texto + "&langpair=" + langpair;

        String json = consumo.obterDados(url);

        try {

            DadosTraducao traducao = mapper.readValue(json, DadosTraducao.class);
            return traducao.responseData().translatedText();
        } catch (Exception e) {
            return text;
        }
    }
}