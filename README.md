# BuscaFIP 🚗

BuscaFIP é uma aplicação Java com Spring Boot que consome a API pública da Tabela FIPE para consultar marcas, modelos e valores de veículos (carros, motos e caminhões). O projeto foi desenvolvido com foco em aprendizado prático de consumo de APIs REST, manipulação de JSON e construção de menus interativos em Java.

## Funcionalidades

- Consulta de marcas por categoria de veículo
- Filtro de marcas por nome
- Listagem de modelos disponíveis por marca
- Consulta de anos disponíveis por modelo
- Exibição do valor da FIPE por ano, incluindo combustível e código FIPE

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Gson & Jackson (para manipulação de JSON)
- API pública da Tabela FIPE: [https://deividfortuna.github.io/fipe/](https://deividfortuna.github.io/fipe/)

## Estrutura do projeto
src/ <br>
├── main/ <br>
│   ├── java/ <br>
│   │   └── com.ApiCar.ApiCar/ <br>
│   │       ├── Models/ <br> 
│   │       ├── Services/ <br>
│   │       ├── Principal/ <br> 
│   │       └── ApiCarApplication.java <br>
│   └── resources/ <br>
│       └── application.properties <br>

## Autor
Desenvolvido por Gabriel Subutzki Portes como parte de um projeto de estudo e prática com APIs REST em Java.

