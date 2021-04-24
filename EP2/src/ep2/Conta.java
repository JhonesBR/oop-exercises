package ep2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author João Vitor Oliveira de Melo - RA: 175079
 */
public abstract class Conta {
    protected int nConta;
    protected String nome;
    protected float saldo;
    
    protected List<Transacao> transacoes = new ArrayList<Transacao>();

    public Conta(int nConta, String nome, float saldo) {
        this.nConta = nConta;
        this.nome = nome;
        this.saldo = saldo;
    }
    
    public void deposito(float valor) {
        this.saldo += valor;
        transacao(valor, "Deposito");
    }
    
    public void retirada(float valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            transacao(valor, "Retirada");
        }
    }
    
    public void extrato() {
        
    }
    
    protected void transacao(float valor, String type) {
        Date currentData = new Date();
        SimpleDateFormat df;
        df = new SimpleDateFormat("dd/MM/yyyy");
        String data = df.format(currentData);
        
        Transacao t = new Transacao(data, valor, type);
        transacoes.add(t);
    }
}