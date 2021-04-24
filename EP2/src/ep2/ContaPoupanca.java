package ep2;

import static java.lang.Integer.parseInt;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author João Vitor Oliveira de Melo - RA: 175079
 */
public class ContaPoupanca extends Conta {
    private int diaAniversario;

    public ContaPoupanca(int nConta, String nome, float saldo) {
        super(nConta, nome, saldo);
        Date currentData = new Date();
        SimpleDateFormat df;
        df = new SimpleDateFormat("dd");
        String data = df.format(currentData);
        this.diaAniversario = parseInt(data);
    }
    
    @Override
    public void extrato() {
        System.out.println("\n----------------------------------------------------------");
        System.out.println("Conta: " + this.nConta + " (Conta Corrente Poupança)");
        System.out.println("Nome: " + this.nome);
        System.out.println("Saldo: R$" + String.format("%.2f", this.saldo));
        System.out.println("Aniversário da conta: " + String.format("%02d", this.diaAniversario));
        if (this.transacoes.size() > 0) {  
            System.out.println("Transações: ");
            for (int i=0; i<this.transacoes.size(); i++) {
                System.out.println("\t" + this.transacoes.get(i).getData() + " "
                        + this.transacoes.get(i).getDescricao() +
                        " de R$" + String.format("%.2f", this.transacoes.get(i).getValor()));
            }
        }
        System.out.println("----------------------------------------------------------\n");
    }
    
}