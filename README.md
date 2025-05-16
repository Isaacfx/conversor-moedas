# 💱 Conversor de Moedas em Tempo Real (Java 21)

Um conversor de moedas em linha de comando que utiliza taxas de câmbio atualizadas em tempo real por meio de uma API externa, permitindo conversões precisas entre moedas globais.

---

## ✨ Funcionalidades

- Consulta de taxas de câmbio em tempo real via ExchangeRate-API.
- Interface interativa no terminal com menu simples para seleção de moedas e valores.
- Suporta conversão bidirecional entre diversas moedas (Dólar, Real, Euro, Peso Argentino).
- Tratamento robusto de erros para entradas inválidas e falhas na comunicação com a API.
- Código organizado seguindo boas práticas de POO e arquitetura limpa.

---

## ⚙️ Pré-requisitos

- Java 21 ou superior instalado.
- Maven para gerenciamento do projeto.
- Chave de API válida do [ExchangeRate-API](https://www.exchangerate-api.com/) (configurada na classe `ClienteApi`).
- Biblioteca Gson gerenciada via Maven.

---

## 🚀 Como usar

1. Clone o repositório:
    ```bash
    git clone https://github.com/seuusuario/conversor-moedas.git
    cd conversor-moedas
    ```

2. Configure sua chave da API no arquivo `ClienteApi.java`:
    ```java
    private static final String apiKey = "SUA_CHAVE_AQUI";
    ```

3. Compile o projeto:
    ```bash
    mvn compile
    ```

4. Execute o programa:
    ```bash
    mvn exec:java -Dexec.mainClass="com.isaac.app.MainConversor"
    ```

5. Use o menu interativo para converter moedas em tempo real.

---

## 🎓 Projeto ONE 

Este conversor de moedas foi desenvolvido como projeto final da fase do Programa ONE, um curso focado em Back-End com Java. A proposta era construir uma aplicação real que integrasse consumo de APIs, tratamento de dados JSON, arquitetura orientada a objetos e interface amigável no terminal.

Com esse projeto, consolidei o aprendizado em desenvolvimento Java moderno, organização de código, tratamento de erros e integração com serviços externos, reforçando habilidades essenciais para atuação profissional como engenheiro de software.

---

Feito com ❤️ por @isaacfx
