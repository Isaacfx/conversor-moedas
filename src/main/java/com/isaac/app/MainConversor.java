package com.isaac.app;

import com.isaac.api.ClienteApi;
import com.isaac.model.Moeda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainConversor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteApi api = new ClienteApi();
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("\n===== CONVERSOR DE MOEDAS =====");
            System.out.println("1. Dólar => Real");
            System.out.println("2. Real => Dólar");
            System.out.println("3. Euro => Real");
            System.out.println("4. Real => Euro");
            System.out.println("5. Peso Argentino => Real");
            System.out.println("6. Real => Peso Argentino");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine(); // limpar buffer
                continue;
            }

            String moedaBase = "";
            String moedaAlvo = "";

            switch (opcao) {
                case 1 -> { moedaBase = "USD"; moedaAlvo = "BRL"; }
                case 2 -> { moedaBase = "BRL"; moedaAlvo = "USD"; }
                case 3 -> { moedaBase = "EUR"; moedaAlvo = "BRL"; }
                case 4 -> { moedaBase = "BRL"; moedaAlvo = "EUR"; }
                case 5 -> { moedaBase = "ARS"; moedaAlvo = "BRL"; }
                case 6 -> { moedaBase = "BRL"; moedaAlvo = "ARS"; }
                case 7 -> {
                    System.out.println("Saindo... Obrigado por usar o Conversor!");
                    continue;
                }
                default -> {
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
                }
            }

            try {
                Moeda moeda = api.buscarDados(moedaBase, moedaAlvo);

                System.out.print("Informe o valor a ser convertido: ");
                double valorOriginal = scanner.nextDouble();

                double taxa = moeda.getConversion_rate();
                double valorConvertido = valorOriginal * taxa;

                System.out.println("\n--- Resultado da Conversão ---");
                System.out.printf("Taxa de Conversão: 1 %s = %.4f %s%n", moedaBase, taxa, moedaAlvo);
                System.out.printf("%.2f %s = %.2f %s%n",
                        valorOriginal, moedaBase, valorConvertido, moedaAlvo);
            } catch (Exception e) {
                System.out.println("Erro durante a conversão: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
