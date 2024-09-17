package br.com.conversorDeMoedas.utils;

import br.com.conversorDeMoedas.apis.ExchangeRate;
import br.com.conversorDeMoedas.dtos.ExchangeDTO;

import java.io.IOException;
import java.util.Scanner;

public class Utils {
    public static void showMenu() {
        System.out.println("""
                \n*************************************
                Bem vindo/a ao Conversor de Moedas $.$\n
                Digite o número da conversão desejada:\n
                1) Dólar americano --> Real brasileiro
                2) Real brasileiro --> Dólar americano
                3) Dólar americano --> Peso argentino
                4) Peso argentino --> Dólar americano
                5) Dólar americano --> Peso colombiano
                6) Peso colombiano --> Dólar americano
                7) Sair\n
                ***************************************""");
    }

    public static void processConversion(ExchangeRate exchangeRate, Scanner scanner, String coinBase, String coinTarget) throws IOException, InterruptedException {
        System.out.println("\nInforme o valor que deseja converter: ");
        double valueToConvert = scanner.nextDouble();

        ExchangeDTO conversion = exchangeRate.converter(coinBase, coinTarget, valueToConvert);
        System.out.printf("\nValor: %.2f [%s] corresponde ao valor => %.2f [%s]\n",
                valueToConvert, conversion.base_code(), conversion.conversion_result(), conversion.target_code());
    }
}
