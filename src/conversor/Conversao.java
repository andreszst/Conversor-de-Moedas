package conversor;

import java.io.IOException;

public class Conversao {
    Requisicao requisicao = new Requisicao();

    private String base;
    private String alvo;

    public void setAlvo(String alvo) {
        this.alvo = alvo;
    }
    public void setBase(String base) {
        this.base = base;
    }
    public void converteMoeda(double valor) throws IOException, InterruptedException {
        double taxa = requisicao.getTaxa(base, alvo);
        double valorFinal = taxa * valor;
        System.out.println("Valor " + valor + " [" + base + "] "
                + "corresponde ao valor final de =>>> " + valorFinal + " [" + alvo + "]");
    }
}
