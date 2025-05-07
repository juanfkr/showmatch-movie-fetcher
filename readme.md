# 🎬 ShowMatch | Buscador de Filmes

<p align="center">
  ![banner](https://github.com/user-attachments/assets/b94cbf37-60e5-44d3-8142-856be516d9b5)
</p>

Este projeto Java consulta a [OMDb API](https://www.omdbapi.com/) para buscar informações 
sobre filmes com base em um título fornecido pelo usuário, utilizando **HttpClient** e
a **Gson** para serializar os dados JSON recebidos da API.

## 🧠 Funcionalidades
- Leitura do título do filme via terminal
- Consulta à OMDb API utilizando HTTP
- Desserialização de JSON para objetos Java utilizando a biblioteca `Gson`
- Exibição de informações do filme: nome, ano de lançamento, duração em minutos e horas aproximadas e classificação baseada na data de lançamento.

## 📁 Estrutura do Projeto
```
src/
├── Main.java
├── model/
│   └── Filme.java
├── dto/
│   └── FilmeDTO.java
└── services/
    ├── OmdbClient.java
    └── Serialize.java
```

## ⚙️ Tecnologias Utilizadas
- Java 17+
- [Gson](https://github.com/google/gson) (para serialização JSON)
- Biblioteca [Java HTTP Client](https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/HttpClient.html)
- Chave da [OMDb API](https://www.omdbapi.com/apikey.aspx)

## 📦 Como Usar

1. Clone este repositório:
```bash
git clone https://github.com/juanfkr/omdb-movie-fetcher.git
cd omdb-movie-fetcher
```

2. Adicione sua chave da OMDb API:

No arquivo `Main.java`, insira sua chave de API no campo `API_KEY`:
```java
final String API_KEY = "SUA_CHAVE_AQUI";
```

3. Compile e execute o projeto:

Se estiver usando a linha de comando com `javac`:
```bash
javac -d out src/**/*.java
java -cp out Main
```

4. Digite o nome de um filme quando solicitado e veja as informações retornadas.

## 📌 Exemplo de Saída
```
Digite o nome do filme: Gladiator
Nome: Gladiator
Ano de lançamento: 2000
Duração: 155min | ~3.0h
Classificação: Filme antigo
```
