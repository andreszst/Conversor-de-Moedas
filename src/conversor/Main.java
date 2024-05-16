package conversor;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Conversao conversao = new Conversao();

        Scanner leitura = new Scanner(System.in);

        while(true) {
            System.out.println("************************************************");
            System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]\n");
            System.out.println("1) Dólar =>>> Peso argentino");
            System.out.println("2) Peso argentino =>>> Dólar");
            System.out.println("3) Dólar =>>> Real brasileiro");
            System.out.println("4) Real brasileiro =>>> Dólar");
            System.out.println("5) Dólar =>>> Peso colombiano");
            System.out.println("6) Peso colombiano =>>> Dólar");
            System.out.println("7) Sair");
            System.out.println("Escolha uma opção válida: ");
            System.out.println("************************************************");
            int opcao = leitura.nextInt();
            if (opcao<7 && opcao>0) {
                System.out.println("Digite o valor que deseja converter: ");
                double valor = leitura.nextDouble();
                switch (opcao) {
                    case 1:
                        conversao.setBase("USD");
                        conversao.setAlvo("ARS");
                        break;
                    case 2:
                        conversao.setBase("ARS");
                        conversao.setAlvo("USD");
                        break;
                    case 3:
                        conversao.setBase("USD");
                        conversao.setAlvo("BRL");
                        break;
                    case 4:
                        conversao.setBase("BRL");
                        conversao.setAlvo("USD");
                        break;
                    case 5:
                        conversao.setBase("USD");
                        conversao.setAlvo("COP");
                        break;
                    case 6:
                        conversao.setBase("COP");
                        conversao.setAlvo("USD");
                        break;
                    default:
                        break;
                }
                conversao.converteMoeda(valor);
            } else if (opcao == 7){
                break;
            } else{
                System.out.println("Opção inválida");
            }
        }
    }
}