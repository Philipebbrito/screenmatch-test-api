# ScreenMatch 🎬

Projeto desenvolvido em Java para consumo da API do OMDb, explorando a manipulação de dados de séries e temporadas com foco em Programação Funcional e integração com frameworks modernos.

## 📝 Descrição
O ScreenMatch é uma aplicação de linha de comando que permite ao usuário buscar informações detalhadas sobre séries de TV. O sistema consulta o total de temporadas, lista todos os episódios e processa os dados para exibir um ranking dos **Top 5 episódios** com base nas avaliações do IMDb.

## 🛠️ Tecnologias e Conceitos Utilizados
* **Java 21**: Utilização de recursos modernos como *Records* e *Var*.
* **Spring Boot 3.5.x**: Estrutura base para inicialização e gestão do projeto.
* **Java Streams & Lambdas**: Manipulação eficiente de coleções através de processamento funcional.
* **Jackson Library**: Desserialização de JSON para objetos Java (POJOs/Records).
* **HttpClient**: Realização de requisições HTTP para consumo de dados externos.



## 🧠 Desafios Técnicos Superados

Durante o desenvolvimento, foquei em resolver problemas complexos utilizando as melhores práticas:

* **Achatamento de Coleções com `flatMap`**: O principal desafio foi tratar a estrutura aninhada (uma lista de temporadas contendo listas de episódios). Usei o `flatMap` para unificar todos os episódios em um fluxo único, permitindo uma análise global da série.
* **Pipeline de Processamento**: Implementei uma sequência lógica de operações com Streams:
    1. **Filtragem**: Remoção de registros inconsistentes (avaliações "N/A").
    2. **Ordenação**: Comparação de notas de forma decrescente com `Comparator`.
    3. **Truncamento**: Limitação do resultado para extrair apenas a "elite" dos dados.
* **Imutabilidade e Records**: Optei pelo uso de `Records` para garantir que os dados trafegados entre a API e a aplicação não sofram alterações acidentais, aumentando a segurança do sistema.

## 📖 Dicionário de Anotações (Jackson)

Para realizar a ponte entre o JSON e o Java, utilizei as seguintes anotações:

* **`@JsonAlias`**: Mapeia o nome do campo original da API (ex: `"imdbRating"`) para o nome da nossa variável (ex: `avaliacao`), mantendo o código limpo e seguindo as convenções Java.
* **`@JsonIgnoreProperties(ignoreUnknown = true)`**: Instruiu o conversor a ignorar campos do JSON que não foram mapeados, evitando erros caso a API retorne informações extras.



## 🚀 Como rodar o projeto
1. Clone este repositório.
2. Certifique-se de ter o **JDK 21** instalado.
3. Obtenha uma chave gratuita no [OMDb API](http://www.omdbapi.com/).
4. Substitua a `API_KEY` no arquivo `Principal.java` pela sua chave.
5. Execute a aplicação via IDE ou terminal:
   ```bash
   ./mvnw spring-boot:run

## 🧠 Desafios Técnicos Superados
Durante o desenvolvimento, foquei em resolver problemas complexos utilizando as melhores práticas de Java moderno:
Achatamento de Coleções com flatMap: O maior desafio foi lidar com a estrutura aninhada da API (uma lista de temporadas que continha uma lista de episódios). Utilizei o flatMap para "achatar" esses dados em um fluxo único, permitindo a análise global de todos os episódios da série.
Pipeline de Processamento: Implementei uma sequência lógica de operações com Streams para obter o Top 5:
Filtragem: Remoção de registros com valores nulos ou "N/A".
Ordenação: Comparação de notas de forma decrescente utilizando Comparator.
Truncamento: Limitação do resultado para os 5 melhores registros.
Tratamento de Imutabilidade: Optei pelo uso de Records e analisei a diferença entre .toList() (listas imutáveis) e .collect(Collectors.toList()) (listas mutáveis) para garantir a estabilidade do estado da aplicação.
Lógica Algorítmica: Pratiquei a implementação de expressões lambda complexas, incluindo blocos de código para verificações lógicas, como algoritmos de identificação de números primos e validação de palíndromos.

## 📖 Dicionário de Anotações (Jackson)
Para realizar a ponte entre os dados brutos da API (JSON) e os nossos objetos Java, utilizei a biblioteca Jackson com as seguintes anotações:
@JsonAlias: Utilizada para mapear o nome de um campo que vem da API para o nome da nossa variável no Java. No projeto, foi essencial para converter campos como "imdbRating" (da API) para avaliacao (no nosso Record), permitindo que o código siga as convenções de escrita do Java sem perder a conexão com a fonte.
@JsonIgnoreProperties(ignoreUnknown = true): Uma anotação de segurança aplicada no nível da classe. Ela instrui o conversor a ignorar todos os campos do JSON que não foram explicitamente mapeados em nosso código. Isso evita erros de execução caso a API do OMDB adicione novos campos futuramente que não são do interesse da nossa aplicação.
