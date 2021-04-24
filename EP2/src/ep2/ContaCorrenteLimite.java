package ep2;

/**
 * @author João Vitor Oliveira de Melo - RA: 175079
 */
public class ContaCorrenteLimite extends Conta {
    private float valorLimite;

    public ContaCorrenteLimite(int nConta, String nome, float saldo, float valorLimite) {
        super(nConta, nome, saldo);
        this.valorLimite = valorLimite;
    }
    
    @Override
    public void retirada(float valor) {
        if (this.saldo - valor >= -this.valorLimite) {
            this.saldo -= valor;
            transacao(valor, "Retirada");
        }
    }
    
    @Override
    public void extrato() {
        System.out.println("\n----------------------------------------------------------");
        System.out.println("Conta: " + this.nConta + " (Conta Corrente Limite)");
        System.out.println("Nome: " + this.nome);
        System.out.println("Saldo: R$" + String.format("%.2f", this.saldo));
        System.out.println("Limite: R$" + String.format("%.2f", this.valorLimite));
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