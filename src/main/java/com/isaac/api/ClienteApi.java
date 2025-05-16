package com.isaac.api;

import com.google.gson.Gson;
import com.isaac.model.Moeda;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ClienteApi {

    private final String apiKey = "5e037f6d84e307d7fd33791b"; // Substitua por variável de ambiente se possível

    public Moeda buscarDados(String moedaBase, String moedaAlvo) {
        String endereco = "https://v6.exchangerate-api.com/v6/" + apiKey +
                "/pair/" + moedaBase + "/" + moedaAlvo;

        try {
            URL url = new URL(endereco);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");
            conexao.connect();

            int codigoResposta = conexao.getResponseCode();

            if (codigoResposta != 200) {
                throw new RuntimeException("Erro: " + codigoResposta);
            }

            Scanner scanner = new Scanner(url.openStream());
            StringBuilder respostaJson = new StringBuilder();
            while (scanner.hasNext()) {
                respostaJson.append(scanner.nextLine());
            }
            scanner.close();

            Gson gson = new Gson();
            return gson.fromJson(respostaJson.toString(), Moeda.class);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao buscar dados da API: " + e.getMessage());
        }
    }
}
