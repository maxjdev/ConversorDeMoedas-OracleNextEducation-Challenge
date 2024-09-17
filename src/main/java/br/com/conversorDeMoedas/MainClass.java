package br.com.conversorDeMoedas;

import br.com.conversorDeMoedas.apis.ExchangeRate;

import java.io.IOException;
import java.util.Scanner;

import static br.com.conversorDeMoedas.utils.Utils.*;

public class MainClass {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        ExchangeRate exchangeRate = new ExchangeRate();

        int opc = 0;
        while (opc != 7) {
            showMenu();
            opc = scan.nextInt();

            switch (opc) {
                case 1 -> processConversion(exchangeRate, scan, "USD", "BRL");
                case 2 -> processConversion(exchangeRate, scan, "BRL", "USD");
                case 3 -> processConversion(exchangeRate, scan, "USD", "ARS");
                case 4 -> processConversion(exchangeRate, scan, "ARS", "USD");
                case 5 -> processConversion(exchangeRate, scan, "USD", "COP");
                case 6 -> processConversion(exchangeRate, scan, "COP", "USD");
                case 7 -> System.out.println("Saindo...");
                default -> System.out.println("Erro, opção inválida, tente novamente!");
            }
        }
    }
}
