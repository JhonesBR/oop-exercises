package ep2;

/**
 * @author João Vitor Oliveira de Melo - RA: 175079
 */
public class ContaCorrenteComum extends Conta {

    public ContaCorrenteComum(int nConta, String nome, float saldo) {
        super(nConta, nome, saldo);
    }
    
    @Override
    public void extrato() {
        System.out.println("\n----------------------------------------------------------");
        System.out.println("Conta: " + this.nConta + " (Conta Corrente Comum)");
        System.out.println("Nome: " + this.nome);
        System.out.println("Saldo: R$" + String.format("%.2f", this.saldo));
        System.out.println(this.transacoes.get(0).getData());
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