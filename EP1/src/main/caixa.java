package main;

/**
 * @author Joao Vitor Oliveira de Melo 175079
 */
public class caixa {
    private int nConta;
    private String nome;
    private float saldo;

    public caixa(int nConta, String nome) {
        this.nConta = nConta;
        this.nome = nome;
        this.saldo = 0;
    }
    
    public void deposito(float valor) {
        this.saldo = this.saldo + valor;
        System.out.println("Depósito de R$" + String.format("%.2f", valor) + " realizado na conta " + this.nConta);
        System.out.println("Novo saldo: R$"+ String.format("%.2f", this.saldo) + "\n");
    }
    
    public void transferencia(caixa b, float valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            b.setSaldo(b.getSaldo() + valor);
            System.out.println("Transferência realizada com sucesso");
            System.out.println("Remetente: Conta " + this.nConta);
            System.out.println("Destinatário: Conta " + b.getnConta());
            System.out.println("Valor: R$" + String.format("%.2f", valor) + "\n");
        } else {
            System.out.println("Saldo insuficiente para transferência\n");
        }
    }
    
    public void saque(float valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque de R$" + String.format("%.2f", valor) + " realizado com sucesso");
            System.out.println("Novo saldo: R$"+ String.format("%.2f", this.saldo) + "\n");
        } else {
            System.out.println("Saldo insuficiente para saque\n");
        }
    }
    
    public void pagamento(float valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Pagemento de R$" + String.format("%.2f", valor) + " realizado com sucesso");
            System.out.println("Novo saldo: R$"+ String.format("%.2f", this.saldo) + "\n");
        } else {
            System.out.println("Saldo insuficiente para pagamento\n");
        }
    }
    
    public void consultaSaldo() {
        System.out.println("Saldo da conta " + this.nConta + ":");
        System.out.println("R$" + String.format("%.2f", this.saldo) + "\n");
    }
    
    private float getSaldo() {
        return saldo;
    }

    private void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    private int getnConta() {
        return nConta;
    }
    
}